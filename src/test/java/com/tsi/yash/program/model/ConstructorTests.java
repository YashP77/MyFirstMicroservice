package com.tsi.yash.program.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class ConstructorTests {

    @Test
    void constructorTest(){

        Film  film = new Film();
        Language language = new Language();
        FilmActor filmActor= new FilmActor();
        FilmCategory filmCategory = new FilmCategory();


        assertNull(film.getTitle(), "Film not constructed correctly");
        assertNull(language.getName(), "Language not constructed correctly");
        assertNull(filmActor.getActor_id(), "FilmActor not constructed correctly");
        assertNull(filmCategory.getFilm_id(), "FilmCategory not constructed correctly");
    }
}
