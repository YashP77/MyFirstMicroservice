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

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class viewActorStepDef {

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

    @Given("I have the actors id number")
    public void i_have_the_actors_id_number() {
        testActor = new Actor("TestAdd","TestAdd");
    }

    @When("I input the id into the search")
    public void i_input_the_id_into_the_search() {
        // Write code here that turns the phrase above into concrete actions
        setUp();
        when(actorRepository.findById(testActor.getActor_id())).thenReturn(Optional.of(testActor));
        actual = myFirstMicroserviceApplication.getActor(testActor.getActor_id());
    }

    @Then("I get the string with the actors information")
    public void i_get_the_string_with_the_actors_information() {
        Assertions.assertEquals(ResponseEntity.ok(testActor),actual,"Could not find actor with ID");
    }

}
