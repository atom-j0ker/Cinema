package com.itea.cinema.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Table(name = "hall")
public class Hall {
    @Id
    @GeneratedValue
    @Column(name = "hall_id")
    private long id;

    @Column(name = "hall_name")
    private String name;

    @Column(name = "hall_amount_places")
    private String amountPlaces;

    @OneToMany(mappedBy = "hall", cascade = CascadeType.ALL)
    private Collection<Seance> seances = new ArrayList<Seance>();

    @OneToMany(mappedBy = "hall", cascade = CascadeType.ALL)
    private Collection<Place> places = new ArrayList<Place>();

    public Hall(String name, String amountPlaces) {
        this.name = name;
        this.amountPlaces = amountPlaces;
    }

    public Hall() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAmountPlaces() {
        return amountPlaces;
    }

    public void setAmountPlaces(String amountPlaces) {
        this.amountPlaces = amountPlaces;
    }

    public Collection<Seance> getSeances() {
        return seances;
    }

    public void setSeances(Collection<Seance> seances) {
        this.seances = seances;
    }

    public Collection<Place> getPlaces() {
        return places;
    }

    public void setPlaces(Collection<Place> places) {
        this.places = places;
    }

    @Override
    public String toString() {
        return "Hall{" +
                "amountPlaces='" + amountPlaces + '\'' +
                ", name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
