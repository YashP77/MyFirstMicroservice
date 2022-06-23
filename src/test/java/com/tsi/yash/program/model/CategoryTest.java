package com.tsi.yash.program.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class CategoryTest {

    private Category category;

    @BeforeEach
    public void setUp(){
        category = new Category("Test");
    }

    @Test
    void constructorTest(){

        Category category1 = new Category();

        assertNull(category1.getName(), "Category not constructed correctly");
    }

    @Test
    void getFilm(){
        Set<Film> film = new HashSet<>();
        category.setFilms(film);

        assertEquals(film, category.getFilms(), "Film is not retrieved correctly");

    }

}
