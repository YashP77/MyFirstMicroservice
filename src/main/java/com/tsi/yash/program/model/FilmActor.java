package com.tsi.yash.program.model;

import javax.persistence.*;

@Entity
@Table(name="film_actor")
public class FilmActor {

    //Attributes
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer actor_id;

    private Integer film_id;

    //Constructors
    public FilmActor(){
    }

    public FilmActor(Integer actor_id, Integer film_id) {
        this.actor_id = actor_id;
        this.film_id = film_id;
    }

    //Methods
    public Integer getActor_id() {
        return actor_id;
    }

    public void setActor_id(Integer actor_id) {
        this.actor_id = actor_id;
    }

    public Integer getFilm_id() {
        return film_id;
    }

    public void setFilm_id(Integer film_id) {
        this.film_id = film_id;
    }

}
