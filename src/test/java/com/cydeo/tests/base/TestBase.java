package com.cydeo.tests.base;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import static com.cydeo.utilities.ConfigurationReader.getProperty;

public class TestBase {
    protected WebDriver driver;

    @BeforeMethod
    public void setUp(){
        Driver.getDriver().get(getProperty("env"));
    }
    @AfterMethod
    public void tearDown(){
        Driver.closeDriver();
    }

}
