package com.yourmoca.testcases;

import baseTest.BaseTestClass;
import com.yourmoca.Pages.*;
import org.testng.annotations.Test;

public class UserDetailsTestPage extends BaseTestClass {
    LoginPage loginpage1;
    HomePage homePage1;
    AllCategoriesPage allCategoriesPage;
    UserDetailsPage userDetailsPage;
    SubCategoryPage subCategoryPage;
    LoginPage loginpage2;

    @Test
    public void initiateChat(){
        // Instantiate LoginPage with the specific driver for each user
        loginpage1 = new LoginPage(getDriver1());
        homePage1 = new HomePage(getDriver1());
        allCategoriesPage = new AllCategoriesPage(getDriver1());
        userDetailsPage = new UserDetailsPage(getDriver1());
        subCategoryPage = new SubCategoryPage(getDriver1());

        // login first user
        loginpage1.validateLogin( prop.getProperty("username1"), prop.getProperty("password1"));
        homePage1.clickAllCategories(getDriver1());
        allCategoriesPage.selectSubcategoryFromList("Film Equipment");
        subCategoryPage.selectUserFromList("#Swathifilm");
        userDetailsPage.selectYourMocaChatOption("YourMoca Chat");


    }
}
