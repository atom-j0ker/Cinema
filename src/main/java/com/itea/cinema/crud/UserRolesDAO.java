package com.itea.cinema.crud;

import com.itea.cinema.model.UserRoles;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Transactional
public class UserRolesDAO {

    @PersistenceContext
    public EntityManager entityManager;

    public UserRoles add(UserRoles userRoles) {
        return entityManager.merge(userRoles);
    }

    public void delete(long id) {
        entityManager.remove(get(id));
    }

    public UserRoles get(long id) {
        return entityManager.find(UserRoles.class, id);
    }

    public void update(UserRoles userRoles) {
        entityManager.merge(userRoles);
    }

    public List<UserRoles> getUserList() {
        TypedQuery<UserRoles> query = entityManager.createQuery(
                "select ur from UserRoles ur ", UserRoles.class
        );
        List<UserRoles> result = query.getResultList();
        return result;
    }
}
