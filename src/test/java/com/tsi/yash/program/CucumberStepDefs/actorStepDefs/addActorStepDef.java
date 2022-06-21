package com.tsi.yash.program.CucumberStepDefs.actorStepDefs;

import com.tsi.yash.program.MyFirstMicroserviceApplication;
import com.tsi.yash.program.model.Actor;
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

public class addActorStepDef {


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
        actorRepository =mock(ActorRepository.class);
        myFirstMicroserviceApplication = new MyFirstMicroserviceApplication(actorRepository, filmActorRepository, filmRepository,filmCategoryRepository, categoryRepository, languageRepository);
    }

    Actor testActor;
    ResponseEntity<Actor> actual;

    @Given("I have the actor information I would like to input")
    public void i_have_the_actor_information_i_would_like_to_input() {
        // Write code here that turns the phrase above into concrete actions
        testActor = new Actor("Test", "Actor");
    }

    @When("I input the data into the database for adding an actor")
    public void i_input_the_data_into_the_database_for_adding_an_actor() {
        // Write code here that turns the phrase above into concrete actions
        setUp();
        actual = myFirstMicroserviceApplication.addActor(testActor.getFirst_name(), testActor.getLast_name());

    }

    @Then("I get the information that I have added returned")
    public void i_get_the_information_that_i_have_added_returned() {
        // Write code here that turns the phrase above into concrete actions
        ArgumentCaptor<Actor> actorArgumentCaptor = ArgumentCaptor.forClass(Actor.class);
        verify(actorRepository).save(actorArgumentCaptor.capture());
        ResponseEntity<Actor> expected = ResponseEntity.ok(actorArgumentCaptor.getValue());

        Assertions.assertEquals(expected, actual, "Actor is not saved in database");
    }
}
