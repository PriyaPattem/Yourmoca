package com.yourmoca.Base;

import org.openqa.selenium.WebDriver;

import java.util.Properties;

public class BaseClass {
    public static Properties prop;
    // public static WebDriver driver;

    //Declare ThreadLocal driver
    private static ThreadLocal<WebDriver> threadLocaldriver = new ThreadLocal<>();

    public void setDriver(WebDriver driver){
        threadLocaldriver.set(driver);
    }
    public static WebDriver getDriver(){
        return threadLocaldriver.get();
    }

}
