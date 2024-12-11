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

    - Use **IntelliJ IDEA** for a smooth development experience.
    - Ensure that you have the **Cucumber** and **Selenium** plugins installed in your IDE.

## Test Scenarios

### Login Scenarios

1. **Verify Login with Valid Credentials:**
    - User enters valid email and password and successfully logs in to the dashboard.

2. **Verify Login with Invalid Credentials:**
    - User enters invalid credentials (email or password) and receives an error message.

### Registration Scenarios

1. **Verify Successful Registration:**
    - User provides valid details (first name, last name, email, password, and confirm password), and the account is created successfully.

2. **Verify Registration with an Already Existing Email:**
    - User tries to register with an already existing email address, and an error message is shown indicating that the email is already used.

## Test Case Execution

### Running Tests Locally:

1. **Execute Tests with Maven:**

   To run all the tests locally, execute the following command:

    ```bash
    mvn clean test
    ```

### Running Tests with GitHub Actions:

- The tests are configured to run on **GitHub Actions**. The CI workflow is located in `.github/workflows/cucumber-tests.yml`.
- To run this need to update headless