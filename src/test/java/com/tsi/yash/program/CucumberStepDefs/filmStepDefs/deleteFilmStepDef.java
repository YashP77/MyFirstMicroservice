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

public class deleteFilmStepDef {


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

    @Given("I have the film id that I would like to delete")
    public void i_have_the_film_id_that_i_would_like_to_delete() {

        testFilm = new Film("title", "description", 2022, "language_id", "original_language_id", 2, 3,180,10,"rating","special_features");

    }

    @When("I input the ID for the film I would like to delete")
    public void i_input_the_id_for_the_film_i_would_like_to_delete() {
        setUp();
        when(filmRepository.findById(1)).thenReturn(Optional.of(testFilm));
    }

    @Then("I get the response shown for deleting a film")
    public void i_get_the_response_shown_for_deleting_a_film() {

        myFirstMicroserviceApplication.deleteFilm(1);
        verify(filmRepository).delete(testFilm);

    }

}
