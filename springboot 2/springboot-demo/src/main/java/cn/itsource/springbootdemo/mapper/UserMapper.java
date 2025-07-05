package cn.itsource.springbootdemo.mapper;

import cn.itsource.springbootdemo.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserMapper {
    @Select("select * from user where name = #{name}")
    public User getUserByName(String name);

    @Insert("insert into user(name, age) values(#{user.name}, #{user.age})")
    Integer insertUser(@Param("user") User user);
}
