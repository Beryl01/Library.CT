package com.libraryCT.userStory4_LogoutFunction;

import com.libraryCT.utility.TestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class Logout_SuccessfullyTest extends TestBase {
    @Test
   public void testLibrarianLogOutPage()throws InterruptedException {

        driver.get("http://library2.cybertekschool.com/login.html");

        WebElement emailAddressBox = driver.findElement(By.xpath("//input[@id='inputEmail']"));
        emailAddressBox.sendKeys("librarian53@library");

        WebElement passwordBox = driver.findElement(By.xpath("//input[@id='inputPassword']"));
        passwordBox.sendKeys("Sdet2022*");

        WebElement sigInBtn = driver.findElement(By.xpath("//button[@class='btn btn-lg btn-primary btn-block']"));
        sigInBtn.click();

        Thread.sleep(3000);
        WebElement currentUser = driver.findElement(By.linkText("Test Librarian 53"));
        currentUser.click();

        Thread.sleep(2000);
        WebElement logOut =driver.findElement(By.linkText("Log Out"));
        logOut.click();

        String expectedTitle = "Login - Library" ;
        String actualTitle = driver.getTitle();
        assertEquals(expectedTitle,actualTitle ) ;

    }

}

/*
AC #1:
Given user is on the homePage
When user click username on the right top corner
And user click Log Out
Then verify user navigate back to login page.
 */










