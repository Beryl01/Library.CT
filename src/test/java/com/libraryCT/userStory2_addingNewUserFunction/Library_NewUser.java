package com.libraryCT.userStory2_addingNewUserFunction;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Library_NewUser {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://library2.cybertekschool.com/login.html");

        Thread.sleep(2000);

        WebElement inputUsername=driver.findElement(By.id("inputEmail"));
        inputUsername.sendKeys("librarian53@library");

        Thread.sleep(2000);

        WebElement inputPassword=driver.findElement(By.id("inputPassword"));
        inputPassword.sendKeys("Sdet2022*");

        Thread.sleep(2000);

        WebElement signInBtn=driver.findElement(By.tagName("button"));
        signInBtn.click();

        Thread.sleep(3000);

        WebElement userModule=driver.findElement(By.linkText("Users"));
        userModule.click();

        Thread.sleep(2000);
        WebElement totalUsers= driver.findElement(By.id("tbl_users_info"));
        String totalUsersMessage=totalUsers.getText();

        WebElement addUserBtn=driver.findElement(By.xpath("//*[@id='users']/div[1]/div[1]/span/a"));
        addUserBtn.click();

        Thread.sleep(2000);
        WebElement fullName=driver.findElement(By.name("full_name"));
        fullName.sendKeys("Beryl Negesa Otieno");

        Thread.sleep(2000);

        WebElement passwordBox =  driver.findElement(By.name("password"))  ;
        passwordBox.sendKeys("Sdet2022*");

        Thread.sleep(2000);

        WebElement emailBox = driver.findElement(By.name("email"));
        emailBox.sendKeys("beryl1015@gmail.com");

        Thread.sleep(2000);

        WebElement addressBox = driver.findElement(By.id("address"));
        addressBox.sendKeys("20105 Nairobi city Kenya zipcode 00100");

        Thread.sleep(3000);
        WebElement saveChangesBtn=driver.findElement(By.xpath("//*[@id='add_user_form']/div[2]/button[2]"));
        saveChangesBtn.submit();

        Thread.sleep(2000);

        WebElement totalUsersAfterAdding=driver.findElement(By.id("tbl_users_info"));
        String afterAddingTotalUsers=totalUsersAfterAdding.getText();

        if (! totalUsersMessage.equals(afterAddingTotalUsers)){
            System.out.println("Test passed. User number increased by one");
            System.out.println("Total users before: "+totalUsersMessage);
            System.out.println("Total users after: "+afterAddingTotalUsers);
        }else {
            System.out.println("Test is failed. Total users number did not increase");
            System.out.println(totalUsersMessage);
            System.out.println(afterAddingTotalUsers);
        }

        driver.quit();

    }
}
/*
AC #1:
Given librarian is on the homePage
When librarian click Users module
And librarian click “+Add User” button
When librarian enter full name, password, email and address
And librarian click save changes
Then verify a new user is created
 */