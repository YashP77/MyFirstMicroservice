package com.tsi.yash.program.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name="film_actor")
public class Film_actor {

    //Attributes
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer actor_id;

    private Integer film_id;

    @LastModifiedDate
    private LocalDateTime lastUpdate;

    //Constructors
    public Film_actor(){
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

    public LocalDateTime getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(LocalDateTime lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    @Override
    public String toString() {
        return "Film_actor{" +
                "actor_id=" + actor_id +
                ", film_id=" + film_id +
                ", lastUpdate=" + lastUpdate +
                '}';
    }
}
