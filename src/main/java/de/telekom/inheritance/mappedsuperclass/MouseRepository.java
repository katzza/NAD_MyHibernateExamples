package de.telekom.inheritance.mappedsuperclass;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class MouseRepository {

    @PersistenceContext
    private EntityManager em;

    public Mouse findByID(Long id) {

        return em.find(Mouse.class, id);
    }

    @Transactional
    public void saveMouse(Mouse mouse) {

        em.persist(mouse);
    }

    public List<Mouse> findAll() {
        return em.createQuery("from Mouse").getResultList();
    }
}
