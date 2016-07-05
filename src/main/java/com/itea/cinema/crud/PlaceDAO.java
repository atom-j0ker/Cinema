package com.itea.cinema.crud;

import com.itea.cinema.model.Place;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.*;
import java.util.List;

@Transactional
public class PlaceDAO {

    @PersistenceContext
    public EntityManager entityManager;

    public Place add(Place place) {
        return entityManager.merge(place);
    }

    public void delete(long id) {
        entityManager.remove(get(id));
    }

    public Place get(long id) {
        return entityManager.find(Place.class, id);
    }

    public void update(Place place) {
        entityManager.merge(place);
    }

    public List<Place> getPlaceList() {
        TypedQuery<Place> query = entityManager.createQuery(
                "select p from Place p ", Place.class
        );
        List<Place> result = query.getResultList();
        return result;
    }
}
