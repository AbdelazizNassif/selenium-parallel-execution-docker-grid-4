package tests.searchTests;

import com.utils.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.SearchPage;

public class TestSearchItem extends TestBase {

    @Test
    public void testSearchItemAsGuest() {
        String productName  = "mac" ;
        SearchPage searchPage = homePage.enterTextToSearchField(productName);
        Assert.assertTrue(searchPage.getTextOfSearchResult().contains(productName));
    }



}
