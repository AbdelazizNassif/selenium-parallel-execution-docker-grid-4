package tests.cartTests;

import com.utils.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartServices;
import pages.CartSummary;
import pages.SearchPage;

public class TestAddToCart extends TestBase {

    @Test
    public void testAddToCart() {

        String someProductNameLetters  = "mac" ;
        SearchPage searchPage = homePage.enterTextToSearchField(someProductNameLetters);
        Assert.assertTrue(searchPage.getTextOfSearchResult().contains(someProductNameLetters));
        CartServices cartServices = searchPage.addProductToCart();
        cartServices.updateCartQuantity(3);
        Assert.assertEquals(cartServices.checkExistenceOfAddingSuccessMessage(),
                "The product has been added to your shopping cart");
        CartSummary cartSummary = cartServices.clickShoppingCart();
        Assert.assertTrue(cartSummary.getProductName().toLowerCase().contains(someProductNameLetters));
        Assert.assertEquals(cartSummary.getQuantity(), Integer.toString(3));
    }



}
