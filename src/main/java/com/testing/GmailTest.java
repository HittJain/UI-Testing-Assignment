package com.testing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class GmailTest {

    public static void main(String[] args) throws InterruptedException {

        // Setup Chrome Driver
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        // Open Gmail login page
        driver.get("https://accounts.google.com/");
        driver.manage().window().maximize();

        Thread.sleep(2000);

        // Test Case 1: Print Title
        System.out.println("Page Title: " + driver.getTitle());

        // Test Case 2: Enter invalid email
        WebElement email = driver.findElement(By.id("identifierId"));
        email.sendKeys("invalidemail");

        driver.findElement(By.id("identifierNext")).click();
        Thread.sleep(2000);

        // Capture error message
        WebElement error = driver.findElement(By.xpath("//div[@class='o6cuMc']"));
        System.out.println("Error Message: " + error.getText());

        // Test Case 3: Clear and test empty input
        email.clear();
        driver.findElement(By.id("identifierNext")).click();
        Thread.sleep(2000);

        // Test Case 4: Click Create Account
        driver.findElement(By.xpath("//span[text()='Create account']")).click();
        Thread.sleep(2000);

        // Test Case 5: Forgot Email
        driver.navigate().back();
        driver.findElement(By.xpath("//button[contains(text(),'Forgot email')]")).click();

        Thread.sleep(3000);

        driver.quit();
    }
}