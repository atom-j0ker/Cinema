/*package com.itea.cinema.testing;

import com.itea.cinema.crud.FilmDAO;
import com.itea.cinema.crud.SeanceDAO;
import com.itea.cinema.model.Seance;
import org.junit.Test;

import java.util.List;

public class SeanceServiceTest {

    SeanceDAO seanceService = new SeanceDAO();
    FilmDAO filmService = new FilmDAO();

    @Test
    public void testSaveRecord() throws Exception {

        Seance seance1 = new Seance();

        seance1.setFilm(filmService.get(1));
        seance1.setDate("15.04.2016");
        seance1.setTime("18:00");

        Seance seance = seanceService.add(seance1);

        System.out.println(seance);
    }

    @Test
    public void testDeleteRecord() throws Exception {

        Seance seance1 = new Seance();

        seance1.setFilm(filmService.get(1));
        seance1.setDate("18.06.2016");
        seance1.setTime("21:00");

        Seance seance = seanceService.add(seance1);

        seanceService.delete(seance.getId());
    }

    @Test
    public void testSelect() throws Exception {

        Seance seance1 = new Seance();

        seance1.setFilm(filmService.get(1));
        seance1.setDate("25.02.2016");
        seance1.setTime("12:30");

        Seance seance = seanceService.add(seance1);

        Seance seanceFromDB = seanceService.get(seance.getId());
        System.out.println(seanceFromDB);
    }

    @Test
    public void testUpdate() throws Exception {

        Seance seance1 = new Seance();

        seance1.setFilm(filmService.get(1));
        seance1.setDate("01.01.2016");
        seance1.setTime("00:00");

        Seance seance = seanceService.add(seance1);

        seance1.setDate("03.03.2016");
        seance1.setTime("15:00");

        seanceService.update(seance1);

        Seance seance2 = seanceService.get(seance1.getId());
        System.out.println(seance2);
    }

    @Test
    public void testGetAll() {

        Seance seance1 = new Seance();

        seance1.setFilm(filmService.get(1));
        seance1.setDate("01.01.2016");
        seance1.setTime("00:00");

        Seance seance2 = new Seance();

        seance2.setFilm(filmService.get(1));
        seance2.setDate("01.01.2016");
        seance2.setTime("00:00");

        Seance seance3 = new Seance();

        seance3.setFilm(filmService.get(1));
        seance3.setDate("01.01.2016");
        seance3.setTime("00:00");

        seanceService.add(seance1);
        seanceService.add(seance2);
        seanceService.add(seance3);

        List<Seance> seances = seanceService.getSeanceList(1);

        for(Seance s : seances){
            System.out.println(s);
        }
    }
}*/