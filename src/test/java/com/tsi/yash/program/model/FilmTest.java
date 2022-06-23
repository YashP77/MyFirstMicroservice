package com.tsi.yash.program.model;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FilmTest {

    @Test
    public void getActor(){

        Film film = new Film();

        Set<Actor> actors = new HashSet<>();
        film.setActor(actors);

        assertEquals(actors,film.getActor(),"Actor is not retrieved correctly");
    }

    @Test
    public void getCategory(){

        Film film = new Film();

        Set<Category> categories = new HashSet<>();
        film.setCategory(categories);

        assertEquals(categories,film.getCategory(),"Category is not retrieved correctly");
    }

}
