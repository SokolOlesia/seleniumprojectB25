package com.cydeo.tests.day11_actions_jsexecutor_practice;

import com.cydeo.utilities.Driver;
import org.testng.annotations.Test;

public class ScrollJSExecutor {
    @Test
    public void task7_scroll_test(){
        //1- Open a Chrome browser
        //2- Go to: https://practice.cydeo.com/large
        Driver.getDriver().get("https://practice.cydeo.com/large");

        //3- Scroll down to “Cydeo” link
        //4- Scroll up to “Home” link
        //5- Use below provided JS method only
        //JavaScript method to use : arguments[0].scrollIntoView(true)


    }

}
