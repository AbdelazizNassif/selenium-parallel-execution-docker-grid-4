package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class CartServices extends HomePage{


    public CartServices(WebDriver driver) {
        super(driver);
    }
    By quantityField = By.id("product_enteredQuantity_4");
    By addToCartBtn = By.id("add-to-cart-button-4");

    public void updateCartQuantity(int quantity)
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(quantityField));
        driver.findElement(quantityField).clear();
        driver.findElement(quantityField).sendKeys(Integer.toString(quantity));
        driver.findElement(addToCartBtn).click();
    }
    By successMsg = By.xpath("//div[@id='bar-notification']/div/p");
    public String checkExistenceOfAddingSuccessMessage() {
        if(driver.findElement(successMsg).isDisplayed())
        {
            return driver.findElement(successMsg).getText();
        }
        else {
            Assert.fail("The confirmation success message is not displayed");
        }
        return "Failed Method - checkExistenceOfAddingSuccessMessage";
    }
By shoppingCartSummary = By.xpath("//*[@id=\"bar-notification\"]/div/p/a");
    public CartSummary clickShoppingCart() {
        driver.findElement(shoppingCartSummary).click();
        return new CartSummary(driver);
    }
}
