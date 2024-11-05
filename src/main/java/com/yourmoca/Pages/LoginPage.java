package com.yourmoca.Pages;

import com.yourmoca.Base.BaseClass;
import com.yourmoca.actiondriver.Action;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BaseClass {
    private WebDriver driver;
    @FindBy(xpath="//div[@class=\"MuiGrid-root MuiGrid-container MuiGrid-item MuiGrid-grid-xs-auto css-17jney1\"]")
    WebElement Login_signUp_Button;

    @FindBy(xpath="//input[@name=\"email\"]")
    WebElement email_ph_field;

    @FindBy(name="password")
    WebElement password;

    @FindBy(xpath="//div[@class=\"MuiGrid-root MuiGrid-container MuiGrid-item css-n431dd\"]")
    WebElement loginbutton;

    public LoginPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public String getCurrentURL(){
        String currentURL = Action.getCurrentURL(getDriver1());
        return currentURL;
    }

    public HomePage validateLogin(String username, String pwd){
        Action.performClick(driver, Login_signUp_Button);
        Action.EnterText(email_ph_field, username);
        Action.EnterText(password, pwd);
        Action.performClick(driver, loginbutton);
        return new HomePage(driver);
    }


}
