package com.libraryCT;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LibraryDryRun {
    public static void main(String[] args) {
        // 1. Setup Chrome Driver so selenium can use it to automate chrome
        WebDriverManager.chromedriver().setup();
        // 2. Create Chrome Driver object to open browser
        WebDriver driver = new ChromeDriver();
        //3. Navigate to http://library2.cybertekschool.com/login.html
        driver.navigate().to("http://library2.cybertekschool.com/login.html");
    }
}
