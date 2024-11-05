package com.yourmoca.Pages;

import com.yourmoca.Base.BaseClass;
import com.yourmoca.actiondriver.Action;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AllCategoriesPage extends BaseClass {
    private WebDriver driver;

    @FindBy(xpath = "//div[@class=\"MuiGrid-root MuiGrid-item jss374 css-1wxaqej\"]")
    List<WebElement> SubCategories_List;

    public AllCategoriesPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public SubCategoryPage selectSubcategoryFromList(String subcategoryName){
        Action.selectItemFromList(driver, SubCategories_List, subcategoryName);
        return new SubCategoryPage(driver);
    }
}
