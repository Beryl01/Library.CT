package com.libraryCT.userStory7_FilteringBookCategoryFunction;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class A_User_Has21options {

    @Test
    public void bookCategoriesHas21optionsTest() throws InterruptedException {

        WebDriverManager.chromedriver().setup();

        List<String> credentials = new ArrayList<>();
        credentials.addAll(Arrays.asList("librarian53@library","librarian21@library",
                "student66@library","student67@library","student68@library"));

        for (String eachCredential : credentials) {
            String email = eachCredential;

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

            WebElement booksFunction = driver.findElement(By.xpath("//span[@class='title' and text()='Books']"));
            booksFunction.click();
            Thread.sleep(5000);
            WebElement bookCategoriesDropDown = driver.findElement(By.id("book_categories"));
            bookCategoriesDropDown.click();
            Thread.sleep(5000);

            List<WebElement> bookCategoriesList = driver.findElements(By.xpath("//select[@id='book_categories']//option"));
            Thread.sleep(2000);

            driver.quit();
            int expectedOptions = 21;
            int actualOptions = bookCategoriesList.size();
            assertEquals(expectedOptions, actualOptions);
            // System.out.println( bookCategoriesList.size());
        }
    }

    /*AC2*/
    @Test
    public void bookCategoriesSelectDramaTest() throws InterruptedException {

        WebDriverManager.chromedriver().setup();

        List<String> credentials = new ArrayList<>();
        credentials.addAll(Arrays.asList("librarian53@library","librarian21@library",
                "student66@library","student67@library","student68@library"));

        for (String eachCredential : credentials) {

            WebDriver driver = new ChromeDriver();

            driver.get("http://library2.cybertekschool.com/login.html");
            driver.manage().window().maximize();

            WebElement emailAddressBox = driver.findElement(By.xpath("//input[@id='inputEmail']"));
            emailAddressBox.sendKeys(eachCredential);

            WebElement passwordBox = driver.findElement(By.xpath("//input[@id='inputPassword']"));
            passwordBox.sendKeys("Sdet2022*");

            WebElement sigInBtn = driver.findElement(By.xpath("//button[@class='btn btn-lg btn-primary btn-block']"));
            sigInBtn.click();
            Thread.sleep(3000);

            WebElement booksFunction = driver.findElement(By.xpath("//span[@class='title' and text()='Books']"));
            booksFunction.click();
            Thread.sleep(5000);

            WebElement bookCategoriesDropDown = driver.findElement(By.id("book_categories"));
            Select selectDrama = new Select(bookCategoriesDropDown);
            Thread.sleep(2000);
            selectDrama.selectByVisibleText("Drama");

            Thread.sleep(5000);
            String expectedOption = "Drama";
            String actualOption=driver.findElement(By.xpath("//select[@id='book_categories']//option[text()='Drama']")).getText();
            assertEquals(expectedOption, actualOption);

            driver.quit();

        }

    }

}

/*
AC #1:
Given user is on the homePage
When user click Books module
And user click book category dropdown
Then verify there are 21 options

AC #2:
Given user is on the homePage
When user click Books module
And user click book category dropdown
Then verify user is able to selected the “Drama” option
 */
