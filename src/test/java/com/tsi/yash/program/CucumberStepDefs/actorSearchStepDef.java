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
import java.util.Locale;

public class actorSearchStepDef {

    private WebDriver driver;
    String input;


    @Given("The user is on the actor search webpage")
    public void the_user_is_on_the_actor_search_webpage() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://localhost:3000/");
        WebElement element = driver.findElement(By.id("loading"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.invisibilityOf(element));
    }

    @When("Input {string} is added to the actor search bar")
    public void input_is_added_to_the_actor_search_bar(String string) {
        input = string;
        driver.findElement(By.id("userInput")).sendKeys(string);
    }

    @Then("The related actor results are shown on the page")
    public void the_related_actor_results_are_shown_on_the_page() {

        boolean actual = driver.getPageSource().contains(input.toUpperCase());

        Assertions.assertEquals(true, actual, "Results are not shown correctly");

        driver.quit();
    }

}
