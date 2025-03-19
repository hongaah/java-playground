package cn.itsource.springbootdemo.mapper;

import cn.itsource.springbootdemo.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserMapper {
    @Select("select * from user where name = #{name}")
    public User getUserByName(String name);
}
