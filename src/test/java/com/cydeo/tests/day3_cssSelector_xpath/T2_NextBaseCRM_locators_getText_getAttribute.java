package com.cydeo.tests.day3_cssSelector_xpath;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class T2_NextBaseCRM_locators_getText_getAttribute {
    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.gerDriver("chrome");
        driver.manage().window().maximize();
        driver.get("https://login2.nextbasecrm.com/");

        WebElement rememberMeLabel = driver.findElement(By.className("login-item-checkbox-label"));
        String expectedRememberMeLabel = "Remember me on this computer";
        String actualRememberMeLabel = rememberMeLabel.getText();

        if(actualRememberMeLabel.equals(expectedRememberMeLabel)){
            System.out.println("Label verification PASSED");
        } else {
            System.out.println("Label verification FAILED!!!");
        }


        WebElement forgotPassword = driver.findElement(By.className("login-link-forgot-pass"));
        String expectedForgot = "Forgot your password?";
        String actualForgot = forgotPassword.getText();

        if(actualForgot.equalsIgnoreCase(expectedForgot)){
            System.out.println("Forgot password link verification PASSED!");
        }else {
            System.out.println("actualForgotPasswordLinkText = " + actualForgot);
            System.out.println("expectedForgotPasswordLinkText = " + expectedForgot);

            System.out.println("Forgot password link verification FAILED!!!");
        }

        String expectedInHref = "forgot_password=yes";
        String actualHrefAttributeValue = forgotPassword.getAttribute("href");

        System.out.println("actualHrefAttributeValue = " + actualHrefAttributeValue);

        if (actualHrefAttributeValue.contains(expectedInHref)){
            System.out.println("HREF attribute value verification PASSED!");
        }else{
            System.out.println("HREF attribute value verification FAILED!!!");
        }

        driver.close();

    }
}

//TC #2: NextBaseCRM, locators, getText(), getAttribute() practice
//        1- Open a chrome browser
//        2- Go to: https://login1.nextbasecrm.com/
//        3- Verify “remember me” label text is as expected:
//        Expected: Remember me on this computer
//        4- Verify “forgot password” link text is as expected:
//        Expected: Forgot your password?
//        5- Verify “forgot password” href attribute’s value contains expected:
//        Expected: forgot_password=yes
//
//
//
//        PS: Inspect and decide which locator you should be using to locate web
//        elements.