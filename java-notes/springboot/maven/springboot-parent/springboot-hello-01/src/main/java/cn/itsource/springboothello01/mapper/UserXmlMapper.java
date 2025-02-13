package cn.itsource.springboothello01.mapper;

import cn.itsource.springboothello01.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserXmlMapper {

    public List<User> findAll();
}
