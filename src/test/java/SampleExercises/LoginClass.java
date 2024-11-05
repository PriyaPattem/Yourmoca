package SampleExercises;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;

public class LoginClass {
    public static void handleAlert(WebDriver driver) {
        Alert alert = driver.switchTo().alert();
        alert.sendKeys("YM_dev_krify");
        alert.accept();
    }
    public static void main(String args[]){
        WebDriver driver = WebDriverManager.chromedriver().create();
        driver.get("https://dev.yourmoca.com/home");
        handleAlert(driver);


    }
}
