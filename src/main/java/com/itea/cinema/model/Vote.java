package com.itea.cinema.model;

import javax.persistence.*;

@Entity
@Table(name = "vote")
@NamedQuery(name = "Vote.getAll", query = "SELECT v from Vote v")
public class Vote {

    @Id
    @GeneratedValue
    @Column(name = "vote_id")
    private long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "vote_film")
    private Film film;

    @Column(name = "vote_value")
    private int value;

    public Vote(Film film, int value) {
        this.film = film;
        this.value = value;
    }

    public Vote() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Vote{" +
                "id=" + id +
                ", value=" + value +
                '}';
    }
}
