package com.yourmoca.Pages;

import com.yourmoca.Base.BaseClass;
import com.yourmoca.actiondriver.Action;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BaseClass {
    @FindBy(xpath = "//div//a[@href=\"/allcategories\" and not(@class=\"footer_text_style\")]")
    WebElement AllCategories;

    public HomePage(WebDriver driver){
        BaseClass.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public AllCategoriesPage clickAllCategories(WebDriver driver){
        Action.explicitWait(driver, AllCategories, 20);
        Action.performClick(driver, AllCategories);
        return new AllCategoriesPage(driver);
    }
}
