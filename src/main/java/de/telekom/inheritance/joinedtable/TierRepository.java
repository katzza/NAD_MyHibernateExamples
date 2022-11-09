package de.telekom.inheritance.joinedtable;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class TierRepository {

    @PersistenceContext
    private EntityManager em;

    public Tier findByID(Long id) {

        return em.find(Tier.class, id);
    }

    @Transactional
    public void save(Tier tier) {

        em.persist(tier);
    }

    public List<Tier> findAll() {
        return em.createQuery("from "+ Tier.class).getResultList();
    }

    public List <Tier> findByAge (int age){
        Query q = em.createNamedQuery("findByAge");
        q.setParameter("age", 1);
        return q.getResultList();
    }
}
