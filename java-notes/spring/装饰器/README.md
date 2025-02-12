
@RestController = @Controller + @ResponseBody
@RestController：这意味着所有方法默认返回 JSON 或字符串

@ResponseBody ： 该注解用于将Controller 的方法返回对象， 通过适当的HttpMessageConverter转换为指定格式后，写入Response对象的body数据区。
@Controller
@RequestMapping ：用来处理请求地址映射的注解，可用于类或方法上。也可以写作 GetMapping 、PostMapping、PutMapping 、DeleteMapping 、PatchMapping。



@PropertySource：加载指定的配置文件
@PropertySource("classpath:person.properties")


@ImportResource：导入Spring的配置文件，让配置文件里面的内容生效--标注在一个配置类上
@ImportResource(locations = {"classpath:beans.xml"})


@Conditional注解


```java
@Mapper //指定这是一个操作数据库的mapper
public interface DepartmentMapper {

    @Select("select * from department where id=#{id}")
    public Department getDeptById(Integer id);

    @Delete("delete from department where id=#{id}")
    public int deleteDeptById(Integer id);

    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into department(departmentName) values (#{departmentName})")
    public int insertDept(Department department);

    @Update("update department set departmentName=#{departmentName} where id=#{id}")
    public int updateDept(Department department);
}


@GetMapping("/emp/{id}")
public Employee getEmp(@PathVariable("id") Integer id) {
    return employeeMapper.getEmpById(id);
    // 测试链接：http://localhost:8080/emp/1
    // 返回：{"id":1,"lastName":"Wang","gender":1,"email":"1111@qq.com","dId":1}
}

```
