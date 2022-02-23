package com.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import pages.HomePage;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import static com.utils.ProjectStatics.*;

public class TestBase {
    /*
        A variable to set the running environment
        LOCAL_SELENIUM_GRID_4 will run tests in parallel on local machine
        DOCKER will run tests in parallel on docker
    */
    protected static final RunningEnvironment RUNNING_ENV = RunningEnvironment.DOCKER;
    /*
    -------------------------------------------------------------------------
     */
    private ThreadLocal<RemoteWebDriver> driver = null;
    private static DesiredCapabilities caps = null;
    public HomePage homePage;

    private static DesiredCapabilities setDesiredCaps(String browser, Platform platformOS) {
        caps = new DesiredCapabilities();
        caps.setBrowserName(browser);
        caps.setPlatform(platformOS);
        return caps;
    }
    public WebDriver getDriver() {
        return driver.get();
    }

    @BeforeClass
    public void setUp() throws MalformedURLException {
        driver = new ThreadLocal<>();

        if (RUNNING_ENV == RunningEnvironment.DOCKER) {
            caps = setDesiredCaps("chrome", Platform.LINUX);
            driver.set(new RemoteWebDriver(new URL(dockerHubUrl), caps));
        } else if (RUNNING_ENV == RunningEnvironment.LOCAL_SELENIUM_GRID_4) {
            caps = setDesiredCaps("chrome", Platform.WIN10);
            driver.set(new RemoteWebDriver(new URL(localSeleniumGridUrl), caps));
        }
        else if (RUNNING_ENV == RunningEnvironment.LOCAL_BROWSER) {
            WebDriverManager.chromedriver().setup();
            driver.set(new ChromeDriver());
        }
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        getDriver().manage().window().maximize();
        getDriver().get(HOME_URL);
        homePage = new HomePage(getDriver());
    }

    @AfterClass
    public void tearDown() {
        getDriver().quit();
        driver.remove();
    }
}
