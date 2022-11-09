package de.telekom.inheritance.mappedsuperclass;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class CatRepository {

    @PersistenceContext
    private EntityManager em;

    public Cat findByID(Long id) {

        return em.find(Cat.class, id);
    }

    @Transactional
    public void saveCat(Cat cat) {

        em.persist(cat);
    }

    public List<Cat> findAll() {
        return em.createQuery("from Cat").getResultList();
    }
}
