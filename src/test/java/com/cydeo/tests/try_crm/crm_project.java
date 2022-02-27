package com.cydeo.tests.try_crm;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.CRM_Utilities;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class crm_project {
    public WebDriver driver;
    @BeforeMethod
    public void setupMethod(){
        String browserType = ConfigurationReader.getProperty("browser");
        driver = WebDriverFactory.getDriver(browserType);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }
    @AfterMethod
    public void teardownMethod() {
        driver.quit();
    }



    @Test
    public void moreTab() throws InterruptedException {
        //1 step: go to login page
        driver.get(ConfigurationReader.getProperty("env"));

        //2: find web element User and give keys
        //3: find web element password and give keys
        //4: find web element login button

        CRM_Utilities.crm_login(driver, "hr85@cydeo.com", "UserUser");

        //5: we on the home page or not
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        BrowserUtils.verifyTitle(driver, "Portal");

        //6: Find more tab and click
        WebElement moreButton = driver.findElement(By.xpath("//span[@id='feed-add-post-form-link-text']"));
        moreButton.click();

        //7.1: verify the file option
        WebElement fileOption = driver.findElement(By.xpath("//span[.='File']"));
        //Thread.sleep(3000);

        String firstExpectedOption = "File";
        Assert.assertEquals(fileOption.getText(), firstExpectedOption);


        //7.2: verify the Appreciation option
        WebElement appreciationOption = driver.findElement(By.xpath("//span[.='Appreciation']"));

        String secondExpectedOption = "Appreciation";
        Assert.assertEquals(appreciationOption.getText(), secondExpectedOption);


        //7.3: verify the Announcement option
        WebElement announcementOption = driver.findElement(By.xpath("//span[.='Announcement']"));

        String thirdExpectedOption = "Announcement";
        Assert.assertEquals(announcementOption.getText(), thirdExpectedOption);


        //7.4: verify the Workflow option
        WebElement workflowOption = driver.findElement(By.xpath("//span[.='Workflow']"));

        String fourthExpectedOption = "Workflow";
        Assert.assertEquals(workflowOption.getText(), fourthExpectedOption);


        System.out.println("First option is " + fileOption.getText());
        System.out.println("Second option is " + appreciationOption.getText());
        System.out.println("Third option is " + announcementOption.getText());
        System.out.println("Fourth option is " + workflowOption.getText());

    }
}
