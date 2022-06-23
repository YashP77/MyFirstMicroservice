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

public class filmSearchStepDef {

    private WebDriver driver;

    @Given("The user is on the film search webpage")
    public void the_user_is_on_the_film_search_webpage() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://localhost:3000/filmSearch");
        WebElement element = driver.findElement(By.id("loading"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(120));
        wait.until(ExpectedConditions.invisibilityOf(element));

    }

    @When("Input is added to the film search bar")
    public void input_is_added_to_the_film_search_bar(){
        driver.findElement(By.id("userInput")).sendKeys("Academy Dinosaur");
    }

    @Then("The related films results are shown on the page")
    public void the_related_films_results_are_shown_on_the_page() {

        boolean actual = driver.getPageSource().contains("ACADEMY DINOSAUR");

        Assertions.assertEquals(true, actual, "Results are not shown correctly");

        driver.quit();

    }

}
