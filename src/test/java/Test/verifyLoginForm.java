package Test;

import PageObject.Base.BaseTest;
import PageObject.Pages.HomePage;
import PageObject.Pages.LoginScreen;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class verifyLoginForm extends BaseTest {
    String URL ="https://demo.evershop.io/";
    @DataProvider(name = "validCredentials")
    public static Object[][] credentials1()
    {
        // email,password, should pass
        return new Object[][] { {"testEmail@comshiyata.com", "random123"} };

    }
    @Test(dataProvider = "validCredentials" )
    public void verifyLoginForm(String name, String pass) throws InterruptedException {
        driver.get(URL);
        homePage = new HomePage(driver);
        homePage.loginButton.click();
        loginScreen = new LoginScreen(driver);
        loginScreen.enterCredentials(name, pass);
        driver.findElement(By.cssSelector("a[href='/account']")).click();
        Assert.assertTrue(driver.getTitle().contains("Account details"));
    }
}
