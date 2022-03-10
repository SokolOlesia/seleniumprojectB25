package com.cydeo.tests.try_project;

import com.cydeo.tests.base.TestBase;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import com.cydeo.utilities.VyTrack_Login;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

public class US_60 extends TestBase {
    Faker faker = new Faker();
    Actions actions = new Actions(Driver.getDriver());
    JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver(); //down casting to JS

    @DataProvider(name = "US-60_Credentials")
    public Object[][] credentials() {
        return new Object[][]{
                /*{"user"+ faker.number().numberBetween(191,197), "UserUser123"},//user191 --- user197
                {"storemanager" + faker.number().numberBetween(67, 72), "UserUser123"},*/ //storemanager67  ---  storemanager72
                {"salesmanager" + faker.number().numberBetween(275,278), "UserUser123"}}; //salesmanager275 --- salesmanager278

    }

    @Test(dataProvider = "US-60_Credentials")
    public void edit_car_info_test(String usernames, String passwords) {

        VyTrack_Login.login(Driver.getDriver(), usernames, passwords); //it's for login to homepage
        BrowserUtils.sleep(2);
        //1. Find a Fleet tab and hover on it

        List<WebElement> tabs = Driver.getDriver().findElements(By.xpath("//span[@class='title title-level-1'][1]"));

        for (WebElement tab : tabs) {
            if (tab.getText().contains("Fleet")) {
                actions.moveToElement(tab).perform();
                BrowserUtils.sleep(2);

            }
        }
        WebElement vehicles = Driver.getDriver().findElement(By.xpath("//span[.='Vehicles']"));
        vehicles.click();
        BrowserUtils.sleep(2);

        List<WebElement> dots = Driver.getDriver().findElements(By.xpath("//a[.='...']"));

        WebElement deleteBtn = null;
        WebElement editBtn = null;
        WebElement viewBtn = null;

        for (WebElement dot : dots) {

            dot.click();

            deleteBtn = Driver.getDriver().findElement(By.xpath("//div[@class='dropdown']//li[3]//a"));
            editBtn = Driver.getDriver().findElement(By.xpath("//div[@class='dropdown']//li[2]//a"));
            viewBtn = Driver.getDriver().findElement(By.xpath("//div[@class='dropdown']//li[1]//a"));

            String delete = deleteBtn.getAttribute("title");
            String edit = editBtn.getAttribute("title");
            String view = viewBtn.getAttribute("title");

            String expectedDelete = "Delete";
            String expectedEdit = "Edit";
            String expectedView = "View";

            Assert.assertEquals(delete,expectedDelete);
            Assert.assertEquals(edit,expectedEdit);
            Assert.assertEquals(view,expectedView);

//            System.out.println(view);
//            System.out.println(edit);
//            System.out.println(delete);
            //js.executeScript("window.scrollBy(0,50)");
            WebElement scrollArea =
                    driver.findElement(By.xpath("//div[@id='grid-custom-entity-grid-1294109144']"));
            ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].scrollIntoView(true);", scrollArea);
        }



    }
}
