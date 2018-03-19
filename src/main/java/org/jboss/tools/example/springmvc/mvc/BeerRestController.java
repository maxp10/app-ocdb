package org.jboss.tools.example.springmvc.mvc;

import java.util.List;

import org.jboss.tools.example.springmvc.domain.Beer;
import org.jboss.tools.example.springmvc.repo.BeerDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/rest/beers")
public class BeerRestController
{
    @Autowired
    private BeerDao beerDao;

    @RequestMapping(method=RequestMethod.GET, produces="application/json")
    public @ResponseBody List<Beer> listAllBeers()
    {
        return beerDao.findAllOrderedByName();
    }

    @RequestMapping(value="/{id}", method=RequestMethod.GET, produces="application/json")
    public @ResponseBody Beer lookupBeerById(@PathVariable("id") Long id)
    {
        return beerDao.findById(id);
    }
}
