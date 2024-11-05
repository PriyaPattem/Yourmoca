package baseTest;

import Constants.DriverType;
import com.yourmoca.Base.BaseClass;
import com.yourmoca.actiondriver.Action;
import driverFactory.DriverManagerFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class BaseTestClass extends BaseClass {

    @BeforeSuite
    public void loadConfig() throws IOException {

        try {
            prop = new Properties();
            // System.out.println("super constructor invoked");
            FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "\\configuration\\Dev_Configuration");
            prop.load(fis);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
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

    @BeforeMethod
    public void setUp(){
        launchApp();
    }

    @AfterMethod
    public void tearDown(){
        quitDrivers();
    }
}
