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

public class updateFilmStepDef {



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

    Film testFilm1;
    Film testFilm2;
    ResponseEntity<Film> actual;

    @Given("I have the film information and id number of the film I would like to update")
    public void i_have_the_film_information_and_id_number_of_the_film_i_would_like_to_update() {

        testFilm1 = new Film("title", "description", 2022, "language_id", "original_language_id", 2, 3,180,10,"rating","special_features");

        testFilm2 = new Film("title 2", "description", 2022, "language_id", "original_language_id", 2, 3,180,10,"rating","special_features");

    }

    @When("I input the ID number and the data into the update method")
    public void i_input_the_id_number_and_the_data_into_the_update_method() {

        setUp();
        when(filmRepository.findById(testFilm1.getFilm_id())).thenReturn(Optional.of(testFilm2));
        actual = myFirstMicroserviceApplication.updateFilm(testFilm1.getFilm_id(), testFilm2.getTitle(), testFilm2.getDescription(),testFilm2.getRelease_year(),testFilm2.getLanguage_id(), testFilm2.getOriginal_language_id(), testFilm2.getRental_duration(), testFilm2.getRental_rate(), testFilm2.getLength(), testFilm2.getReplacement_cost(), testFilm2.getRating(), testFilm2.getSpecial_features());

    }

    @Then("I get the film information that I have updated returned")
    public void i_get_the_film_information_that_i_have_updated_returned() {

        ArgumentCaptor<Film> filmArgumentCaptor = ArgumentCaptor.forClass(Film.class);

        verify(filmRepository).save(filmArgumentCaptor.capture());

        ResponseEntity<Film> expected = ResponseEntity.ok(filmArgumentCaptor.getValue());

        Assertions.assertEquals(expected,actual, "Film is not updated successfully");

    }


}
