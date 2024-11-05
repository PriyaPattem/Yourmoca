package com.yourmoca.testcases;

import baseTest.BaseTestClass;
import com.yourmoca.Base.BaseClass;
import com.yourmoca.Pages.LoginPage;
import org.testng.annotations.Test;

public class LoginPageTest extends BaseTestClass {
    LoginPage loginpage;

    @Test
    public void validateLoginTest(){
        loginpage = new LoginPage();
        loginpage.validateLogin(getDriver1(), prop.getProperty("username1"), prop.getProperty("password1"));
        loginpage.validateLogin(getDriver2(), prop.getProperty("username2"), prop.getProperty("password2"));
    }
}
