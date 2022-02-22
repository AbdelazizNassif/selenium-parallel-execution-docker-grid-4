package tests;

import com.utils.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.RegistrationPage;

import static com.utils.ProjectStatics.*;

public class TestRegistrationToNopCommerce extends TestBase {

    @Test
    public void testRegisterToWebsite() {
        RegistrationPage registrationPage = homePage.clickRegister();
        // fill first name
        registrationPage.
                fillFirstName(fName).
                fillLastName(lName).
                fillEmail(email).
                fillPassword(password).
                confirmPassword(password).
                clickRegisterButton();
        Assert.assertEquals(registrationPage.getRegistrationSuccessMessageText(),
                "Your registration completed");
    }




}
