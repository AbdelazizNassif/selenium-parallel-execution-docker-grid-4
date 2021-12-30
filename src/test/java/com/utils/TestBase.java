package com.utils;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

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
    protected static final RunningEnvironment RUNNING_ENV = RunningEnvironment.LOCAL_SELENIUM_GRID_4;
    /*
    -------------------------------------------------------------------------
     */
    private ThreadLocal<RemoteWebDriver> driver = null;
    protected WebDriverWait wait;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        if (RUNNING_ENV == RunningEnvironment.DOCKER) {
            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setBrowserName("chrome");
            caps.setPlatform(Platform.LINUX);
            driver = new ThreadLocal<>();
            driver.set(new RemoteWebDriver(new URL(dockerHubUrl), caps));
        } else if (RUNNING_ENV == RunningEnvironment.LOCAL_SELENIUM_GRID_4) {
            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setBrowserName("chrome");
            caps.setPlatform(Platform.WIN10);
            driver = new ThreadLocal<>();
            driver.set(new RemoteWebDriver(new URL(localSeleniumGridUrl), caps));
        }
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        wait = new WebDriverWait(getDriver(), Duration.ofSeconds(30));
        getDriver().manage().window().maximize();
    }

    public WebDriver getDriver() {
        return driver.get();
    }

    @AfterClass
    public void tearDown() {
        getDriver().quit();
        driver.remove();
    }
}
