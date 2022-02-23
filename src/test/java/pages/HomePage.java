package pages;

import com.utils.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class HomePage {

    protected WebDriver driver ;
    WebDriverWait wait = null;

    public HomePage(WebDriver driver)
    {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    // header menu locators
    String menuHeader_title  = "//ul[@class=\"top-menu notmobile\"]//a[text()='%s ']" ;
    private WebElement findMenuItem (String menuItem){
        String xpath = String.format(menuHeader_title, menuItem);
        return driver.findElement(By.xpath(xpath));
    }
    public HomePage clickMenuItem(String menuItem)
    {
        findMenuItem(menuItem);
        return new HomePage(driver);
    }
    public HomePage clickSubMenuItem(String menuItem, String submenuItem)
    {
        Actions actions = new Actions(driver);
        actions.moveToElement(findMenuItem(menuItem));
        return clickMenuItem(submenuItem);
    }
    // navigation bar
    By register  = By.className("ico-register");
    By login  = By.className("ico-login");

    // navigation bar methods
    public LoginPage clickLogin()
    {
        driver.findElement(login).click();
        return new LoginPage(driver);
    }
    public RegistrationPage clickRegister()
    {
        driver.findElement(register).click();
        return new RegistrationPage(driver);
    }

    // footer locators
    public List<WebElement> getFooterSections()
    {
        List<WebElement> footerHeaders = driver.findElements(By.xpath("//div[@class='footer-upper']//div[@class='title']"));
        return footerHeaders;
    }

    // search page

    public SearchPage enterTextToSearchField(String searchText)
    {
        driver.findElement(By.id("small-searchterms")).sendKeys(searchText);
        driver.findElement(By.cssSelector(".search-box-button")).click();
        return new SearchPage(driver);
    }


    public boolean checkExistenceOfPricingDropDownList()
    {
        return  driver.findElement(By.id("customerCurrency")).isDisplayed();
    }



    public CartSummary clickShoppingCartSummary()
    {
        driver.findElement(By.xpath("//span[@class='cart-label']")).click();
        return  new CartSummary(driver);
    }


    By logoutLink = By.className("ico-logout") ;

    public  boolean isLogoutDisplayed()
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(logoutLink));
        return  driver.findElement(logoutLink).isDisplayed();
    }

}
