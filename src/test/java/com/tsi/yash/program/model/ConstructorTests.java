package com.tsi.yash.program.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConstructorTests {

    @Test
    public void constructorTest(){

        Film  film = new Film();
        Language language = new Language();
        FilmActor filmActor= new FilmActor();
        FilmCategory filmCategory = new FilmCategory();

        assertEquals(film, film, "Film not constructed correctly");
        assertEquals(language, language, "Language not constructed correctly");
        assertEquals(filmActor, filmActor, "FilmActor not constructed correctly");
        assertEquals(filmCategory, filmCategory, "FilmCategory not constructed correctly");
    }
}
