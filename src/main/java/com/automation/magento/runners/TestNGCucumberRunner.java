package com.automation.magento.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = "com.automation.magento.stepDefinitions",
        plugin = {"pretty", "html:target/cucumber-html-reports.html","json:target/cucumber.json"},
        dryRun = false,
        //tags = "",
        monochrome = true
)
public class TestNGCucumberRunner extends AbstractTestNGCucumberTests {
}
