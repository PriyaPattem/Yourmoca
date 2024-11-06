package com.yourmoca.Pages;

import com.yourmoca.Base.BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ChatRoom extends BaseClass {
    public ChatRoom(WebDriver driver) {
        BaseClass.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
