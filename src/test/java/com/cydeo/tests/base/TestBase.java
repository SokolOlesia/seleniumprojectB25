package com.cydeo.tests.base;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase {
    protected WebDriver driver;

    @BeforeMethod
    public void setUp(){
        //Driver.getDriver().get(getProperty("env"));
        Driver.getDriver();
    }
    @AfterMethod
    public void tearDown(){
        Driver.closeDriver();
    }

}
