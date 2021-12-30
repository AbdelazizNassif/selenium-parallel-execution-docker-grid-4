package tests;

import com.utils.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.utils.ProjectStatics.*;

public class TestRegistrationToNopCommerce extends TestBase {

    @Test
    public void testRegisterToWebsite() {
        getDriver().get(baseURI);
        getDriver().findElement(By.className("ico-register")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("FirstName")));
        getDriver().findElement(By.id("FirstName")).sendKeys("Dummy fn");
        getDriver().findElement(By.id("LastName")).sendKeys("dummy ln");
        getDriver().findElement(By.id("Email")).sendKeys(email);
        getDriver().findElement(By.id("Password")).sendKeys(password);
        getDriver().findElement(By.id("ConfirmPassword")).sendKeys(password);
        getDriver().findElement(By.id("register-button")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("result")));
        Assert.assertEquals(getDriver().findElement(By.className("result")).getText(),
                "Your registration completed");
    }

}
