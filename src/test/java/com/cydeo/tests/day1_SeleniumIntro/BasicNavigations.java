package com.cydeo.tests.day1_SeleniumIntro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicNavigations {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        //maximize page
        driver.manage().window().maximize();
        driver.get("https://tesla.com");

        //full screen
        driver.manage().window().fullscreen();

        String currentTitle = driver.getTitle();
        System.out.println("currentTitle = " + currentTitle);

        String currentURL = driver.getCurrentUrl();
        System.out.println("currentURL = " + currentURL);
        //Stop code execution for 3 seconds
        Thread.sleep(3000);

        //navigate back
        driver.navigate().back();

        //Stop code execution for 3 seconds
        Thread.sleep(3000);

        //navigate forward
        driver.navigate().forward();

        //Stop code execution for 3 seconds
        Thread.sleep(3000);

        //refresh
        driver.navigate().refresh();

        //use navigate().to();
        driver.navigate().to("https://www.google.com");

        //getTitle()
        System.out.println("driver.getTitle() = " + driver.getTitle());

        //get current URL
        currentURL = driver.getCurrentUrl();
        System.out.println("currentURL = " + currentURL);

        //close the window(tab)
        driver.close();

        //close all the open windows(Exceptions: NoSuchSessionException)
        driver.quit();


    }
}
