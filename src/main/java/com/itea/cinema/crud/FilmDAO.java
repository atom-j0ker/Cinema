package com.itea.cinema.crud;

import com.itea.cinema.model.Film;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.*;
import java.util.List;

@Transactional
public class FilmDAO {

    @PersistenceContext
    public EntityManager entityManager;

    public Film add(Film film) {
        return entityManager.merge(film);
    }

    public void delete(long id) {
        entityManager.remove(entityManager.getReference(Film.class, id));
    }

    public Film get(long id) {
        return entityManager.find(Film.class, id);

    }

    public void update(Film film) {
        entityManager.merge(film);
    }

    public List<Film> getFilmList() {
        TypedQuery<Film> query = entityManager.createQuery(
                "select f from Film f ", Film.class
        );
        List<Film> result = query.getResultList();
        return result;
    }

    public List<Film> getFilmsByLetter(String letter) {
        TypedQuery<Film> query = entityManager.createQuery(
                "select f from Film f where name like '" + letter + "%'", Film.class
        );
        List<Film> result = query.getResultList();
        return result;
    }

    public List<Film> getFilmsBySearch(String string) {
        TypedQuery<Film> query = entityManager.createQuery(
                "select f from Film f where name like '%" + string + "%'", Film.class
        );
        List<Film> result = query.getResultList();
        return result;
    }
}
