package com.itea.cinema.controllers;

import com.itea.cinema.crud.FilmDAO;
import com.itea.cinema.crud.HallDAO;
import com.itea.cinema.crud.SeanceDAO;
import com.itea.cinema.model.Film;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class FilmController extends HttpServlet {

    @Autowired
    private FilmDAO filmDAO;
    @Autowired
    private SeanceDAO seanceDAO;
    @Autowired
    private HallDAO hallDAO;


    //добавление
    @RequestMapping(value = "/films/add", method = RequestMethod.GET)
    public ModelAndView filmAddForm() {
        return new ModelAndView("filmAdd", "filmAdd", new Film());
    }
    @RequestMapping(value = "/films/add", method = RequestMethod.POST)
    public String filmAddToDb(@ModelAttribute("filmAdd") Film film, BindingResult result) {
        if (result.hasErrors()) {
            return "filmAdd";
        }
        filmDAO.add(film);
        return "redirect:/films";
    }

    //редактирование
    @RequestMapping(value = "/films/edit/{filmId}", method = RequestMethod.GET)
    public ModelAndView filmEditForm(HttpServletRequest request, @PathVariable("filmId") int filmId, Model model) {
        Film film = filmDAO.get(filmId);
        request.setAttribute("filmId", filmId);
        model.addAttribute("filmId", filmId);
        return new ModelAndView("filmEdit", "filmEdit", new Film());
    }
    @RequestMapping(value = "/films/edit/{filmId}", method = RequestMethod.POST)
    public String filmEditInDb(@ModelAttribute Film film, BindingResult result, @PathVariable("filmId") int filmId) {
        if (result.hasErrors()) {
            return "filmEdit";
        } else {
            film.setId(filmId);
            filmDAO.update(film);
            return "redirect:/films";
        }
    }

    //удаление
    @RequestMapping(value = "/films/{filmId}", method = RequestMethod.POST)
    public String filmDeleteFromDb(@PathVariable("filmId") long id) {
        this.filmDAO.delete(id);
        return "redirect:/films";
    }

//    @RequestMapping(value = "/fragments/searchForm", method = RequestMethod.POST)
//    public void letters(Model model) {
//        Character[] letters = new Character[]{'А', 'Б', 'В', 'Г', 'Д', 'Е', 'Ё', 'Ж', 'З', 'И', 'Й', 'К', 'Л', 'М', 'Н', 'О', 'П', 'Р', 'С', 'Т', 'У', 'Ф', 'Х', 'Ц', 'Ч', 'Ш', 'Щ', 'Ъ', 'Ы', 'Ь', 'Э', 'Ю', 'Я',};
//        model.addAttribute("letters", letters);
//    }
//    @RequestMapping(value = "/letters")
//    public ModelAndView letters(ModelMap model) {
//        Character[] letters = new Character[]{'А', 'Б', 'В', 'Г', 'Д', 'Е', 'Ё', 'Ж', 'З', 'И', 'Й', 'К', 'Л', 'М', 'Н', 'О', 'П', 'Р', 'С', 'Т', 'У', 'Ф', 'Х', 'Ц', 'Ч', 'Ш', 'Щ', 'Ъ', 'Ы', 'Ь', 'Э', 'Ю', 'Я',};
//        System.out.println(letters);
//        return new ModelAndView("fragments/searchForm", "letters", letters);
//    }

    @RequestMapping(value = "/searchFilms", method = RequestMethod.POST)
    public ModelAndView listFilmBySearch(HttpServletRequest request, HttpServletResponse response) {
        return new ModelAndView("films", "films", filmDAO.getFilmsBySearch(request.getParameter("searchString")));
    }

    @RequestMapping(value = "/searchFilmsByLetter", method = RequestMethod.POST)
    public ModelAndView listFilmByLetter(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("loh");
        return new ModelAndView("films", "films", filmDAO.getFilmsByLetter(request.getParameter("letter")));
    }

    @RequestMapping(value = "/films")
    public ModelAndView listAllFilms(Model model) {
        Character[] letters = new Character[]{'А', 'Б', 'В', 'Г', 'Д', 'Е', 'Ё', 'Ж', 'З', 'И', 'Й', 'К', 'Л', 'М', 'Н', 'О', 'П', 'Р', 'С', 'Т', 'У', 'Ф', 'Х', 'Ц', 'Ч', 'Ш', 'Щ', 'Ъ', 'Ы', 'Ь', 'Э', 'Ю', 'Я',};
        model.addAttribute("letters", letters);

        return new ModelAndView("films", "films", filmDAO.getFilmList());
    }

    @RequestMapping(value = "/film/{filmId}", method = RequestMethod.GET)
    public String filmInfo(@PathVariable("filmId") int filmId, Model model) {
        Film film = filmDAO.get(filmId);
        model.addAttribute("film", film);
        model.addAttribute("seances", seanceDAO.getSeanceListByFilm(filmId));
        return "/filmInfo";
    }

    @RequestMapping(value = "/about", method = RequestMethod.GET)
    public String about() {
        return "/about";
    }

}

