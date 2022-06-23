package com.tsi.yash.program.CucumberStepDefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class addActorPageStepDef {

    private WebDriver driver;

    @Given("The user is on the add actor webpage")
    public void the_user_is_on_the_add_actor_webpage() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://localhost:3000/add");
    }

    @When("Input is added to the actor input bar")
    public void input_is_added_to_the_actor_input_bar() {
        driver.findElement(By.id("firstName")).sendKeys("Test");
        driver.findElement(By.id("lastName")).sendKeys("Actor");
    }

    @When("The submit button is pressed")
    public void the_submit_button_is_pressed() {

        driver.findElement(By.id("submit")).click();
    }

    @Then("The result of the add actor submission is shown on screen")
    public void the_result_of_the_add_actor_submission_is_shown_on_screen() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("message")));


       boolean actual =  driver.findElement(By.id("message")).isEnabled();

        Assertions.assertEquals(true, actual, "Actor not successfully added to database");

    }

}
