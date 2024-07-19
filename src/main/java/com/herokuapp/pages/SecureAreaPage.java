package com.herokuapp.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SecureAreaPage extends BasePage{

    protected static String SECUREAREAURL = BASE_URL+"secure";
    @FindBy(id="flash") private WebElement successAlert;
    @FindBy(linkText = "Logout") private WebElement logoutButton;

    public SecureAreaPage(WebDriver driver) {
        super(driver);
    }

    public String getSuccessMessageText(){
        return successAlert.getText();
    }

    public boolean isLogoutButtonDisplayed(){
        return logoutButton.isDisplayed();
    }



}