package driverFactory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class FirefoxDriverManager implements DriverManager{

    @Override
    public WebDriver createDriver() {
        WebDriverManager.firefoxdriver().setup();
        /*ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");*/
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        return driver;
    }
}
