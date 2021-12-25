package tests;

import com.utils.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Random;

public class TestRegistrationToNopCommerce extends BaseTest {

    @Test
    public void testRegisterToWebsite()
    {
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
