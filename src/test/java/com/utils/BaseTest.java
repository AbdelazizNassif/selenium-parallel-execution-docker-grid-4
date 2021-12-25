package com.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;
import java.util.Random;


public class BaseTest {
    protected static WebDriver driver;
    protected static WebDriverWait wait ;
    static Random rand = new Random(); //instance of random class
    static int upperbound = 300000;
    //generate random values from 0-24
    protected static int int_random = rand.nextInt(upperbound);
    protected static String email;
    protected static String password;

    @BeforeMethod
    public void setUp()
    {
        //Create driver object for Chrome
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        email  = "dummy_ln" + int_random + "@email.com";
        password = "umtheking995" ;
    }

    @AfterMethod
    public void tearDown()
    {
driver.quit();    }

}
