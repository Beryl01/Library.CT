package com.libraryCT.userStory1_LoginFunction;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Librarian_Logs_in {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        List<String> credentials = new ArrayList<>();
        credentials.addAll(Arrays.asList("librarian53@library", "librarian21@library"));

        for (String eachCredential : credentials) {
            WebDriver driver = new ChromeDriver();
            driver.get("http://library2.cybertekschool.com/login.html");
            String pageTitle = driver.getTitle();

            if (pageTitle.equals("Login - Library")) {
                System.out.println("The title is “Login - Library”");
            } else {
                System.out.println("Test failed,actual result ist " + pageTitle);
            }

            WebElement inputUsername = driver.findElement(By.id("inputEmail"));
            inputUsername.sendKeys(eachCredential);

            Thread.sleep(3000);
            WebElement inputPassword = driver.findElement(By.id("inputPassword"));
            inputPassword.sendKeys("Sdet2022*");

            Thread.sleep(3000);
            WebElement signinButton = driver.findElement(By.tagName("button"));
            signinButton.click();

            Thread.sleep(3000);

            List<WebElement> modules = driver.findElements(By.className("title"));
            if (modules.size() == 3) {
                System.out.println("There are 3 models on the page");
            } else {
                System.out.println("Test failed, actual result is " + modules.size());
            }

            Thread.sleep(2000);

            for (WebElement eachModule : modules) {
                System.out.println("eachModule.getText() = " + eachModule.getText());
            }

            driver.quit();

        }
    }
}
/*
AC #1:
Given librarian is on the loginPage
Then verify that the title is “Login - Library”
When librarian enters valid email address and password
And librarian click sign in button
Then verify that there are 3 models on the page


userName:                       password:
librarian53@library             Sdet2022*
librarian21@library             Sdet2022*
 */



