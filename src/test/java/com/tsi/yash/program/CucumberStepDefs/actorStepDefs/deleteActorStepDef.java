package com.tsi.yash.program.CucumberStepDefs.actorStepDefs;

import com.tsi.yash.program.MyFirstMicroserviceApplication;
import com.tsi.yash.program.model.Actor;
import com.tsi.yash.program.repositories.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mock;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

import static org.mockito.Mockito.*;

public class deleteActorStepDef {


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

    @Given("I have the actor id that I would like to delete")
    public void i_have_the_actor_id_that_i_would_like_to_delete() {
        // Write code here that turns the phrase above into concrete actions
        testActor = new Actor("TestAdd", "TestAdd");
    }

    @When("I input the ID for the actor I would like to delete")
    public void i_input_the_id_for_the_actor_i_would_like_to_delete() {
        // Write code here that turns the phrase above into concrete actions
        setUp();
        when(actorRepository.findById(testActor.getActor_id())).thenReturn(Optional.of(testActor));
    }

    @Then("I get the response shown for deleting actor")
    public void i_get_the_response_shown_for_deleting_actor() {
        // Write code here that turns the phrase above into concrete actions
        myFirstMicroserviceApplication.deleteActor(testActor.getActor_id());
        verify(actorRepository).delete(testActor);
    }
}
