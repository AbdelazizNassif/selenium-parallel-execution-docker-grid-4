package tests;

import com.utils.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestSearchItem extends BaseTest {

    @Test
    public void testSearchItemAsGuest()
    {
        driver.get("https://demo.nopcommerce.com/");
        driver.findElement(By.id("small-searchterms")).sendKeys("mac");
        driver.findElement(By.cssSelector(".search-box-button")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".details > h2")));
        Assert.assertEquals(true, driver.findElement(By.cssSelector(".details > h2")).getText().contains("Mac"));
    }

}
