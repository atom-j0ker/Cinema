package com.itea.cinema.model;

import javax.persistence.*;

@Entity
@Table(name = "seance")
public class Seance {

    @Id
    @GeneratedValue
    @Column(name = "seance_id")
    private long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "seance_film")
    private Film film;

    @ManyToOne(optional = false)
    @JoinColumn(name = "seance_hall")
    private Hall hall;

    @Column(name = "seance_date")
    private String date;

    @Column(name = "seance_time")
    private String time;

    public Seance(Film film, Hall hall, String date, String time) {
        this.film = film;
        this.hall = hall;
        this.date = date;
        this.time = time;
    }

    public Seance() {

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

    public Hall getHall() {
        return hall;
    }

    public void setHall(Hall hall) {
        this.hall = hall;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Seance{" +
                "id=" + id +
                ", date='" + date + '\'' +
                ", time='" + time + '\'' +
                '}';
    }
}
