package com.itea.cinema.model;

import javax.persistence.*;

@Entity
@Table(name = "hall")
public class Place {
    @Id
    @GeneratedValue
    @Column(name = "place_id")
    private long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "place_hall")
    private Hall hall;

    @Column(name = "place_number")
    private String number;

    public Place(Hall hall, String number) {
        this.hall = hall;
        this.number = number;
    }

    public Place() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Hall getHall() {
        return hall;
    }

    public void setHall(Hall hall) {
        this.hall = hall;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Place{" +
                "id=" + id +
                ", number='" + number + '\'' +
                '}';
    }
}
