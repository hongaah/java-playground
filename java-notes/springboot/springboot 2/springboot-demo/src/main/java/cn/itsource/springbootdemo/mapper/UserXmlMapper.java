package cn.itsource.springbootdemo.mapper;

import cn.itsource.springbootdemo.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserXmlMapper {
    User getUserByName(String username);
}
