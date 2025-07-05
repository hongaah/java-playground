
# Spring Boot + MyBatis 优化方案

构建：通过 maven mybatis 插件构建可自动生成 mapper xml model
extend: 个性化配置 mysql 语句

## 构建配置

### 1. Maven 配置

在 `pom.xml` 中添加 MyBatis 和 MyBatis Generator 插件依赖：

```xml
<dependencies>
    <!-- Spring Boot Starter -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>
    
    <!-- MyBatis Spring Boot Starter -->
    <dependency>
        <groupId>org.mybatis.spring.boot</groupId>
        <artifactId>mybatis-spring-boot-starter</artifactId>
        <version>2.2.0</version>
    </dependency>
    
    <!-- MySQL Connector -->
    <dependency>
        <groupId>mysql</groupId>
        <artifactId>mysql-connector-java</artifactId>
        <scope>runtime</scope>
    </dependency>
    
    <!-- Lombok (可选) -->
    <dependency>
        <groupId>org.projectlombok</groupId>
        <artifactId>lombok</artifactId>
        <optional>true</optional>
    </dependency>
</dependencies>

<build>
    <plugins>
        <!-- MyBatis Generator 插件 -->
        <plugin>
            <groupId>org.mybatis.generator</groupId>
            <artifactId>mybatis-generator-maven-plugin</artifactId>
            <version>1.4.0</version>
            <configuration>
                <configurationFile>src/main/resources/generatorConfig.xml</configurationFile>
                <overwrite>true</overwrite>
                <verbose>true</verbose>
            </configuration>
            <dependencies>
                <dependency>
                    <groupId>mysql</groupId>
                    <artifactId>mysql-connector-java</artifactId>
                    <version>8.0.23</version>
                </dependency>
            </dependencies>
        </plugin>
    </plugins>
</build>
```

### 2. MyBatis Generator 配置文件

创建 `src/main/resources/generatorConfig.xml`：

```xml
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE generatorConfiguration
        PUBLIC "-//mybatis.org//DTD MyBatis Generator Configuration 1.0//EN"
        "http://mybatis.org/dtd/mybatis-generator-config_1_0.dtd">

<generatorConfiguration>
    <context id="mysql" targetRuntime="MyBatis3">
        <!-- 自定义扩展配置 -->
        <plugin type="org.mybatis.generator.plugins.SerializablePlugin"/>
        <plugin type="org.mybatis.generator.plugins.ToStringPlugin"/>
        
        <!-- 注释配置 -->
        <commentGenerator>
            <property name="suppressDate" value="true"/>
            <property name="suppressAllComments" value="false"/>
        </commentGenerator>
        
        <!-- 数据库连接 -->
        <jdbcConnection driverClass="com.mysql.cj.jdbc.Driver"
                        connectionURL="jdbc:mysql://localhost:3306/your_database"
                        userId="your_username"
                        password="your_password">
            <property name="nullCatalogMeansCurrent" value="true"/>
        </jdbcConnection>
        
        <!-- 模型生成配置 -->
        <javaModelGenerator targetPackage="com.example.model" targetProject="src/main/java">
            <property name="enableSubPackages" value="true"/>
            <property name="trimStrings" value="true"/>
        </javaModelGenerator>
        
        <!-- Mapper XML 生成配置 -->
        <sqlMapGenerator targetPackage="mapper" targetProject="src/main/resources">
            <property name="enableSubPackages" value="true"/>
        </sqlMapGenerator>
        
        <!-- Mapper 接口生成配置 -->
        <javaClientGenerator type="XMLMAPPER" targetPackage="com.example.mapper" targetProject="src/main/java">
            <property name="enableSubPackages" value="true"/>
        </javaClientGenerator>
        
        <!-- 表配置 -->
        <table tableName="%">
            <generatedKey column="id" sqlStatement="MySql" identity="true"/>
        </table>
    </context>
</generatorConfiguration>
```

## 个性化扩展方案

### 1. 自定义基础 Mapper 接口

创建基础 Mapper 接口 `BaseMapper.java`：

```java
package com.example.mapper;

import java.util.List;

public interface BaseMapper<T> {
    int deleteByPrimaryKey(Long id);

    int insert(T record);

    int insertSelective(T record);

    T selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(T record);

    int updateByPrimaryKey(T record);

    List<T> selectAll();
}
```

### 2. 自定义扩展 Mapper

对于需要扩展的 Mapper，创建新的接口继承自动生成的 Mapper 和基础 Mapper：

```java
package com.example.mapper.extend;

import com.example.mapper.UserMapper;
import com.example.mapper.BaseMapper;
import com.example.model.User;

public interface UserExtendMapper extends UserMapper, BaseMapper<User> {
    // 自定义方法
    List<User> selectByCondition(User condition);
}
```

### 3. 自定义 XML 扩展

在 `src/main/resources/mapper/extend` 目录下创建扩展 XML：

```xml
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="com.example.mapper.extend.UserExtendMapper">
    <select id="selectByCondition" parameterType="com.example.model.User" resultMap="BaseResultMap">
        select * from user
        <where>
            <if test="username != null and username != ''">
                and username like concat('%', #{username}, '%')
            </if>
            <if test="status != null">
                and status = #{status}
            </if>
        </where>
    </select>
</mapper>
```

## 使用说明

1. 运行 MyBatis Generator 生成基础代码：
   ```
   mvn mybatis-generator:generate
   ```

2. 对于需要扩展的功能：
   - 创建新的 ExtendMapper 接口
   - 在 extend 目录下创建对应的 XML
   - 在 Service 中注入 ExtendMapper 而非基础 Mapper

3. 配置 Spring Boot 扫描 Extend Mapper：
   ```java
   @MapperScan(basePackages = {"com.example.mapper", "com.example.mapper.extend"})
   @SpringBootApplication
   public class Application {
       public static void main(String[] args) {
           SpringApplication.run(Application.class, args);
       }
   }
   ```

## 优化建议

1. 使用 MyBatis 注解与 XML 混合模式
2. 添加 PageHelper 分页插件
3. 使用二级缓存提高性能
4. 对于复杂查询，考虑使用 MyBatis Dynamic SQL
5. 添加自定义 TypeHandler 处理特殊类型
