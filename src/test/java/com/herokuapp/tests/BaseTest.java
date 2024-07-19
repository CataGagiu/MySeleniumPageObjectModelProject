package com.herokuapp.tests;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class BaseTest
{
    WebDriver driver;
    @Parameters({"browserParam"})
    @BeforeTest(alwaysRun = true)
    public void setUp(@Optional("chrome") String browser)
    {
        //open page
        String url = "https://the-internet.herokuapp.com/checkboxes";
        //driver = new ChromeDriver();

        switch (browser)
        {
            case "chrome": driver = new ChromeDriver(); break;
            case "edge": driver = new EdgeDriver(); break;
            case "firefox": driver = new FirefoxDriver(); break;
            default: driver = new ChromeDriver();
        }

        driver.get(url);
        driver.manage().window().maximize();
    }

    @AfterTest(alwaysRun = true)
    public void tearDown()
    {
        driver.close();
    }

    public void wait(int milliseconds)
    {
        try
        {
            driver.wait(milliseconds);
        } catch (InterruptedException e)
        {
            throw new RuntimeException(e);
        }
    }

}
