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

import java.util.Optional;

import static org.mockito.Mockito.*;

public class updateActorStepDef {

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

    Actor testActor1;
    Actor testActor2;
    ResponseEntity<Actor> actual;

    @Given("I have the actor information and id number of the actor I would like to change")
    public void i_have_the_actor_information_and_id_number_of_the_actor_i_would_like_to_change() {
        // Write code here that turns the phrase above into concrete actions
        testActor1 = new Actor(1,"TestUpdate", "TestUpdate");
        testActor2 = new Actor(1,"TestUpdated", "TestUpdated");
    }

    @When("I input the data into the database for update")
    public void i_input_the_data_into_the_database_for_update() {
        // Write code here that turns the phrase above into concrete actions
        setUp();
        when(actorRepository.findById(testActor1.getActor_id())).thenReturn(Optional.of(testActor2));
        actual = myFirstMicroserviceApplication.updateActor(testActor1.getActor_id(), testActor2.getFirst_name(), testActor2.getLast_name());
    }

    @Then("I get the information that I have updated returned")
    public void i_get_the_information_that_i_have_updated_returned() {
        // Write code here that turns the phrase above into concrete actions
        ArgumentCaptor<Actor> actorArgumentCaptor = ArgumentCaptor.forClass(Actor.class);
        verify(actorRepository).save(actorArgumentCaptor.capture());
        ResponseEntity<Actor> expected = ResponseEntity.ok(actorArgumentCaptor.getValue());
        Assertions.assertEquals(expected,actual, "Actor is not updated successfully");
    }
}
