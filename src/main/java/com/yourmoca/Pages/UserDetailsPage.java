package com.yourmoca.Pages;

import com.yourmoca.Base.BaseClass;
import com.yourmoca.actiondriver.Action;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class UserDetailsPage extends BaseClass {
    @FindBy(id="contact-button")
    WebElement contact_button;

    @FindBy(xpath = "//li[@class=\"MuiButtonBase-root MuiMenuItem-root MuiMenuItem-gutters MuiMenuItem-root MuiMenuItem-gutters css-7quhgo\"]")
    List<WebElement> contact_methods;

    public UserDetailsPage(WebDriver driver) {
        BaseClass.driver=driver;
        PageFactory.initElements(driver, this);
    }

    public ChatRoom selectYourMocaChatOption(String contactType){
        Action.performClick(driver, contact_button);
        Action.clickItemFromList(driver, contact_methods, contactType );
        return new ChatRoom(driver);
    }

}
