package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class RegistrationPage extends HomePage{

    // Locators

    public RegistrationPage(WebDriver driver)
    {
        super(driver);
    }
    // Operations

    public RegistrationPage fillFirstName(String firstName){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("FirstName")));
        driver.findElement(By.id("FirstName")).sendKeys(firstName);
        return  this;
    }
    public RegistrationPage fillLastName(String lastName){
        driver.findElement(By.id("LastName")).sendKeys(lastName);
        return  this;
    }
    public RegistrationPage fillEmail(String email){
        driver.findElement(By.id("Email")).sendKeys(email);
        return  this;
    }
    public RegistrationPage fillPassword(String password){
        driver.findElement(By.id("Password")).sendKeys(password);
        return  this;
    }
    public RegistrationPage confirmPassword(String password){
        driver.findElement(By.id("ConfirmPassword")).sendKeys(password);
        return  this;
    }
    public RegistrationPage clickRegisterButton(){
        driver.findElement(By.id("register-button")).click();
        return  this;
    }
    public String getRegistrationSuccessMessageText()
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("result")));
        return driver.findElement(By.className("result")).getText();
    }
}
