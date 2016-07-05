package com.itea.cinema.controllers;

import com.itea.cinema.crud.FilmDAO;
import com.itea.cinema.crud.UserDAO;
import com.itea.cinema.crud.UserRolesDAO;
import com.itea.cinema.model.Film;
import com.itea.cinema.model.UserRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class WebServiceController {

    @Autowired
    UserRolesDAO userRolesDAO;

    @Autowired
    FilmDAO filmDAO;

    @RequestMapping(value = "/users/json", method = RequestMethod.GET, produces = "application/json")
    public List<UserRoles> getUserInJSON() {
        return userRolesDAO.getUserList();
    }

    @RequestMapping(value = "/users.xml", method = RequestMethod.GET, produces = "application/xml")
    public List<UserRoles> getUserInXML() {
        return userRolesDAO.getUserList();
    }

    @RequestMapping(value = "/filmList/{filmId}", method = RequestMethod.GET, produces = "application/json")
    public List<Film> getFilmInJSON(@PathVariable long filmId) {
        return filmDAO.getFilmList();
    }
}
