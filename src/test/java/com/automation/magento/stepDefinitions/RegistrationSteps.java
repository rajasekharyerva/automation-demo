package com.automation.magento.stepDefinitions;

import com.automation.magento.pages.RegistrationPage;
import com.automation.magento.utilites.Utility;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import static com.automation.magento.utilites.Utility.email;
import static com.automation.magento.utilites.Utility.password;

import java.util.logging.Logger;

import static com.automation.magento.stepDefinitions.Hooks.webDriver;
import static org.testng.Assert.assertEquals;

public class RegistrationSteps {
    private static final Logger logger = Logger.getLogger(LoginSteps.class.getName());
    RegistrationPage registrationPage  = new RegistrationPage(webDriver);

    @And("enters First Name {string}, Last Name {string}, Email {string}, Password {string}, Confirm Password{string}")
    public void entersFirstNameLastNameEmailPasswordConfirmPassword(String firstName, String lastName, String email, String password, String confirmPassword) {
        Utility.firstName = firstName;
        Utility.lastName = lastName;
        Utility.email = Utility.appendEmailWithTimeStamp(email);
        Utility.password = password;

        entersFirstNameLastName(firstName, lastName);
        entersEmail(Utility.email);
        entersPasswordConfirmPassword(password, confirmPassword);
    }

    @And("clicks on the register button")
    public void clicksOnTheRegisterButton() {
        logger.info("Clicking on Create Account button");
        registrationPage.clickCreateAnAccount();
    }

    @Then("user should see a registration error message {string}")
    public void userShouldSeeARegistrationErrorMessage(String errorMessage) {
        logger.info("Getting error message");
        assertEquals(registrationPage.getErrorMessage(), errorMessage, "Error message is not matched");
    }

    @And("enters Email {string}")
    public void entersEmail(String email) {
        logger.info(String.format("Entering Email: %s", email));
        registrationPage.enterEmail(email);
    }

    @And("enters First Name {string}, Last Name {string}")
    public void entersFirstNameLastName(String firstName, String lastName) {
        logger.info(String.format("Entering First Name: %s", firstName));
        registrationPage.enterFirstName(firstName);
        logger.info(String.format("Entering Last Name: %s", lastName));
        registrationPage.enterLastName(lastName);
    }

    @And("enters Password {string}, Confirm Password{string}")
    public void entersPasswordConfirmPassword(String password, String confirmPassword) {
        logger.info("Entering Password: ");
        registrationPage.enterPassword(password);
        logger.info("Entering Confirm Password: ");
        registrationPage.enterConfirmPassword(confirmPassword);
    }
}
