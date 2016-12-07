package com.fisher.repository.spittle;

import com.fisher.model.Spittle;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by fisbii on 16-12-7.
 */
public class SpittleRepositoryImpl implements SpittleCompicatedOperation {
    @PersistenceContext
    private EntityManager em;
    @Override
    public List<Spittle> findSpittles(long max, int count) {
        List<Spittle> spittles = em.createNamedQuery("spittle.findSpittles")
                .setParameter("max", max)
                .setFirstResult(0)
                .setMaxResults(count)
                .getResultList();
        return spittles;
    }
}
