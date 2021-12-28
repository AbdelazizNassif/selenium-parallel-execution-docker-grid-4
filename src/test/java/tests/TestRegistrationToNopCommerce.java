package tests;

import com.utils.CommonData;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class TestRegistrationToNopCommerce extends CommonData {
    private WebDriver driver;
    private WebDriverWait wait;
    private String gridUrl = "http://localhost:4445/wd/hub" ;

    @Test
    public void testRegisterToWebsite()
    {
        driver.get("https://demo.nopcommerce.com/");
        driver.findElement(By.className("ico-register")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("FirstName")));
        driver.findElement(By.id("FirstName")).sendKeys("Dummy fn");
        driver.findElement(By.id("LastName")).sendKeys("dummy ln");
        driver.findElement(By.id("Email")).sendKeys(email);
        driver.findElement(By.id("Password")).sendKeys(password);
        driver.findElement(By.id("ConfirmPassword")).sendKeys(password);
        driver.findElement(By.id("register-button")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("result")));
        Assert.assertEquals(driver.findElement(By.className("result")).getText(),
                "Your registration completed");
    }
    @BeforeTest
    public void setUp() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setBrowserName("chrome");
        caps.setPlatform(Platform.LINUX);
        //Create driver object for Chrome
        WebDriverManager.chromedriver().setup();
        driver = new RemoteWebDriver(new URL(gridUrl), caps);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        driver.manage().window().maximize();
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
