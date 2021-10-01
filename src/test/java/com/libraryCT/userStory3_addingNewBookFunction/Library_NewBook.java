package com.libraryCT.userStory3_addingNewBookFunction;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Library_NewBook {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();

        WebDriver driver =new ChromeDriver();
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

        WebElement booksModule=driver.findElement(By.xpath("//ul[@id='menu_item']//a[@href='#books']/span[@class='title']"));
        booksModule.click();

        Thread.sleep(2000);

        WebElement totalBooksNumberBeforeAdding=driver.findElement(By.id("tbl_books_info"));
        String totalBooksBeforeM= totalBooksNumberBeforeAdding.getText();

        WebElement addBookBtn=driver.findElement(By.xpath("//*[@id='books']/div[1]/div[1]/span/a"));
        addBookBtn.click();

        Thread.sleep(3000);

        WebElement bookName=driver.findElement(By.cssSelector("#add_book_form > div.modal-body > div " +
                "> div:nth-child(1) > div.col-6 > div > input"));

        bookName.sendKeys("Khalisy Halima");

        Thread.sleep(2000);

        WebElement iSbN=driver.findElement(By.name("isbn"));
        iSbN.sendKeys("10151995");

        Thread.sleep(2000);

        WebElement bookYear=driver.findElement(By.name("year"));
        bookYear.sendKeys("2021");

        Thread.sleep(2000);

        WebElement authorName=driver.findElement(By.cssSelector("#add_book_form > div.modal-body > " +
                "div > div:nth-child(2) > div:nth-child(1) > div > input"));
        authorName.sendKeys("Beryl Negesa");

        Thread.sleep(2000);

        WebElement descriptionOfBook=driver.findElement(By.id("description"));
        descriptionOfBook.sendKeys("The rise of a queen from a slave girl" );

        Thread.sleep(3000);

        WebElement saveBtn= driver.findElement(By.xpath("//*[@id='add_book_form']/div[2]/button[2]"));
        saveBtn.submit();

        Thread.sleep(4000);

        WebElement totalBooksNumberAfterAdding=driver.findElement(By.id("tbl_books_info"));
        String totalBooksAfterM=totalBooksNumberAfterAdding.getText();

        if( ! totalBooksBeforeM.equals(totalBooksAfterM)){
            System.out.println("Test passed. Total books number increased by one");
            System.out.println("Total books before: "+totalBooksBeforeM);
            System.out.println("Total books after: "+totalBooksAfterM);
        }else {
            System.out.println("Test failed. Total book number did not increase");
            System.out.println("Total books number: "+totalBooksBeforeM);
            System.out.println("Total books number: "+totalBooksAfterM);
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