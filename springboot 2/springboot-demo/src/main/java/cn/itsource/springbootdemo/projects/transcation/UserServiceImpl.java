package cn.itsource.springbootdemo.projects.transcation;

import cn.itsource.springbootdemo.entity.User;
import cn.itsource.springbootdemo.mapper.UserMapper;
import jakarta.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;

@Service
public class UserServiceImpl implements UserService {
    public static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Resource
    private UserMapper userMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void insertUser(User user) throws Exception {
        logger.info("插入用户：{}", user);
        userMapper.insertUser(user);

        // 不要在这里 try...catch，因为这里的异常会被捕获，导致事务无法回滚
        // throw new RuntimeException("测试事务");
        throw new SQLException("测试事务");
    }

    @Override
    public User getUserByName(String name) {
        return userMapper.getUserByName(name);
    }

}
