package driverFactory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class EdgeDriverManager implements DriverManager{
    @Override
    public WebDriver createDriver() {
        WebDriverManager.edgedriver().setup();
        /*ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");*/
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        return driver;
    }
}
