package tests.homeContentTests;

import com.utils.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class TestExistenceOfFooterTitles extends TestBase {

    @Test
    public void testFooterTitles() {
        List<WebElement> footerHeaders = homePage.getFooterSections();
        Assert.assertEquals(5, footerHeaders.size());
        Assert.assertEquals("Information", footerHeaders.get(0).getText());
        Assert.assertEquals("Customer service", footerHeaders.get(1).getText());
        Assert.assertEquals("My account", footerHeaders.get(2).getText());
        Assert.assertEquals("Follow us", footerHeaders.get(3).getText());
        Assert.assertEquals("Newsletter", footerHeaders.get(4).getText());
    }


}
