package tests;

import com.utils.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Random;

public class TestRegistrationToNopCommerce extends BaseTest {
    Random rand = new Random(); //instance of random class
    int upperbound = 300000;
    //generate random values from 0-24
    int int_random = rand.nextInt(upperbound);
    protected static String email;
protected static String password;
    @Test
    public void testRegisterToWebsite()
    {
        email  = "dummy_ln" + int_random + "@email.com";
        password = "umtheking995" ;
        driver.get("https://demo.nopcommerce.com/");
        driver.findElement(By.className("ico-register")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("FirstName")));
        driver.findElement(By.id("FirstName")).sendKeys("Dummy fn");
        driver.findElement(By.id("LastName")).sendKeys("dummy ln");
        driver.findElement(By.id("Email")).sendKeys(email);
        driver.findElement(By.id("Password")).sendKeys(password);
        driver.findElement(By.id("ConfirmPassword")).sendKeys(password);
        driver.findElement(By.id("register-button")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("result")));
        Assert.assertEquals(driver.findElement(By.className("result")).getText(),
                "Your registration completed");
    }

}
