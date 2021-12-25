package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestLogin extends TestRegistrationToNopCommerce {

    @Test(dependsOnMethods = {"testRegisterToWebsite"})
    public void testLoginToWebsite() throws InterruptedException {
        driver.get("https://demo.nopcommerce.com/");
        driver.findElement(By.className("ico-login")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("Email")));
        driver.findElement(By.id("Email")).sendKeys(email);
        driver.findElement(By.id("Password")).sendKeys(password);
        driver.findElement(By.xpath("//button[contains(@class,'login-button')]")).click();
        Assert.assertTrue(driver.findElement(By.className("ico-logout")).isDisplayed());
    }

}
