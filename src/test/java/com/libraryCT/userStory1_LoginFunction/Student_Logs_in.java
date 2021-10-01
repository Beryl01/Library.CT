package com.libraryCT.userStory1_LoginFunction;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Student_Logs_in {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();

        List<String> credentials=new ArrayList<>();
        credentials.addAll(Arrays.asList("student66@library","student67@library","student68@library"));

        for(String eachCredential: credentials){

            WebDriver driver =new ChromeDriver();
            driver.navigate().to("https://library2.cybertekschool.com/login.html");

            String urlTitle=driver.getCurrentUrl();

            if(urlTitle.equals("https://library2.cybertekschool.com/login.html")){
                System.out.println("Test passed.");
            }else {
                System.out.println("Test failed: Actual URL is: "+urlTitle);
            }

            Thread.sleep(3000);

            WebElement inputUsername=driver.findElement(By.id("inputEmail"));
            inputUsername.sendKeys(eachCredential);

            Thread.sleep(3000);

            WebElement inputPassword=driver.findElement(By.id("inputPassword"));
            inputPassword.sendKeys("Sdet2022*");
            Thread.sleep(2000);
            WebElement signinButton = driver.findElement(By.tagName("button"));
            signinButton.click();

            Thread.sleep(3000);
            List <WebElement> modules = driver.findElements(By.className("title"));

            for (WebElement eachModule : modules) {
                if(modules.size() == 2){
                    System.out.println("There are 2 models on the page");
                }else{

                    System.out.println("Test failed, actual result is " + modules.size());
                }
            }

            Thread.sleep(2000);

            for (WebElement eachModel : modules) {
                System.out.println("eachModel.getText() = " + eachModel.getText());
            }

            driver.quit();

        }

    }
}

/*
AC#2:
Given student is on the loginPage
Then verify that the URL is “https://library2.cybertekschool.com/login.html”
When student enters valid email address and password
And student click sign in button
Then verify that there are 2 models on the page

userName:                       password:
student66@library               Sdet2022*
student67@library               Sdet2022*
student68@library               Sdet2022*
 */