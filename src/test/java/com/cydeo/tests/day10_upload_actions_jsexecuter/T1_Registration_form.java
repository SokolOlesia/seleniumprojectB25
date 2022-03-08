package com.cydeo.tests.day10_upload_actions_jsexecuter;

import com.cydeo.tests.base.TestBase;
import com.cydeo.utilities.Driver;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

public class T1_Registration_form extends TestBase {
    @Test
    public void registration_test() throws InterruptedException {
//        Note: Use JavaFaker OR read from configuration.properties file when possible.
//        1. Open browser
//        2. Go to website: https://practice.cydeo.com/registration_form

        Faker faker = new Faker();
//        3. Enter first name

        WebElement firstName = Driver.getDriver().findElement(By.xpath("//input[@name='firstname']"));
        firstName.sendKeys(faker.name().firstName());

//        4. Enter last name
        WebElement lastName = Driver.getDriver().findElement(By.xpath("//input[@name='lastname']"));
        lastName.sendKeys(faker.name().lastName());

//        5. Enter username
        WebElement userName = Driver.getDriver().findElement(By.xpath("//input[@name='username']"));
        userName.sendKeys(faker.bothify("?????????#?"));

//        6. Enter email address
        WebElement email = Driver.getDriver().findElement(By.xpath("//input[@name='email']"));
        email.sendKeys(faker.internet().emailAddress());
       // email.sendKeys(userName + "@email.com");

//        7. Enter password
        WebElement password = Driver.getDriver().findElement(By.xpath("//input[@name='password']"));
        //password.sendKeys(faker.internet().password());
        password.sendKeys(faker.numerify("#########"));

//        8. Enter phone number
        WebElement phoneNumber = Driver.getDriver().findElement(By.xpath("//input[@name='phone']"));
        phoneNumber.sendKeys(faker.numerify("571-###-####"));

//        9. Select a gender from radio buttons
        WebElement genderButton = Driver.getDriver().findElement(By.xpath("//input[@value='male']"));
        genderButton.click();

//        10. Enter date of birth
        WebElement dateOfBirth = Driver.getDriver().findElement(By.xpath("//input[@name='birthday']"));
        dateOfBirth.sendKeys(faker.date().birthday().toInstant().atOffset(ZoneOffset.UTC).format(DateTimeFormatter.ofPattern("MM/dd/yyyy")));

//        11. Select Department/Office
        Select department = new Select(Driver.getDriver().findElement(By.xpath("//select[@name='department']")));
        department.selectByVisibleText("Department of Engineering");

//        12. Select Job Title
        Select jobTitle = new Select(Driver.getDriver().findElement(By.xpath("//select[@name='job_title']")));
        jobTitle.selectByIndex(5);

//        13. Select programming language from checkboxes
        WebElement language = Driver.getDriver().findElement(By.xpath("//input[@id='inlineCheckbox2']"));
        language.click();

        //Thread.sleep(5000);
//        14. Click to sign up button
        WebElement singUpBt = Driver.getDriver().findElement(By.xpath("//button[@id='wooden_spoon']"));
        singUpBt.click();

//        15. Verify success message “You’ve successfully completed registration.” is
//        displayed.
        WebElement message = Driver.getDriver().findElement(By.xpath("//p"));

        String actualMessage = message.getText();
        String expectedMessage = "You've successfully completed registration!";
        Assert.assertEquals(actualMessage, expectedMessage);
//
//
//                Note:
//        1. Use new Driver utility class and method
//        2. User JavaFaker when possible
//        3. User ConfigurationReader when it makes sense
    }
}

/*
Note: Use JavaFaker OR read from configuration.properties file when possible.
1. Open browser
2. Go to website: https://practice.cydeo.com/registration_form
3. Enter first name
4. Enter last name
5. Enter username
6. Enter email address
7. Enter password
8. Enter phone number
9. Select a gender from radio buttons
10. Enter date of birth
11. Select Department/Office
12. Select Job Title
13. Select programming language from checkboxes
14. Click to sign up button
15. Verify success message “You’ve successfully completed registration.” is
displayed.


Note:
1. Use new Driver utility class and method
2. User JavaFaker when possible
3. User ConfigurationReader when it makes sense
 */

