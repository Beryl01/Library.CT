package com.libraryCT.userStory1_LoginFunction;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Invalid_Credentials {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        List<String> credentials =new ArrayList<>();
        credentials.addAll(Arrays.asList("student@library","librarian@com", "students@com",
                "student_53@library","librarian@cybertek.com"));
           int testNumber =1;
        for (String eachCredential : credentials) {
           WebDriver driver = new ChromeDriver();
           driver.get("http://library2.cybertekschool.com/login.html");
           Thread.sleep(2000);

            WebElement inputUsername=driver.findElement(By.id("inputEmail"));
            inputUsername.sendKeys(eachCredential);

            Thread.sleep(3000);

            WebElement inputPassword=driver.findElement(By.id("inputPassword"));
             String wrongPassword ="6667685321";
             String validPassword ="Sdet2022*";
            if (eachCredential.equals("student66@library" )|| eachCredential.equals("student67@library")
                    ||eachCredential.equals("student68@library" )){
                inputPassword.sendKeys(wrongPassword);
            }else {
                inputPassword.sendKeys(validPassword);
            }

            Thread.sleep(2000);
            WebElement signinButton = driver.findElement(By.tagName("button"));
            signinButton.click();

            Thread.sleep(3000);
            WebElement errorMessage =driver.findElement(By.cssSelector("#login-form > div:nth-child(2) > div"));
            WebElement invalidMessage=driver.findElement(By.cssSelector("#login-form > div:nth-child(2) > div"));

            String getErrorMessage= errorMessage.getText();
            String getInvalidMessage=invalidMessage.getText();

            if(getErrorMessage.equals("Sorry, Wrong Email or Password")){
                System.out.println("Test "+testNumber+ ", "+eachCredential+", "+" passed. " +
                        "Expecting error message is: Sorry, Wrong Email or Password");
                System.out.println("Actual error message is :"+getErrorMessage);
            }else{
                System.out.println("Test "+testNumber+", "+eachCredential+", "+" failed. " +
                        "Expecting message is : Sorry, Wrong Email or Password");
                System.out.println("Actual error message is: "+getInvalidMessage);
            }

            driver.quit();

            testNumber++;

        }

    }
}

/*
AC #3 [negative]:
Given user is on the loginPage
When user enters invalid email address or password
And student click sign in button
Then verify the error message “Sorry, Wrong Email or Password”

userName:                       password:
librarian53@library             Sdet2022*
librarian21@library             Sdet2022*
student66@library               Sdet2022*
student67@library               Sdet2022*
student68@library               Sdet2022*
 */