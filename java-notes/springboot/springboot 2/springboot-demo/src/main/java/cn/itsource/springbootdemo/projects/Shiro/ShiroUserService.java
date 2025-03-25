package cn.itsource.springbootdemo.projects.Shiro;

import org.springframework.stereotype.Service;
import jakarta.annotation.Resource;
import java.util.Set;

@Service
public class ShiroUserService {

    @Resource
    private UserDao userDao;

    public User getByUsername(String username) {
        return userDao.getByUsername(username);
    }

    public Set<String> getRoles(String username) {
        return userDao.getRoles(username);
    }

    public Set<String> getPermissions(String username) {
        return userDao.getPermissions(username);
    }
}
