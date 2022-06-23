package com.tsi.yash.program.CucumberStepDefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class navigatingPageStepDef {

    private WebDriver driver;

    @Given("The website is running")
    public void the_website_is_running() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://localhost:3000/");
    }

    @When("The navigation {string} button is clicked")
    public void the_navigation_button_is_clicked(String string) {

        driver.findElement(By.id(string)).click();


    }

    @Then("The correct {string} page is displayed")
    public void the_correct_page_is_displayed(String string) {

        driver.get(driver.getCurrentUrl());

        String expectedURL = "http://localhost:3000/" + string;

        Assertions.assertEquals(expectedURL, driver.getCurrentUrl(), "Navigation link not sent to right location");

        driver.quit();

    }

}
