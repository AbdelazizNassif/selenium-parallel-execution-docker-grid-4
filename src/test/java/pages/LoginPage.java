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
    By emailField = By.id("Email") ;
    By password =  By.id("Password");
    By loginBtn = By.xpath("//button[contains(@class,'login-button')]") ;
    // methods
        public void loginToWebsite(String userEmail, String userPassword)
        {
            wait.until(ExpectedConditions.visibilityOfElementLocated(emailField));
            driver.findElement(emailField).sendKeys(userEmail);
            driver.findElement(password).sendKeys(userPassword);
            driver.findElement(loginBtn).click();
        }

}
