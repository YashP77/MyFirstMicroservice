package com.tsi.yash.program.model;

import javax.persistence.*;


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

    private Integer rating;

    private String special_features;

    //Constructors
    public Film(){

    }

    public Film(Integer film_id, String title, String description, Integer release_year, String language_id, String original_language_id, Integer rental_duration, Integer rental_rate, Integer length, Integer replacement_cost, Integer rating, String special_features) {
        this.film_id = film_id;
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

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public String getSpecial_features() {
        return special_features;
    }

    public void setSpecial_features(String special_features) {
        this.special_features = special_features;
    }
}
