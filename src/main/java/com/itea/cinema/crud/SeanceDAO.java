package com.itea.cinema.crud;

import com.itea.cinema.model.Hall;
import com.itea.cinema.model.Seance;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.*;
import java.util.List;

@Transactional
public class SeanceDAO {

    @PersistenceContext
    public EntityManager entityManager;

    public Seance add(Seance seance) {
        return entityManager.merge(seance);
    }

    public void delete(long id) {
        entityManager.remove(get(id));
    }

    public Seance get(long id) {
        return entityManager.find(Seance.class, id);
    }

    public void update(Seance seance) {
        entityManager.merge(seance);
    }

    public List<Seance> getSeanceListByFilm(long id) {
        TypedQuery<Seance> query = entityManager.createQuery(
                "select s from Seance s where s.film = " + id, Seance.class
        );
        List<Seance> result = query.getResultList();
        return result;
    }
}

