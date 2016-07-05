package com.itea.cinema.crud;

import com.itea.cinema.model.User;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Transactional
public class UserDAO {

    @PersistenceContext
    public EntityManager entityManager;


    public User add(User user) {
        return entityManager.merge(user);
    }

    public void delete(String username) {
        entityManager.remove(get(username));
    }

    public User get(String username) {
        return entityManager.find(User.class, username);
    }

    public void update(User user) {
        entityManager.merge(user);
    }

    public List<User> getUserList() {
        TypedQuery<User> query = entityManager.createQuery(
                "select u from User u ", User.class
        );
        List<User> result = query.getResultList();
        return result;
    }
}
