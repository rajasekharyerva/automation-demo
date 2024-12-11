package com.automation.magento.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    private By cretaeAnAccountLink = By.linkText("Create an Account");
    private By signInLink = By.linkText("Sign In");
    private By loggedIn = By.cssSelector(".logged-in");
    private By signOut = By.linkText("Sign Out");
    private By switchButton = By.xpath("//div[@class='panel header']//button[@class='action switch']");
    private By welcomeMessage = By.xpath("//div[@class='message-success success message']//div[contains(text(), 'Thank you for registering with Main Website Store.')]");
    private WebDriver webDriver;

    public HomePage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void clickCreateAccountLink() {
        webDriver.findElement(cretaeAnAccountLink).click();
    }

    public String getWelcomeMessage() {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(welcomeMessage));
        return webDriver.findElement(welcomeMessage).getText();
    }

    public void clickSignInLink() {
        webDriver.findElement(signInLink).click();
    }

    public boolean isLoggedIn() {
        return !webDriver.findElements(loggedIn).isEmpty();
    }

    public String getLoggedInUser() {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(loggedIn));
        return webDriver.findElement(loggedIn).getText();
    }

    public void clickSignOut() {
        webDriver.findElement(signOut).click();
    }

    public void clickSwitchButton() {
        webDriver.findElement(switchButton).click();
    }
}
