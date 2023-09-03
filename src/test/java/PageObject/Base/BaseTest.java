package PageObject.Base;

import PageObject.Factory.WebDriverManager;
import PageObject.Pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    protected HomePage homePage;
    protected WebDriver driver;
    @BeforeMethod
    public void startDriver(){
        driver = new WebDriverManager().initializeDriver();
    }
    @AfterMethod
    public void quitDriver(){
          driver.quit();
    }
}
