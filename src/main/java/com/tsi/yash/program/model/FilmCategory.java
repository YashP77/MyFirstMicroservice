package com.tsi.yash.program.model;


import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="FilmCategory")
public class FilmCategory {

    // Attributes
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer film_id;
    private Integer category_id;

    @LastModifiedDate
    private LocalDateTime lastUpdate;

    // Constructor
    public FilmCategory(){

    }

    public FilmCategory(Integer film_id, Integer category_id){
        this.film_id = film_id;
        this.category_id = category_id;
        this.lastUpdate = LocalDateTime.now();

    }

    //Methods


    public Integer getFilm_id() {
        return film_id;
    }

    public void setFilm_id(Integer film_id) {
        this.film_id = film_id;
    }

    public Integer getCategory_id() {
        return category_id;
    }

    public void setCategory_id(Integer category_id) {
        this.category_id = category_id;
    }

    public LocalDateTime getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(LocalDateTime lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    @Override
    public String toString() {
        return "FilmCategory{" +
                "film_id=" + film_id +
                ", category_id=" + category_id +
                ", lastUpdate=" + lastUpdate +
                '}';
    }
}
