package com.tsi.yash.program.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="actor")
public class Actor implements Serializable {

    // Attributes
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int actor_id;
    @Basic private String first_name;
    @Basic private String last_name;

    @ManyToMany(mappedBy = "actor",fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<Film> film = new HashSet<>();


    //Constructors
    public Actor(){
    }

    public Actor(String first_name, String last_name){
        this.first_name = first_name;
        this.last_name = last_name;
    }

    public Actor(String first_name, String last_name, Set<Film> film_id){
        this.first_name = first_name;
        this.last_name = last_name;
        this.film = film_id;
    }

    //Methods
    public int getActor_id() {
        return actor_id;
    }

    public void setActor_id(int actor_id) {
        this.actor_id = actor_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public Set<Film> getFilm() {
        return film;
    }

    public void setFilm(Set<Film> film) {
        this.film = film;
    }
}
