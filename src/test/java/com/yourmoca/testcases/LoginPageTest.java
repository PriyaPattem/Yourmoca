package com.yourmoca.testcases;

import baseTest.BaseTestClass;
import baseTest.MultipleDriverTest;
import com.yourmoca.Base.BaseClass;
import com.yourmoca.Pages.LoginPage;
import org.testng.annotations.Test;


public class LoginPageTest extends BaseTestClass {
    LoginPage loginpage1;
    LoginPage loginpage2;

    @Test
    @MultipleDriverTest    // custom annotation for multiple drivers
    public void validateLoginTest(){
        // Instantiate LoginPage with the specific driver for each user
        loginpage1 = new LoginPage(getDriver1());
        loginpage2 = new LoginPage(getDriver2());

        // login first user
        loginpage1.validateLogin( prop.getProperty("username1"), prop.getProperty("password1"));

        // login second user
        loginpage2.validateLogin( prop.getProperty("username2"), prop.getProperty("password2"));
    }
}
