package com.yourmoca.Pages;

import com.yourmoca.Base.BaseClass;
import com.yourmoca.actiondriver.Action;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SubCategoryPage extends BaseClass {

    @FindBy(xpath = "//p[@class=\"MuiTypography-root MuiTypography-body1 css-1ypbioz\"]")
    List<WebElement> users_List;


    public SubCategoryPage(WebDriver driver) {
        BaseClass.driver = driver;
    }

    public UserDetailsPage selectUserFromList(String userName){
        Action.clickItemFromList(driver, users_List, userName);
        return new UserDetailsPage(driver);

    }

}
