package com.cydeo.tests.base;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DoubleClickPage {

    public DoubleClickPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }
    //@FindBy(xpath = "//div[@id='iframe']")

    @FindBy(id = "demo")
    public WebElement textToDoubleClick;
}
