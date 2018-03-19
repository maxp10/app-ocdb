package org.jboss.tools.example.springmvc.repo;

import java.util.List;

import org.jboss.tools.example.springmvc.domain.Beer;

public interface BeerDao
{
    public Beer findById(Long id);

    public Beer findByName(String name);

    public List<Beer> findAllOrderedByName();

    public void register(Beer beer);
}
