package com.itea.cinema.crud;

import com.itea.cinema.model.Hall;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.*;
import java.util.List;

@Transactional
public class HallDAO {

    @PersistenceContext
    public EntityManager entityManager;

    public Hall add(Hall hall) {
        return entityManager.merge(hall);
    }

    public void delete(long id) {
        entityManager.remove(entityManager.getReference(Hall.class, id));
    }

    public Hall get(long id) {
        return entityManager.find(Hall.class, id);
    }

    public void update(Hall hall) {
        entityManager.merge(hall);
    }

    public List<Hall> getHallList() {
        TypedQuery<Hall> query = entityManager.createQuery(
                "select h from Hall h ", Hall.class
        );
        List<Hall> result = query.getResultList();
        return result;
    }

}
