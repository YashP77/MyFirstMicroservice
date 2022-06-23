package com.tsi.yash.program.CucumberStepDefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class deleteActorPageStepDef {

    private WebDriver driver;
    @Given("The user is on the delete actor webpage")
    public void the_user_is_on_the_delete_actor_webpage() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://localhost:3000/delete");

    }

    @When("Input is added to the delete actor input bar")
    public void input_is_added_to_the_delete_actor_input_bar() {

        driver.findElement(By.id("actorID")).sendKeys("211");

    }

    @When("The delete button is pressed")
    public void the_delete_button_is_pressed() {

        driver.findElement(By.id("submit")).click();

    }

    @Then("The result of the delete actor submission is shown on screen")
    public void the_result_of_the_delete_actor_submission_is_shown_on_screen() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("message")));


        boolean actual =  driver.findElement(By.id("message")).isEnabled();

        Assertions.assertTrue(actual, "Actor not successfully deleted from database");

    }

}
