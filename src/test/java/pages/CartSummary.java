package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Collection;

public class CartSummary extends HomePage{


    public CartSummary(WebDriver driver) {
        super(driver);
    }

By productName = By.xpath("//td[@class='product']/a") ;
    public String getProductName() {
        return driver.findElement(productName).getText();
    }
By quantity = By.xpath("//td[@class='quantity']/input") ;
    public String getQuantity() {
        return driver.findElement(quantity).getAttribute("value");
    }
}
