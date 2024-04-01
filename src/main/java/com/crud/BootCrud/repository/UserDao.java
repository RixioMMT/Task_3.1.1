package com.crud.BootCrud.repository;

import com.crud.BootCrud.model.User;

import java.util.List;

public interface UserDao {
    public List<User> findAll();
    public void save(User user);
    public void delete(Long id);
    public User find(Long id);
    public void update(User user);
}
