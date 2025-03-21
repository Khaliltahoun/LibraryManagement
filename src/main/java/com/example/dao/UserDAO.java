package com.example.dao;

import com.example.entities.User;
import jakarta.persistence.EntityManager;
import com.example.utils.JpaUtil;

public class UserDAO {
    public void addUser(User user) {
        EntityManager em = JpaUtil.getEntityManager();
        em.getTransaction().begin();
        em.persist(user);
        em.getTransaction().commit();
    }

    public User getUserById(Long id) {
        EntityManager em = JpaUtil.getEntityManager();
        return em.find(User.class, id);
    }
}
