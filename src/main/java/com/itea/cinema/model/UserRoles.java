package com.itea.cinema.model;

import javax.persistence.*;

@Entity
@Table(name = "user_roles")
public class UserRoles {

    @Id
    @GeneratedValue
    @Column(name = "user_roles_id")
    private long id;

    @Embedded
    @Column(name = "username")
    private User user;

    @Column(name = "role")
    private String role;

    public UserRoles(User user, String role) {
        this.user = user;
        this.role = role;
    }

    public UserRoles() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "UserRoles{" +
                "id=" + id +
                ", user=" + user +
                ", role='" + role + '\'' +
                '}';
    }
}
