package com.tsi.yash.program.model;

import javax.persistence.*;
@Entity
@Table(name="film_category")
public class FilmCategory {

    // Attributes
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer film_id;
    private Integer category_id;

    // Constructor
    public FilmCategory(){

    }

    public FilmCategory(Integer film_id, Integer category_id){
        this.film_id = film_id;
        this.category_id = category_id;
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
}
