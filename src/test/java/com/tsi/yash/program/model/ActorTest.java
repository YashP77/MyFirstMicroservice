package com.tsi.yash.program.model;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class ActorTest {

    private Actor actor;

    @BeforeEach
    public void setUp(){
        actor = new Actor("Test", "Actor");

    }

    @Test
    public void constructorTest(){

        Actor actor1 = new Actor();
        Actor actor2 = new Actor("Test", "Con");
        Set<Film> film = new HashSet<>();
        Actor actor3 = new Actor("Test", "Con", film);

        assertNull(actor1.getFirst_name(), "Constructor not functioning");
        assertEquals("Test", actor2.getFirst_name(), "Constructor not functioning");
        assertEquals("Test", actor3.getFirst_name(), "Constructor not functioning");

    }

    @Test
    public void testGetActor_id() {
        actor.setActor_id(1);
        assertEquals(1, actor.getActor_id(), "ID is not retrieved correctly");
    }

    @Test
    void setActor_id() {

        actor.setActor_id(2);
        assertEquals(2, actor.getActor_id(), "ID is not set correctly");

    }

    @Test
    public void getFirst_name() {
        assertEquals("Test", actor.getFirst_name(), "First name is not retrieved correctly");
    }

    @Test
    public void setFirst_name() {
        actor.setFirst_name("Test2");
        assertEquals("Test2", actor.getFirst_name(), "First name is not set correctly");
    }

    @Test
    public void getLast_name() {
        assertEquals("Actor", actor.getLast_name(), "Last name is not retrieved correctly");
    }

    @Test
    public void setLast_name() {
        actor.setLast_name("Actor2");
        assertEquals("Actor2", actor.getLast_name(), "Last name is not set correctly");
    }

    @Test
    public void getFilm(){
        Set<Film> film = new HashSet<>();
        actor.setFilm(film);

        assertEquals(film, actor.getFilm(), "Film is not retrieved correctly");

    }
}