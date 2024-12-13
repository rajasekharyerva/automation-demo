package com.automation.magento.demo;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.Set;

public class TestNGTest {
    WebDriver webDriver;

    @BeforeMethod
    public void beforeMethod() {
        webDriver = new FirefoxDriver();
        webDriver.get("https://nichethyself.com/tourism/home.html");
        webDriver.manage().window().maximize();

    }

    @Test(enabled = true)
    public void test() throws InterruptedException {
        webDriver.findElement(By.linkText("Customized tours")).click();
        //Get Current Window
        String mainWindow = webDriver.getWindowHandle();
        String secondWindow = "";
        String thirdWindow;
        Set<String> allWindows = webDriver.getWindowHandles();
        for (String window : allWindows) {
            if (!window.equals(mainWindow)) {
                secondWindow = window;
                webDriver.switchTo().window(window);
            }
        }

        WebElement daysWE = webDriver.findElement(By.id("days"));
        Select staySelect = new Select(daysWE);
        staySelect.selectByVisibleText("Home Stay");
        webDriver.findElement(By.xpath("//label[text()='England']/input")).click();
        webDriver.findElement(By.xpath("//button[text()='Contact us!']")).click();
        allWindows = webDriver.getWindowHandles();
        for (String window : allWindows) {
            if (!window.equals(mainWindow) && !window.equals(secondWindow)) {
                thirdWindow = window;
                webDriver.switchTo().window(thirdWindow);
                webDriver.manage().window().maximize();
            }
        }
        webDriver.findElement(By.xpath("//div[@class='card-header']//a")).click();
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(30));
        Alert alert=wait.until(ExpectedConditions.alertIsPresent());
        alert.sendKeys("London");
        webDriver.switchTo().alert().accept();

        webDriver.close();
        webDriver.switchTo().window(secondWindow);
        webDriver.findElement(By.xpath("(//button[text()='Submit'])[1]")).click();
        webDriver.switchTo().alert();



    }

    @Test(enabled = false)
    public void selectFrom() throws InterruptedException {
        //close model
        WebElement closeButton= webDriver.findElement(By.xpath("//span[@role='presentation']"));
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].click();", closeButton);
        WebElement from = webDriver.findElement(By.xpath("//span[text()='From']/parent::div"));
        from.click();
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(30));
        WebElement fromInput = webDriver.findElement(By.xpath("//input[@type='text']"));
        wait.until(ExpectedConditions.visibilityOf(fromInput));
        fromInput.sendKeys("Ben");
        String match = "Bengaluru";
        List<WebElement> fromList = webDriver.findElements(By.xpath("//ul[@id='autoSuggest-list']/li"));
        wait.until(ExpectedConditions.visibilityOfAllElements(fromList));
        for(WebElement we: fromList) {
            if(we.getText().contains(match)) {
                we.click();
                break;
            }
        }

        WebElement fromSelectedWE = webDriver.findElement(By.xpath("//span[text()='From']/following-sibling::p[1]"));
        String fromSelected = fromSelectedWE.getText();
        Assert.assertTrue(fromSelected.contains(match));
        System.out.println("----");
    }


    @AfterMethod
    public void afterMethod() {
        webDriver.quit();
    }
}

/*
1. https://nichethyself.com/tourism/home.html
2. Go to "Customized tours"
3. Select "Home Stay" in preferred stay dropwdown/combo towards the bottom of the page.
4. Click on "England" checkbox
5. From above now click on "Contact Us" menu on top right corner
6. On "Contact Us" window, click on Search icon.
7. Enter "London" on the pop up window and click on OK.
8. Close "Contact Us" window and click on "Submit" button on customized tour

1. Go to https://www.goibibo.com/
2. In From - type - Ben
3. Select Bengaluru from the list.
4. Verify that the Bangluru is indeed selected
*/
