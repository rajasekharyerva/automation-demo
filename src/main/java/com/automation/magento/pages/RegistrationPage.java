package com.automation.magento.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegistrationPage {
    private By firstName = By.id("firstname");
    private By lastName = By.id("lastname");
    private By email = By.id("email_address");
    private By password = By.id("password");
    private By confirmPassword = By.id("password-confirmation");
    private By createAnAccount = By.cssSelector(".action.submit.primary");
    private By errorMessage = By.xpath("//div[@class='message-error error message']//div[contains(text(), 'There is already an account with this email address.')]");
     private WebDriver webDriver;

    public RegistrationPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void enterFirstName(String firstName) {
        webDriver.findElement(this.firstName).sendKeys(firstName);
    }

    public void enterLastName(String lastName) {
        webDriver.findElement(this.lastName).sendKeys(lastName);
    }

    public void enterEmail(String email) {
        webDriver.findElement(this.email).sendKeys(email);
    }

    public void enterPassword(String password) {
        webDriver.findElement(this.password).sendKeys(password);
    }

    public void enterConfirmPassword(String confirmPassword) {
        webDriver.findElement(this.confirmPassword).sendKeys(confirmPassword);
    }

    public void clickCreateAnAccount() {
        webDriver.findElement(this.createAnAccount).click();
    }

    public boolean verifyErrorMessage() {
        return webDriver.findElements(this.errorMessage).isEmpty();
    }

    public String getErrorMessage() {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessage));
        return webDriver.findElement(this.errorMessage).getText();

    }
}
