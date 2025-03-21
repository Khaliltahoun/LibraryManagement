package com.example.dao;

import com.example.entities.Borrow;
import com.example.entities.Document;
import com.example.entities.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import com.example.utils.JpaUtil;

import java.util.List;

public class BorrowDAO {
    public List<Borrow> getCurrentBorrows() {
        EntityManager em = JpaUtil.getEntityManager();
        TypedQuery<Borrow> query = em.createQuery("SELECT b FROM Borrow b WHERE b.returnDate IS NULL", Borrow.class);
        return query.getResultList();
    }

    public void borrowDocument(User user, Document document) {
        EntityManager em = JpaUtil.getEntityManager();
        em.getTransaction().begin();

        Borrow borrow = new Borrow();
        borrow.setUser(user);
        borrow.setDocument(document);
        borrow.setDateBorrow(new java.util.Date());

        em.persist(borrow);
        em.getTransaction().commit();
    }

    public void returnDocument(Long borrowId) {
        EntityManager em = JpaUtil.getEntityManager();
        Borrow borrow = em.find(Borrow.class, borrowId);

        if (borrow != null) {
            em.getTransaction().begin();
            borrow.setReturnDate(new java.util.Date());
            em.merge(borrow);
            em.getTransaction().commit();
        }
    }
}
