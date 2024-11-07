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
    protected static WebDriver driver;

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
    public void launchApp() {
        // set up driver for user1
        setDriver1(DriverManagerFactory.getDriverType(DriverType.CHROME).createDriver());
        Action.launchUrl(getDriver1(),prop.getProperty("baseUrl"));
        Action.alertSendKeys(getDriver1(),"YM_dev_krify");
        Action.implicitWait(getDriver1(),20);
        Action.pageLoadTimeOut(getDriver1(),20);
        System.out.println("successfully launched first driver");

        //set up driver for user2
        setDriver2(DriverManagerFactory.getDriverType(DriverType.CHROME).createDriver());
        Action.launchUrl(getDriver2(),prop.getProperty("baseUrl"));
        Action.alertSendKeys(getDriver2(),"YM_dev_krify");
        Action.implicitWait(getDriver2(),20);
        Action.pageLoadTimeOut(getDriver2(),20);
        System.out.println("successfully launched second driver");
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
