package org.example;

import org.example.driver.WebDriverHolder;
import org.openqa.selenium.support.PageFactory;


public class BasePage {

    public BasePage(){
        PageFactory.initElements(WebDriverHolder.getInstance().getDriver(), this);
    }
}
