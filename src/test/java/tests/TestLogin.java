package tests;

import com.utils.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import static com.utils.ProjectStatics.*;

public class TestLogin extends TestBase {

    @Test
    public void testLoginToWebsite() {
        getDriver().get(baseURI);
        getDriver().findElement(By.className("ico-login")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("Email")));
        getDriver().findElement(By.id("Email")).sendKeys(email);
        getDriver().findElement(By.id("Password")).sendKeys(password);
        getDriver().findElement(By.xpath("//button[contains(@class,'login-button')]")).click();
        Assert.assertTrue(getDriver().findElement(By.className("ico-logout")).isDisplayed());
    }


}
