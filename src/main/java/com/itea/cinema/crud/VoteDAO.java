package com.itea.cinema.crud;

import com.itea.cinema.model.Vote;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.util.List;

@Transactional
public class VoteDAO {

    @PersistenceContext
    public EntityManager entityManager;

    public Vote add(Vote vote) {
        Vote voteFromDB = entityManager.merge(vote);
        return voteFromDB;
    }

    public Vote get(long id) {
        return entityManager.find(Vote.class, id);
    }

    public List<Vote> getAll() {
        TypedQuery<Vote> namedQuery = entityManager.createNamedQuery("Vote.getAll", Vote.class);
        return namedQuery.getResultList();
    }
}
