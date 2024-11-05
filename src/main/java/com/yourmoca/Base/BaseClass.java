package com.yourmoca.Base;

import Constants.DriverType;
import com.yourmoca.actiondriver.Action;
import driverFactory.DriverManagerFactory;
import org.openqa.selenium.WebDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class BaseClass {
    public static Properties prop;
    // public static WebDriver driver;

    //Declare ThreadLocal driver
    private static final ThreadLocal<WebDriver> user1Driver = new ThreadLocal<>();
    private static final ThreadLocal<WebDriver> user2Driver = new ThreadLocal<>();

    public void setDriver1(WebDriver driver){
        user1Driver.set(driver);
    }
    public static WebDriver getDriver1(){
        return user1Driver.get();
    }

    public void setDriver2(WebDriver driver){
        user2Driver.set(driver);
    }
    public static WebDriver getDriver2(){
        return user2Driver.get();
    }
    public void quitDrivers() {
        if (getDriver1() != null) {
            getDriver1().quit();
            user1Driver.remove();
        }
        if (getDriver2() != null) {
            getDriver2().quit();
            user2Driver.remove();
        }
    }
}
