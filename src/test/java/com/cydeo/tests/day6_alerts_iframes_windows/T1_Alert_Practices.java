package com.cydeo.tests.day6_alerts_iframes_windows;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class T1_Alert_Practices {
    public WebDriver driver;
    @BeforeMethod
    public void setupMethod(){
        //1. Open browser
        //2. Go to website: http://practice.cydeo.com/javascript_alerts
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("http://practice.cydeo.com/javascript_alerts");


    }
    @Test
    public void alert_test1(){
        //TC #1: Information alert practice
        //3. Click to “Click for JS Alert” button
        WebElement informationAlertButton = driver.findElement(By.xpath("//button[@onclick='jsAlert()']"));
        informationAlertButton.click();
        //button[.='Click for JS Alert']
        //4. Click to OK button from the alert
        Alert alert = driver.switchTo().alert();
        alert.accept();

        //5. Verify “You successfully clicked an alert” text is displayed.
//        String expectedText = "You successfully clicked an alert";
//        String actualText = driver.findElement(By.xpath("//p[@id='result']")).getText();
//        Assert.assertEquals(actualText,expectedText);
        WebElement resultText = driver.findElement(By.xpath("//p[@id='result']"));
        Assert.assertTrue(resultText.isDisplayed(),"Result text is NOT displayed.");
    }

    @Test
    public void alert_test2(){
        //TC #2: Confirmation alert practice
        //3. Click to “Click for JS Confirm” button
        WebElement confirmButton = driver.findElement(By.xpath("//button[@onclick='jsConfirm()']"));
        confirmButton.click();
        //4. Click to OK button from the alert
        Alert alert2 = driver.switchTo().alert();
        alert2.accept();
        //5. Verify “You clicked: Ok” text is displayed.
        String expectedText = "You clicked: Ok";
        String actualText = driver.findElement(By.xpath("//p[@id='result']")).getText();
        Assert.assertEquals(actualText,expectedText);


    }

    @AfterMethod
    public void teardownMethod() {
        driver.close();
    }


}
