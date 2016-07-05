package com.itea.cinema.controllers;

//import com.itea.cinema.crud.UserDAO;
import com.itea.cinema.crud.UserRolesDAO;
import com.itea.cinema.model.User;
import com.itea.cinema.model.UserRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServlet;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Controller
public class UserController extends HttpServlet {
//
//    @Autowired
//    private UserDAO userDAO;
    @Autowired
    private UserRolesDAO userRolesDAO;

    PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public ModelAndView registrationForm() {
        return new ModelAndView("registration", "registration", new User());
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registration(@ModelAttribute("registration") User user, UserRoles userRoles, BindingResult result) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRoles.setUser(user);
        userRoles.setRole("ROLE_USER");

        if (result.hasErrors()) {
            return "registration";
        }
        userRolesDAO.add(userRoles);
        return "redirect:/films";
    }
}

