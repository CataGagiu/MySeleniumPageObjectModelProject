package com.herokuapp.tests;
import com.herokuapp.pages.LoginPage;
import com.herokuapp.pages.SecureAreaPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import static com.herokuapp.pages.LoginPage.LOGIN_URL;

public class LoginTest extends BaseTest
{
    @Test
    public void loginTest()
    {
        driver.get(LOGIN_URL);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("tomsmith","SUperSecretPassword!");
        SecureAreaPage secureAreaPage = new SecureAreaPage(driver);
        String actualMessage = secureAreaPage.getSuccessMessageText();
        String expectedMessage = "You logged into a secure area!";
        System.out.println(actualMessage);
        Assert.assertTrue(actualMessage.contains(expectedMessage));
        Assert.assertTrue(secureAreaPage.isLogoutButtonDisplayed());
    }
}