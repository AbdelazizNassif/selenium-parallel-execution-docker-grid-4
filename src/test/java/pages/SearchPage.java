package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Locale;

public class SearchPage extends HomePage {


    public SearchPage(WebDriver driver) {
        super(driver);
    }

By searchResult = By.cssSelector(".details > h2") ;
    public String getTextOfSearchResult()
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchResult));
        System.out.println(driver.findElement(searchResult).getText());
        return driver.findElement(searchResult).getText().toLowerCase();
    }
By addToCartBtn = By.xpath("//button[contains(@class,'product-box-add-to-cart-button')]") ;
    public CartServices addProductToCart()
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(addToCartBtn));
        driver.findElement(addToCartBtn).click();
        return new CartServices(driver);
    }
}
