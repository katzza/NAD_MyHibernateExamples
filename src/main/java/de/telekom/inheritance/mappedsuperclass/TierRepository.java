package de.telekom.inheritance.mappedsuperclass;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
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
}
