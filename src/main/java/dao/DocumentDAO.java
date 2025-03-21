package dao;

import entities.Document;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import utils.JpaUtil;

import java.util.List;

public class DocumentDAO {
    public List<Document> getAllDocuments() {
        EntityManager em = JpaUtil.getEntityManager();
        TypedQuery<Document> query = em.createQuery("SELECT d FROM Document d", Document.class);
        return query.getResultList();
    }

    public Document getDocumentById(Long id) {
        EntityManager em = JpaUtil.getEntityManager();
        return em.find(Document.class, id);
    }

    public void addDocument(Document document) {
        EntityManager em = JpaUtil.getEntityManager();
        em.getTransaction().begin();
        em.persist(document);
        em.getTransaction().commit();
    }
}
