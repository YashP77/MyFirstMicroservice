package com.tsi.yash.program.CucumberStepDefs.filmStepDefs;

import com.tsi.yash.program.MyFirstMicroserviceApplication;
import com.tsi.yash.program.model.Film;
import com.tsi.yash.program.repositories.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

import static org.mockito.Mockito.*;


public class viewFilmStepDef {


    private MyFirstMicroserviceApplication myFirstMicroserviceApplication;

    @Mock
    private ActorRepository actorRepository;
    @Mock
    private FilmActorRepository filmActorRepository;
    @Mock
    private FilmRepository filmRepository;
    @Mock
    private FilmCategoryRepository filmCategoryRepository;
    @Mock
    private CategoryRepository categoryRepository;
    @Mock
    private LanguageRepository languageRepository;


    @BeforeEach
    void setUp(){
        filmRepository =mock(FilmRepository.class);
        myFirstMicroserviceApplication = new MyFirstMicroserviceApplication(actorRepository, filmActorRepository, filmRepository,filmCategoryRepository, categoryRepository, languageRepository);
    }

    Film testFilm;
    ResponseEntity<Film> actual;

    @Given("I have the film id number")
    public void i_have_the_film_id_number() {

        testFilm = new Film("title", "description", 2022, "language_id", "original_language_id", 2, 3,180,10,"rating","special_features");

    }

    @When("I input the film id into the search")
    public void i_input_the_film_id_into_the_search() {

        setUp();
        when(filmRepository.findById(testFilm.getFilm_id())).thenReturn(Optional.of(testFilm));

        actual = myFirstMicroserviceApplication.getFilm(testFilm.getFilm_id());

    }

    @Then("I get the string with the film's information")
    public void i_get_the_string_with_the_film_s_information() {

        Assertions.assertEquals(ResponseEntity.ok(testFilm), actual, "Film is not retrieved from database correctly");

    }

}
