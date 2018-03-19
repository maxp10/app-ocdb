package org.jboss.tools.example.springmvc.mvc;

 import javax.validation.Valid;

import org.jboss.tools.example.springmvc.domain.Beer;
import org.jboss.tools.example.springmvc.repo.BeerDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/beer/")
public class BeerController
{
    @Autowired
    private BeerDao beerDao;

    @RequestMapping(method=RequestMethod.GET)
    public String displaySortedBeers(Model model)
    {
        model.addAttribute("newBeer", new Beer());
        model.addAttribute("beers", beerDao.findAllOrderedByName());
        return "beer";
    }

    @RequestMapping(method=RequestMethod.POST)
    public String registerNewBeer(@Valid @ModelAttribute("newBeer") Beer newBeer, BindingResult result, Model model)
    {
        if (!result.hasErrors()) {
            beerDao.register(newBeer);
            return "redirect:/beer/";
        }
        else {
            model.addAttribute("beers", beerDao.findAllOrderedByName());
            return "beer";
        }
    }
}
