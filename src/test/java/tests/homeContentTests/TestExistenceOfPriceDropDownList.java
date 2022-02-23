package tests.homeContentTests;

import com.utils.TestBase;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestExistenceOfPriceDropDownList extends TestBase {

    @Test
    public void testExistenceOfPricingDropDownList() {
        Assert.assertEquals(true, homePage.checkExistenceOfPricingDropDownList());
    }


}
