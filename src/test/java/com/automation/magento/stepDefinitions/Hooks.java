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
        chromeOptions.addArguments("--no-sandbox");
        chromeOptions.addArguments("--disable-dev-shm-usage");
        chromeOptions.addArguments("start-maximized"); // Optional, but can help with visibility issues
        chromeOptions.addArguments("--disable-gpu"); // Disable GPU acceleration (useful in headless mode)
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
    }

    @After
    public void closeBrowser() {
        if(webDriver != null)
            webDriver.quit();
    }
}
