package Test;

import PageObject.Base.BaseTest;
import PageObject.Pages.HomePage;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class verifySearchResults extends BaseTest {

    String URL ="https://demo.evershop.io/";
    @DataProvider(name = "Authentication1")
    public static Object[][] credentials1()
    {

        return new Object[][] { { "men"},{ "woman"},{ "kids"} };

    }

    @Test(dataProvider = "Authentication1" )
    public void CheckValidSearch(String a){
        driver.get(URL);
        homePage = new HomePage(driver);
        homePage.searchingField(a);
        Assert.assertTrue(driver.findElement(By.cssSelector(".search-name")).getText().contains(a));
    }
}
