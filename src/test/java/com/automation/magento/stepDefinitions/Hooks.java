package com.automation.magento.stepDefinitions;

import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.After;
import org.openqa.selenium.chrome.ChromeOptions;

public class Hooks {
    static WebDriver webDriver;
    @Before
    public void openBrowser() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--headless");
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
    }

    @After
    public void closeBrowser() {
        if(webDriver != null)
            webDriver.quit();
    }
}
