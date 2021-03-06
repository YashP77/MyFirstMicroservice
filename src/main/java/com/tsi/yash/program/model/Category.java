package com.tsi.yash.program.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name="category")
public class Category {

    // Attributes
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer category_id;
    private String name;

    @ManyToMany (mappedBy = "category", fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<Film> films = new HashSet<>();


    // Constructor
    public Category(){

    }

    public Category(String name){
        this.name=name;
    }

    // Methods

    public Integer getCategory_id() {
        return category_id;
    }

    public void setCategory_id(Integer category_id) {
        this.category_id = category_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Film> getFilms() {
        return films;
    }

    public void setFilms(Set<Film> films) {
        this.films = films;
    }
}
