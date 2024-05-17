package org.example;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Test {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Jatin\\Desktop\\Chrome Driver\\chromedriver-win64\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--incognito");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.get("https://www.linkedin.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(12));
		WebElement jobLink = driver.findElement(By.linkText("Jobs"));
        jobLink.click();
        WebElement jobTitleInput = driver.findElement(By.id("job-search-bar-keywords"));
        WebElement locationInput = driver.findElement(By.id("job-search-bar-location"));
        jobTitleInput.sendKeys("Test Manager");
        locationInput.clear();
        locationInput.sendKeys("Pune");
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(12));
        driver.findElement(By.xpath("//input[contains(@value,'jobs-search-bar_search-submit')]/following-sibling::button")).click();
        
        try {
            Thread.sleep(7000); // Add a brief pause to ensure search results are loaded
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        List<WebElement> allJobs = driver.findElements(By.xpath("//ul[@class='jobs-search__results-list']/li/div/a"));
    	allJobs.get(0).click();
    	
    	 try {
             Thread.sleep(7000); // Add a brief pause to ensure search results are loaded
         } catch (InterruptedException e) {
             e.printStackTrace();
         }
    	 
    	 allJobs.get(2).click();
    	 WebElement companyName = driver.findElement(By.xpath("//a[contains(@data-tracking-control-name,'public_jobs_topcard-org')]"));
    	 System.out.println(companyName.getText());
	}
}