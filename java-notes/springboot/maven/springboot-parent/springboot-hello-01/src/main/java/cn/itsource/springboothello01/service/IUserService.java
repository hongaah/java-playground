package cn.itsource.springboothello01.service;

import cn.itsource.springboothello01.domain.User;

import java.util.List;

public interface IUserService {
    List<User> findAll();
    void save(User user);
}
