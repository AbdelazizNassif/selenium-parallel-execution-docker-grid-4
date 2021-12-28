package tests;

import com.utils.CommonData;
import com.utils.RunningEnvironment;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
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

public class TestSearchItem extends CommonData {
    private WebDriver driver;
    private WebDriverWait wait;
    private String gridUrl = "http://localhost:4445/wd/hub";

    @Test
    public void testSearchItemAsGuest() {
        driver.get("https://demo.nopcommerce.com/");
        driver.findElement(By.id("small-searchterms")).sendKeys("mac");
        driver.findElement(By.cssSelector(".search-box-button")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".details > h2")));
        Assert.assertEquals(true, driver.findElement(By.cssSelector(".details > h2")).getText().contains("Mac"));
    }

    @BeforeTest
    public void setUp() throws MalformedURLException {
        if(RUNNING_ENV == RunningEnvironment.DOCKER)
        {
            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setBrowserName("chrome");
            caps.setPlatform(Platform.LINUX);
            //Create driver object for Chrome
            WebDriverManager.chromedriver().setup();
            driver = new RemoteWebDriver(new URL(dockerHubUrl), caps);
        }
        else if (RUNNING_ENV == RunningEnvironment.LOCAL_SELENIUM_GRID_4)
        {
            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setBrowserName("chrome");
            caps.setPlatform(Platform.WIN10);
            //Create driver object for Chrome
            WebDriverManager.chromedriver().setup();
            driver = new RemoteWebDriver(new URL(localSeleniumGridUrl), caps);
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        driver.manage().window().maximize();
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
