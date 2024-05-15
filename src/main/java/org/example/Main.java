package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {

    static WebDriver driver;
    public static void openLinkedIn() {
        driver.get("https://www.linkedin.com/");
        // Add assertion for validation
    }

    public static void getLinksOnPage() {
        // Code to get links on page
        // Add assertion for validation
    }

    public static void clickOnJobLink() {
        WebElement jobLink = driver.findElement(By.linkText("Jobs"));
        jobLink.click();
        // Add assertion for validation
    }

    public static void searchJob(String jobTitle, String location) {
        WebElement jobTitleInput = driver.findElement(By.id("job-search-bar-keywords"));
        WebElement locationInput = driver.findElement(By.id("job-search-bar-location"));
        jobTitleInput.sendKeys(jobTitle);
        locationInput.clear();
        locationInput.sendKeys(location);
        driver.findElement(By.className("base-search-bar__submit-btn")).click();
//        driver.findElement(By.xpath()).click();

        // Add assertion for validation
    }

    public static void selectAnyJob() {
        WebElement jobListing = driver.findElement(By.className("job-card-container__link"));
        jobListing.click();
        // Add assertion for validation
    }

    public static void readJobDescription() {
        // Code to read job description
        // Add assertion for validation
    }

    public static void printCompanyName() {
        WebElement companyName = driver.findElement(By.className("topcard__org-name-link"));
        System.out.println("Company Name: " + companyName.getText());
        // Add assertion for validation
    }
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver","D:\\Desktop\\selenium\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
//        WebDriver driver = new ChromeDriver();
//        driver.manage().window().maximize();
//        driver.get("http://www.facebook.com");
//        System.out.println(driver.getTitle());
//        driver.quit();

        driver = new ChromeDriver();

        // Test Case 1: Open LinkedIn
        openLinkedIn();

        // Test Case 2: Get the links on page
        getLinksOnPage();

        // Test Case 3: Click on Job link
        clickOnJobLink();

        // Test Case 4: Search for Job "Test Manager" in Pune
        searchJob("Test Manager", "Pune");

        // Test Case 5: Select any Job
        selectAnyJob();

        // Test Case 6: Read the job description
        readJobDescription();

        // Test Case 7: Print the company name
        printCompanyName();

        driver.quit();
    }
}
