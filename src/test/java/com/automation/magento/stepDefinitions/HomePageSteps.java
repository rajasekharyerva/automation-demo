package com.automation.magento.stepDefinitions;

import com.automation.magento.pages.HomePage;
import com.automation.magento.utilites.ConfigReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.logging.Logger;

import static com.automation.magento.stepDefinitions.Hooks.webDriver;
import static org.testng.Assert.assertEquals;

public class HomePageSteps {
    HomePage homePage = new HomePage(webDriver);
    private static final Logger logger = Logger.getLogger(HomePageSteps.class.getName());
    @Given("user is on the home page")
    public void userIsOnTheHomePage() {
        String url = ConfigReader.getProperty("home.url");
        logger.info(String.format("Get URL: %s", url));
        webDriver.get(url);
    }

    @When("clicks on the CreateAnAccount link")
    public void clicksOnTheCreateAnAccountLink() {
        logger.info("Clicking on Create Account link");
        homePage.clickCreateAccountLink();
    }


    @Then("user should see a welcome message {string}")
    public void userShouldSeeAWelcomeMessage(String successMessage) {
        logger.info("Getting welcome message");
        assertEquals(homePage.getWelcomeMessage(), successMessage, "Welcome message is not matched");
    }

    @When("clicks on the Sign In link")
    public void clicksOnTheSignInLink() {
        logger.info("Clicking on Sign In link");
        homePage.clickSignInLink();
    }

    @Then("user should see a welcome user message {string}")
    public void userShouldSeeAWelcomeUserMessage(String firstname) {

        assertEquals(homePage.getLoggedInUser(), "Welcome, "+firstname+"!", "Welcome message not matched");

    }

    @And("user clicks sign out")
    public void userClicksSignOut() {
        logger.info("Clicking on Sign Out link");
        homePage.clickSwitchButton();
        homePage.clickSignOut();
    }
}
