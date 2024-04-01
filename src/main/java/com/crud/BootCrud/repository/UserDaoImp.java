package com.crud.BootCrud.repository;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.crud.BootCrud.model.User;

import jakarta.persistence.*;
import java.util.List;

@Repository
@Transactional
public class UserDaoImp implements UserDao {
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public List<User> findAll() {
        return entityManager.createNativeQuery("SELECT * FROM Users", User.class).getResultList();
    }
    @Override
    public void save(User user) {
        entityManager.persist(user);
    }
    @Override
    public void delete(Long id) {
        User user = entityManager.find(User.class, id);
        entityManager.remove(user);
    }
    @Override
    public User find(Long id) {
        return entityManager.find(User.class, id);
    }
    @Override
    public void update(User user) {
        entityManager.merge(user);
    }
}
