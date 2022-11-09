package de.telekom.inheritance.tableperclass;

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
        return em.createQuery("from Tier").getResultList();
    }


    /**
     * плохой несекурный запрос
     *
     * @param name
     * @return public List <Tier> findByName(String name) {
     * String query = "Select t from Tier t where name = '"+ name+"'";
     * Query query1 = em.createQuery(query);
     * return query1.getResultList();
     * }
     */

    public List<Tier> findByName(String name) {
        String s = "Select t from Tier t where name = :name";
        Query query = em.createQuery(s);
        query.setParameter("name", name);
        return query.getResultList();
    }

    public List<Tier> findByAge(Integer age) {
        Query q = em.createNamedQuery("findByAge");
        q.setParameter("age", 1);
        return q.getResultList();
    }

    public List<Tier> findByNativeQuery() {
        String nativeQuery = "select * from mouse";
        Query q =  em.createNativeQuery(nativeQuery, Mouse.class);
        return q.getResultList();
    }
}
