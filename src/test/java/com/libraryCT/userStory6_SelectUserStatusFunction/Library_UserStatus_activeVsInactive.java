package com.libraryCT.userStory6_SelectUserStatusFunction;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Library_UserStatus_activeVsInactive {

    @Test
    public void librarianSelectUserStatusActiveVsInactiveTest() throws InterruptedException {

        WebDriverManager.chromedriver().setup();

        List<String> librarian = new ArrayList<>();
        librarian.addAll(Arrays.asList("librarian53@library","librarian21@library"));

        for (String eachLibrarian : librarian) {
           String email = eachLibrarian;

            WebDriver driver = new ChromeDriver();

            driver.get("http://library2.cybertekschool.com/login.html");
            driver.manage().window().maximize();

            WebElement emailAddressBox = driver.findElement(By.xpath("//input[@id='inputEmail']"));
            emailAddressBox.sendKeys(email);

            WebElement passwordBox = driver.findElement(By.xpath("//input[@id='inputPassword']"));
            passwordBox.sendKeys("Sdet2022*");

            WebElement sigInBtn = driver.findElement(By.xpath("//button[@class='btn btn-lg btn-primary btn-block']"));
            sigInBtn.click();
            Thread.sleep(3000);

            WebElement usersModule = driver.findElement(By.xpath("//span[@class='title' and text()='Users']"));
            usersModule.click();

            Thread.sleep(2000);
            WebElement statusDropdown = driver.findElement(By.xpath("//select[@id='user_status']"));
            statusDropdown.click();

            Thread.sleep(3000);
             List<WebElement> statusOptions = driver.findElements(By.xpath("//select[@id='user_status']//option"));

            driver.quit();

             int expectedOptions = 2;
             int actualOptions = statusOptions.size();
             assertEquals(expectedOptions,actualOptions);

        }

    }

}

/*
AC #1:
Given librarian is on the homePage
When librarian click Users module
And librarian click Status dropdown
Then verify there are 2 status options
 */

