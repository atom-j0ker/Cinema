/*package com.itea.cinema.testing;

import com.itea.cinema.crud.FilmDAO;
import com.itea.cinema.model.Film;
import org.junit.Test;
import java.util.List;

public class FilmServiceTest {

    FilmDAO filmService = new FilmDAO();

    @Test
    public void testSaveRecord() throws Exception {

        Film film1 = new Film();

        film1.setName("Фильм2");
        film1.setGenre("комедия");
        film1.setDirector("Режиссер2");
        film1.setCountry("США");
        film1.setPremiere("20.03.2016");
        film1.setInfo("инфо");
        film1.setVoteCount(0);

        Film film = filmService.add(film1);

        System.out.println(film);
    }

    @Test
    public void testDeleteRecord() throws Exception {

        Film film1 = new Film();

        film1.setName("Фильм3");
        film1.setGenre("триллер");
        film1.setDirector("Режиссер3");
        film1.setCountry("Италия");
        film1.setPremiere("10.03.2016");
        film1.setInfo("инфо");
        film1.setVoteCount(1);

        Film film = filmService.add(film1);

        filmService.delete(film.getId());
    }

    @Test
    public void testSelect() throws Exception {

        Film film1 = new Film();

        film1.setName("Фильм4");
        film1.setGenre("ужастик");
        film1.setDirector("Режиссер4");
        film1.setCountry("Россия");
        film1.setPremiere("25 февраля 2016");
        film1.setInfo("инфооо");
        film1.setVoteCount(0);

        Film film = filmService.add(film1);

        Film filmFromDB = filmService.get(film.getId());
        System.out.println(filmFromDB);
    }

    @Test
    public void testUpdate() throws Exception {

        Film film1 = new Film();

        film1.setName("Фильм5");
        film1.setGenre("фантастика");
        film1.setDirector("Режиссер5");
        film1.setCountry("США");
        film1.setPremiere("25 апреля 2016");
        film1.setInfo("инфоо");
        film1.setVoteCount(10);

        film1 = filmService.add(film1);

        film1.setCountry("Израиль");
        film1.setPremiere("2 мая 2016");

        filmService.update(film1);

        Film film2 = filmService.get(film1.getId());
        System.out.println(film2);
    }

    @Test
    public void testGetAll() {

        Film film1 = new Film();

        film1.setName("Фильм6");
        film1.setGenre("фентези");
        film1.setDirector("Режиссер6");
        film1.setCountry("США");
        film1.setPremiere("25 апреля 2016");
        film1.setInfo("инфоо");
        film1.setVoteCount(10);

        Film film2 = new Film();

        film2.setName("Фильм7");
        film2.setGenre("драма");
        film2.setDirector("Режиссер7");
        film2.setCountry("СШАA");
        film2.setPremiere("25 апреля 2016");
        film2.setInfo("инфоо");
        film2.setVoteCount(10);

        Film film3 = new Film();

        film3.setName("Фильм8");
        film3.setGenre("криминал");
        film3.setDirector("Режиссер8");
        film3.setCountry("США");
        film3.setPremiere("25 апреля 2016");
        film3.setInfo("инфоо");
        film3.setVoteCount(10);

        filmService.add(film1);
        filmService.add(film2);
        filmService.add(film3);

        List<Film> films = filmService.getFilmList();

        for(Film f : films){
            System.out.println(f);
        }
    }

}*/