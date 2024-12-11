# Cucumber Automation

This project contains automation tests for the Magento website using **Cucumber** for BDD (Behavior-Driven Development), **Selenium** for browser automation, and **Page Object Model** (POM) for better maintainability and readability of the code.

## Table of Contents

- [Project Setup](#project-setup)
- [Test Scenarios](#test-scenarios)
    - [Login Scenarios](#login-scenarios)
    - [Registration Scenarios](#registration-scenarios)
- [Test Case Execution](#test-case-execution)
- [Page Object Model](#page-object-model)
- [Step Definitions](#step-definitions)
- [Report Generation](#report-generation)
- [Running Tests on GitHub Actions](#running-tests-on-github-actions)
- [License](#license)

## Project Setup

1. **Clone the repository:**

    ```bash
    git clone https://github.com/rajasekharyerva/automation-demo.git
    ```

2. **Install dependencies:**

    - You will need **Java 17** (or higher) and **Maven** to run the tests.

    ```bash
    mvn clean install
    ```

3. **IDE Setup:**

    - Use **IntelliJ IDEA** or **Eclipse** for a smooth development experience.
    - Ensure that you have the **Cucumber** and **Selenium** plugins installed in your IDE.

## Test Scenarios

### Login Scenarios

1. **Verify Login with Valid Credentials:**
    - User enters valid email and password and successfully logs in to the dashboard.

2. **Verify Login with Invalid Credentials:**
    - User enters invalid credentials (email or password) and receives an error message.

3. **Verify Mandatory Fields for Login:**
    - User leaves email and password blank and clicks login, expecting error messages for missing fields.

4. **Verify Invalid Email Format for Login:**
    - User enters an invalid email format (e.g., `user@domain`, `user@@domain.com`) and receives an error message.

### Registration Scenarios

1. **Verify Successful Registration:**
    - User provides valid details (first name, last name, email, password, and confirm password), and the account is created successfully.

2. **Verify Registration with an Already Existing Email:**
    - User tries to register with an already existing email address, and an error message is shown indicating that the email is already used.

3. **Verify Mandatory Fields for Registration:**
    - User leaves one or more mandatory fields (e.g., first name, last name, email, password, or confirm password) blank and attempts to register. The system should show appropriate error messages.

4. **Verify Email Field with Invalid Email Formats:**
    - User enters invalid email formats and tries to register. Error messages should prompt the user to provide a valid email address.

5. **Verify Password Length and Complexity:**
    - User provides a password that does not meet the length and complexity requirements (e.g., password too short, missing upper or lower case letters, or numbers).

6. **Verify Password and Confirm Password Match:**
    - User enters different values in the "Password" and "Confirm Password" fields, and an error message is displayed.

## Test Case Execution

### Running Tests Locally:

1. **Execute Tests with Maven:**

   To run all the tests locally, execute the following command:

    ```bash
    mvn clean test
    ```

2. **Execute Tests with Specific Profile:**

   You can also run tests for specific scenarios or tags using Maven:

    ```bash
    mvn clean test -Dcucumber.options="--tags @Login/@Registration"
    ```

### Running Tests with GitHub Actions:

- The tests are configured to run on **GitHub Actions**. The CI workflow is located in `.github/workflows/ci.yml`.

- Upon pushing changes to the repository, tests will automatically be triggered based on the GitHub Actions configuration.

## Page Object Model

The project uses the **Page Object Model** (POM) design pattern for maintaining page classes that represent the different pages in the application. This allows for better reusability and readability.

### Example of a Page Object:

```java
package com.automation.magento.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    WebDriver driver;
    
    // Locator for Create Account Link
    private By createAccountLink = By.linkText("Create an Account");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    // Action: Click on Create Account Link
    public void clickCreateAccountLink() {
        driver.findElement(createAccountLink).click();
    }
}
