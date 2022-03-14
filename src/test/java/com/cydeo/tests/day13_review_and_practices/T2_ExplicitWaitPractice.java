package com.cydeo.tests.day13_review_and_practices;

import com.cydeo.tests.base.DynamicControlPage;
import com.cydeo.tests.base.TestBase;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class T2_ExplicitWaitPractice extends TestBase {
    DynamicControlPage dynamicControlPage;
    @BeforeMethod
    public void setupMethod(){
        Driver.getDriver().get("https://practice.cydeo.com/dynamic_controls");
        dynamicControlPage = new DynamicControlPage();
    }

    @Test
    public void remove_button_test(){
        //3- Click to “Remove” button
        dynamicControlPage.removeButton.click();
        //4- Wait until “loading bar disappears”
//        Driver.getDriver().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
//        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
//        wait.until(ExpectedConditions.invisibilityOf(dynamicControlPage.loadingBar));
        BrowserUtils.waitForInvisibilityOf(dynamicControlPage.loadingBar);

        //5- Verify:
        try {
            Assert.assertTrue(!dynamicControlPage.checkbox.isDisplayed());
            // a. Checkbox is not displayed
            Assert.assertFalse(dynamicControlPage.checkbox.isDisplayed());
        }catch (NoSuchElementException n){
            Assert.assertTrue(true);
        }
        //b. “It’s gone!” message is displayed.
        Assert.assertTrue(dynamicControlPage.message.isDisplayed());
        Assert.assertTrue(dynamicControlPage.message.getText().equals("It's gone!"));
    }

    @Test
    public void enable_button_test(){
        //1- Open a chrome browser
        //2- Go to: https://practice.cydeo.com/dynamic_controls
        //3- Click to “Enable” button
        //dynamicControlPage.inputBox.isEnabled();// false
        dynamicControlPage.enableBtn.click();
        //4- Wait until “loading bar disappears”
        //Calling our utility method to wait loading bar to disappear
        BrowserUtils.waitForInvisibilityOf(dynamicControlPage.loadingBar);
        //dynamicControlPage.inputBox.isEnabled();// true
        //5- Verify:
        //a. Input box is enabled.
        Assert.assertTrue(dynamicControlPage.inputBox.isEnabled());
        //b. “It’s enabled!” message is displayed.
        Assert.assertTrue(dynamicControlPage.message.isDisplayed());
        Assert.assertTrue(dynamicControlPage.message.getText().equals("It's enabled!"));

    }
}
