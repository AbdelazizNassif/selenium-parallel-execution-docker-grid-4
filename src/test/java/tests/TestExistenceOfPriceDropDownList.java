package tests;

import com.utils.TestBase;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.utils.ProjectStatics.baseURI;

public class TestExistenceOfPriceDropDownList extends TestBase {

    @Test
    public void testSearchItemAsGuest() {
        getDriver().get(baseURI);
        Assert.assertEquals(true, getDriver().findElement(By.id("customerCurrency")).isDisplayed());
    }

}
