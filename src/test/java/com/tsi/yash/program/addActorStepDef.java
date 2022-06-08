package com.tsi.yash.program;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

import java.net.HttpURLConnection;
import java.net.URL;

public class addActorStepDef {

    @Given("I have the actors information")
    public void i_have_the_actors_information() {
        // Write code here that turns the phrase above into concrete actions
        try {
            URL url = new URL("localhost:8080/Home/addActor");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");

            Assertions.assertEquals(HttpURLConnection.HTTP_OK, con.getResponseCode(), "A connection has not been made");
        } catch (Exception e) {
            System.out.println(e);
        }
        throw new io.cucumber.java.PendingException();
    }

    @When("I input data into the database")
    public void i_input_data_into_the_database() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("I get the saved returned string")
    public void i_get_the_saved_returned_string() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }


}
