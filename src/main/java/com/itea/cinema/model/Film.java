package com.itea.cinema.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "film")
public class Film {

    @Id
    @GeneratedValue
    @Column(name = "film_id")
    private long id;

    @Column(name = "film_name")
    private String name;

    @Column(name = "film_genre")
    private String genre;

    @Column(name = "film_director")
    private String director;

    @Column(name = "film_country")
    private String country;

    @Column(name = "film_premiere")
    private String premiere;

    @Column(name = "film_info")
    private String info;

    @Column(name = "film_rating")
    private int rating;

    @Column(name = "film_vote_count")
    private int voteCount;

    @Column(name = "film_image")
    private String image;

    @OneToMany(mappedBy = "film", cascade = CascadeType.ALL)
    private Collection<Seance> seances = new ArrayList<Seance>();

    public Film(String name, String genre, String director, String country, String premiere, String info, int rating, int voteCount) {
        this.name = name;
        this.genre = genre;
        this.director = director;
        this.country = country;
        this.premiere = premiere;
        this.info = info;
        this.rating = rating;
        this.voteCount = voteCount;
    }

    public Film() {

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

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPremiere() {
        return premiere;
    }

    public void setPremiere(String premiere) {
        this.premiere = premiere;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public int getVoteCount() {
        return voteCount;
    }

    public void setVoteCount(int voteCount) {
        this.voteCount = voteCount;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Collection<Seance> getSeances() {
        return seances;
    }

    public void setSeances(List<Seance> seances) {
        this.seances = seances;
    }

    @Override
    public String toString() {
        return "Film{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", genre='" + genre + '\'' +
                ", director='" + director + '\'' +
                ", country='" + country + '\'' +
                ", premiere='" + premiere + '\'' +
                ", info='" + info + '\'' +
                ", rating='" + rating + '\'' +
                ", voteCount=" + voteCount +
                '}';
    }
}
