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
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class addFilmStepDef {


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

    @Given("I have the film information I would like to input")
    public void i_have_the_film_information_i_would_like_to_input() {

        testFilm = new Film("title", "description", 2022, "language_id", "original_language_id", 2, 3,180,10,"rating","special_features");

    }

    @When("I input the data into the database for adding a film")
    public void i_input_the_data_into_the_database_for_adding_a_film() {

        setUp();
        actual = myFirstMicroserviceApplication.addFilm(testFilm.getTitle(), testFilm.getDescription(),testFilm.getRelease_year(),testFilm.getLanguage_id(), testFilm.getOriginal_language_id(), testFilm.getRental_duration(), testFilm.getRental_rate(), testFilm.getLength(), testFilm.getReplacement_cost(), testFilm.getRating(), testFilm.getSpecial_features());

    }

    @Then("I get the film information that I have added returned")
    public void i_get_the_film_information_that_i_have_added_returned() {

        ArgumentCaptor<Film> filmArgumentCaptor = ArgumentCaptor.forClass(Film.class);

        verify(filmRepository).save(filmArgumentCaptor.capture());

        ResponseEntity<Film> expected = ResponseEntity.ok(filmArgumentCaptor.getValue());

        Assertions.assertEquals(expected, actual, "Film is not saved in database");

    }

}
