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

public class updateActorPageStepDef {

    private WebDriver driver;
    @Given("The user is on the update actor webpage")
    public void the_user_is_on_the_update_actor_webpage() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://localhost:3000/update");

    }

    @When("Input is added to the update actor input bar")
    public void input_is_added_to_the_update_actor_input_bar() {

        driver.findElement(By.id("actorID")).sendKeys("207");
        driver.findElement(By.id("firstName")).sendKeys("Test");
        driver.findElement(By.id("lastName")).sendKeys("Actor");

    }

    @When("The update button is pressed")
    public void the_update_button_is_pressed() {

        driver.findElement(By.id("submit")).click();

    }

    @Then("The result of the update actor submission is shown on screen")
    public void the_result_of_the_update_actor_submission_is_shown_on_screen() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("message")));


        boolean actual =  driver.findElement(By.id("message")).isEnabled();

        Assertions.assertTrue(actual, "Actor not successfully updated to database");


    }

}
