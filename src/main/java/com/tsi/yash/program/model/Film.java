package com.tsi.yash.program.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name="film")
public class Film {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer film_id;

    private String title;

    private String description;

    private Integer release_year;

    private String language_id;

    private String original_language_id;

    private Integer rental_duration;

    private Integer rental_rate;

    private Integer length;

    private Integer replacement_cost;

    private String rating;

    private String special_features;

    //Mapping the many-to-many relationship between Film and Actor into Film.
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinTable(name = "film_actor",
            joinColumns = {
                    @JoinColumn(name = "film_id",referencedColumnName = "film_id", nullable = false, updatable = false)
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "actor_id", referencedColumnName = "actor_id", nullable = false, updatable = false)
            })
    private Set<Actor> actor = new HashSet<>();

    //Mapping the many-to-many relationship between Film and Category into Film.
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinTable(name = "film_category",
            joinColumns = {
                    @JoinColumn(name ="film_id", referencedColumnName = "film_id", nullable = false, updatable = false)
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "category_id", referencedColumnName = "category_id", nullable = false, updatable = false)
            })
    private Set<Category> category = new HashSet<>();


    //Constructors
    public Film(){

    }

    public Film(String title, String description, Integer release_year, String language_id, String original_language_id, Integer rental_duration, Integer rental_rate, Integer length, Integer replacement_cost, String rating, String special_features) {
        this.title = title;
        this.description = description;
        this.release_year = release_year;
        this.language_id = language_id;
        this.original_language_id = original_language_id;
        this.rental_duration = rental_duration;
        this.rental_rate = rental_rate;
        this.length = length;
        this.replacement_cost = replacement_cost;
        this.rating = rating;
        this.special_features = special_features;
    }


    //Methods
    public Integer getFilm_id() {
        return film_id;
    }

    public void setFilm_id(Integer film_id) {
        this.film_id = film_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getRelease_year() {
        return release_year;
    }

    public void setRelease_year(Integer release_year) {
        this.release_year = release_year;
    }

    public String getLanguage_id() {
        return language_id;
    }

    public void setLanguage_id(String language_id) {
        this.language_id = language_id;
    }

    public String getOriginal_language_id() {
        return original_language_id;
    }

    public void setOriginal_language_id(String original_language_id) {
        this.original_language_id = original_language_id;
    }

    public Integer getRental_duration() {
        return rental_duration;
    }

    public void setRental_duration(Integer rental_duration) {
        this.rental_duration = rental_duration;
    }

    public Integer getRental_rate() {
        return rental_rate;
    }

    public void setRental_rate(Integer rental_rate) {
        this.rental_rate = rental_rate;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public Integer getReplacement_cost() {
        return replacement_cost;
    }

    public void setReplacement_cost(Integer replacement_cost) {
        this.replacement_cost = replacement_cost;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getSpecial_features() {
        return special_features;
    }

    public void setSpecial_features(String special_features) {
        this.special_features = special_features;
    }

    public Set<Actor> getActor() {
        return actor;
    }

    public void setActor(Set<Actor> actor) {
        this.actor = actor;
    }

    public Set<Category> getCategory() {
        return category;
    }

    public void setCategory(Set<Category> category) {
        this.category = category;
    }
}
