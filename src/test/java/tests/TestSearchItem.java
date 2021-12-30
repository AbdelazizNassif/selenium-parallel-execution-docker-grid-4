package tests;

import com.utils.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.utils.ProjectStatics.baseURI;

public class TestSearchItem extends TestBase {

    @Test
    public void testSearchItemAsGuest() {
        getDriver().get(baseURI);
        getDriver().findElement(By.id("small-searchterms")).sendKeys("mac");
        getDriver().findElement(By.cssSelector(".search-box-button")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".details > h2")));
        Assert.assertEquals(true, getDriver().findElement(By.cssSelector(".details > h2")).getText().contains("Mac"));
    }

}
