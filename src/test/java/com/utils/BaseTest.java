package com.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;


public class BaseTest {
    protected static WebDriver driver;
    protected static WebDriverWait wait ;
    @BeforeMethod
    public void setUp()
    {
        //Create driver object for Chrome
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    @AfterMethod
    public void tearDown()
    {
driver.quit();    }

}
