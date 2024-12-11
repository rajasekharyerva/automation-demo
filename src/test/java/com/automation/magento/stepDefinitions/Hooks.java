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
        // Check if running in CI environment
        String isCI = System.getenv("CI");
        if ("true".equals(isCI)) {
            chromeOptions.addArguments("--headless", "--disable-gpu", "--no-sandbox");
        }

        chromeOptions.addArguments("start-maximized");
        webDriver = new ChromeDriver(chromeOptions);
    }

    @After
    public void closeBrowser() {
        if(webDriver != null)
            webDriver.quit();
    }
}
