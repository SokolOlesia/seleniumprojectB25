package com.cydeo.tests.day10_upload_actions_jsexecuter;

import com.cydeo.tests.base.TestBase;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class T2_UploadTask extends TestBase {
    @Test
    public void upload_test() {
        //1. Go to https://practice.cydeo.com/upload
        //2. Find some small file from your computer, and get the path of it.
        String path = "/Users/olesaluzhetskaya/Desktop/Screen Shot 2022-01-25 at 2.41.59 PM.png";
        //3. Upload the file.
        WebElement fileUpload = Driver.getDriver().findElement(By.id("file-upload"));
        BrowserUtils.sleep(2);
        fileUpload.sendKeys(path);
        WebElement uploadBtn = Driver.getDriver().findElement(By.id("file-submit"));
        uploadBtn.click();
        BrowserUtils.sleep(2);

        WebElement fileUploadedHeader = Driver.getDriver().findElement(By.tagName("h3"));

        Assert.assertTrue(fileUploadedHeader.isDisplayed());


        //4. Assert:
        //-File uploaded text is displayed on the page
        //
    }
}
