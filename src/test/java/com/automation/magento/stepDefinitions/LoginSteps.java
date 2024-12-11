package com.automation.magento.stepDefinitions;

import com.automation.magento.pages.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

import java.util.logging.Logger;

import static org.testng.Assert.assertEquals;

import static com.automation.magento.stepDefinitions.Hooks.webDriver;

public class LoginSteps {
    LoginPage loginPage = new LoginPage(webDriver);
    private static final Logger logger = Logger.getLogger(LoginSteps.class.getName());
    @And("enters Email {string}, Password {string}")
    public void entersEmailPassword(String email, String password) {
        logger.info(String.format("Entering Email: %s", email));
        loginPage.enterEmail(email);
        logger.info("Entering Password: ");
        loginPage.enterPassword(password);
    }

    @And("clicks on the signIn button")
    public void clicksOnTheSignInButton() {
        logger.info("Clicking on Sign In button");
        loginPage.clickSignInButton();
    }

    @Then("user should see a login error message {string}")
    public void userShouldSeeALoginErrorMessage(String errorMessage) {
        logger.info("Getting error message");
        assertEquals(loginPage.getErrorMessage(), errorMessage, "Error message not matched");
    }

    @And("enters static Email {string}, static Password {string}")
    public void entersStaticEmailStaticPassword(String email, String password) {
        // Checks if email is empty, taking it from static value if stored
        if (email.isEmpty()) {
            email = com.automation.magento.utilites.Utility.email;
        }
        // Checks if password is empty, taking it from static value if stored
        if (password.isEmpty()) {
            password = com.automation.magento.utilites.Utility.password;
        }

        entersEmailPassword(email, password);
    }

}
