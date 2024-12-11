package com.automation.magento.stepDefinitions;

import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.After;

public class Hooks {
    static WebDriver webDriver;
    @Before
    public void openBrowser() {
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
    }

    @After
    public void closeBrowser() {
        if(webDriver != null)
            webDriver.quit();
    }
}
