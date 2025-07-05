package cn.itsource.springbootdemo.projects.transcation;

import cn.itsource.springbootdemo.entity.User;

public interface UserService {

    public void insertUser(User user) throws Exception;

    public User getUserByName(String name);
}
