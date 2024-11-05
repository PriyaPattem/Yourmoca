package com.yourmoca.Pages;

import com.yourmoca.Base.BaseClass;
import com.yourmoca.actiondriver.Action;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BaseClass {
    private WebDriver driver;
    @FindBy(xpath = "//a[@class=\"jss1\" and @href=\"/allcategories\"]")
    WebElement AllCategories;

    public HomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public AllCategoriesPage clickAllCategories(WebDriver driver){
        Action.performClick(driver, AllCategories);
        return new AllCategoriesPage(driver);
    }
}
