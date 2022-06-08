package com.tsi.yash.program;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

import java.net.HttpURLConnection;
import java.net.URL;

public class viewAllActorsStepDef {

    @Given("I have the actors table")
    public void i_have_the_actors_table() {
        try {
            URL url = new URL("localhost:8080/Home/allActors");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");

            Assertions.assertEquals(HttpURLConnection.HTTP_OK, con.getResponseCode(), "A connection has not been made");
        } catch (Exception e) {
            System.out.println(e);
        }
//        throw new io.cucumber.java.PendingException();
    }

    @When("I request to view all actors")
    public void i_request_to_view_all_actors() {
        // Write code here that turns the phrase above into concrete actions
        try {
            URL url = new URL("localhost:8080/Home/allActors");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");

            Assertions.assertEquals(HttpURLConnection.HTTP_OK, con.getResponseCode(), "A connection has not been made");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Then("I get the all the actor information on DB")
    public void i_get_the_all_the_actor_information_on_db() {
        try {
            URL url = new URL("localhost:8080/Home/allActors");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");

        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
