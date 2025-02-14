package cn.itsource.springboothello01.service.impl;

import cn.itsource.springboothello01.domain.User;
import cn.itsource.springboothello01.mapper.UserXmlMapper;
import cn.itsource.springboothello01.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
public class IUserServiceImpl implements IUserService {
    @Autowired
    private UserXmlMapper mapper;

    @Override
    public List<User> findAll() {
        return mapper.findAll();
    }

    @Override
    @Transactional
    public void save(User user) {
        mapper.save(user);
    }
}
