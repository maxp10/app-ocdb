package org.jboss.tools.example.springmvc.repo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.jboss.tools.example.springmvc.domain.Beer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class BeerDaoImpl implements BeerDao
{
    @Autowired
    private EntityManager em;

    public Beer findById(Long id)
    {
        return em.find(Beer.class, id);
    }

    public Beer findByName(String name)
    {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Beer> criteria = builder.createQuery(Beer.class);
        Root<Beer> beer = criteria.from(Beer.class);
        criteria.select(beer).where(builder.equal(beer.get("name"), name));
        return em.createQuery(criteria).getSingleResult();
    }

    public List<Beer> findAllOrderedByName()
    {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Beer> criteria = cb.createQuery(Beer.class);
        Root<Beer> beer = criteria.from(Beer.class);
        criteria.select(beer).orderBy(cb.asc(beer.get("name")));
        return em.createQuery(criteria).getResultList();
    }

    public void register(Beer beer)
    {
        em.persist(beer);
        return;
    }
}
