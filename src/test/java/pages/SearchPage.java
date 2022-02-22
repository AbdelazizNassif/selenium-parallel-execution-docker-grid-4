package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SearchPage extends HomePage {


    public SearchPage(WebDriver driver) {
        super(driver);
    }


    public String getTextOfSearchResult()
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".details > h2")));
        return driver.findElement(By.cssSelector(".details > h2")).getText();
    }
}
