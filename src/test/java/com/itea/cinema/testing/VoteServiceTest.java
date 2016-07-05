/*package com.itea.cinema.testing;

import com.itea.cinema.crud.FilmDAO;
import com.itea.cinema.crud.VoteDAO;
import com.itea.cinema.model.Vote;
import org.junit.Test;

import java.util.List;

public class VoteServiceTest {

    VoteDAO voteService = new VoteDAO();
    FilmDAO filmService = new FilmDAO();

    @Test
    public void testSaveRecord() throws Exception {

        Vote vote1 = new Vote();

        vote1.setFilm(filmService.get(1));
        vote1.setValue(4);

        Vote vote = voteService.add(vote1);

        System.out.println(vote);
    }

    @Test
    public void testSelect() throws Exception {

        Vote vote1 = new Vote();

        vote1.setFilm(filmService.get(1));
        vote1.setValue(3);

        Vote vote = voteService.add(vote1);

        Vote voteFromDB = voteService.get(vote.getId());
        System.out.println(voteFromDB);
    }

    @Test
    public void testGetAll() {

        Vote vote1 = new Vote();

        vote1.setFilm(filmService.get(1));
        vote1.setValue(2);

        Vote vote2 = new Vote();

        vote2.setFilm(filmService.get(1));
        vote2.setValue(5);

        Vote vote3 = new Vote();

        vote3.setFilm(filmService.get(1));
        vote3.setValue(4);

        voteService.add(vote1);
        voteService.add(vote2);
        voteService.add(vote3);

        List<Vote> votes = voteService.getAll();

        for(Vote v : votes){
            System.out.println(v);
        }
    }
}*/