package com.itea.cinema.controllers;

import com.itea.cinema.crud.SeanceDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SeanceController {

    @Autowired
    private SeanceDAO seanceDAO;

    @RequestMapping(value = "/films/seances/{filmId}", method = RequestMethod.GET)
    public ModelAndView listSeances(@PathVariable("filmId") int filmId) {
        return new ModelAndView("/seances", "seances", seanceDAO.getSeanceListByFilm(filmId));
    }


}
