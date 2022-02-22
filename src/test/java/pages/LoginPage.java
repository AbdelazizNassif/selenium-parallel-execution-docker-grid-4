package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class LoginPage extends HomePage{


    public LoginPage(WebDriver driver)
    {
        super(driver);
    }
    // locators
    // methods
        public void loginToWebsite(String userEmail, String userPassword)
        {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("Email")));
            driver.findElement(By.id("Email")).sendKeys(userEmail);
            driver.findElement(By.id("Password")).sendKeys(userPassword);
            driver.findElement(By.xpath("//button[contains(@class,'login-button')]")).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ico-logout")));
        }
        public  boolean isLogoutDisplayed()
        {
            return  driver.findElement(By.className("ico-logout")).isDisplayed();
        }
}
