package com.automation.magento.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private By email = By.id("email");
    private By password = By.id("pass");
    private By signInButton = By.cssSelector(".action.login.primary");
    private By errorMessage = By.xpath("//div[@class='message-error error message']//div[contains(text(), 'The account sign-in was incorrect or your account is disabled temporarily. Please wait and try again later.')]");
    private WebDriver webDriver;

    public LoginPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void enterEmail(String email) {
        webDriver.findElement(this.email).sendKeys(email);
    }

    public void enterPassword(String password) {
        webDriver.findElement(this.password).sendKeys(password);
    }

    public void clickSignInButton() {
        webDriver.findElement(this.signInButton).click();
    }

    public boolean verifyErrorMessage() {
        return webDriver.findElements(this.errorMessage).isEmpty();
    }

    public String getErrorMessage() {
        System.out.println(webDriver.findElements(this.errorMessage).size());
        return webDriver.findElement(this.errorMessage).getText();
    }
}
