package tests;

import com.utils.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

import static com.utils.ProjectStatics.*;

public class TestLogin extends TestBase {

    @Test
    public void testLoginToWebsite() {
        LoginPage loginPage = homePage.clickLogin();
        loginPage.loginToWebsite(email, password);
        Assert.assertTrue(loginPage.isLogoutDisplayed());
    }


}
