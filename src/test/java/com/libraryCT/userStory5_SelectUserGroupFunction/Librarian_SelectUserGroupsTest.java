package com.libraryCT.userStory5_SelectUserGroupFunction;

import io.github.bonigarcia.wdm.WebDriverManager;
;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Librarian_SelectUserGroupsTest {

   @Test
   public void  librarianSelectUserGroupsSuccessfullyTest() throws InterruptedException {

       WebDriverManager.chromedriver().setup();

       List <String> librarian = new ArrayList<>();
       librarian.addAll(Arrays.asList("librarian53@library","librarian21@library"));

       for (String eachLibrarian : librarian) {

           WebDriver driver = new ChromeDriver();

           driver.get("http://library2.cybertekschool.com/login.html");
           driver.manage().window().maximize();

           WebElement emailAddressBox = driver.findElement(By.xpath("//input[@id='inputEmail']"));
           emailAddressBox.sendKeys(eachLibrarian);

           WebElement passwordBox = driver.findElement(By.xpath("//input[@id='inputPassword']"));
           passwordBox.sendKeys("Sdet2022*");

           WebElement sigInBtn = driver.findElement(By.xpath("//button[@class='btn btn-lg btn-primary btn-block']"));
           sigInBtn.click();
           Thread.sleep(3000);

           WebElement usersModule = driver.findElement(By.xpath("//span[@class='title' and text()='Users']"));
           usersModule.click();

           Thread.sleep(3000);
           WebElement userGroupDropDown = driver.findElement(By.id("user_groups"));
           userGroupDropDown.click();

           Thread.sleep(3000);

           List<WebElement> librarianOption = driver.findElements(By.xpath("//select[@id='user_groups']//option"));
           int expectedOption = 3;
           int actualOption = librarianOption.size();
           assertEquals(expectedOption, actualOption);

           driver.quit();

       }

   }

}

/*
AC #1:
Given librarian is on the homePage
When librarian click Users module
And librarian click user group dropdown
Then verify librarian have 3 options
 */
