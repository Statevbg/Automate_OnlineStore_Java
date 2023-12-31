package Test;

import PageObject.Base.BaseTest;
import PageObject.Pages.HomePage;
import PageObject.Pages.HomeProducts;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class verifySearchResults extends BaseTest {

    String URL ="https://demo.evershop.io/";
    @DataProvider(name = "List")
    public static Object[][] credentials1()
    {

        return new Object[][] { {"Nike"},{"Shoes"}};

    }
    @Test(dataProvider = "List" )
    public void verifyOrderResultsByPrice(String searchCriteria){
        driver.get(URL);
        homePage = new HomePage(driver);
        homePage.searchingField(searchCriteria);
        homePage.checkResultOrderByPrice();
        Assert.assertTrue(driver.findElement(By.cssSelector(".search-name")).getText().contains(searchCriteria));
        Assert.assertTrue(homePage.isOrdered);
    }
    @Test
    public void verifySliderRangePrice(){
        driver.get(URL);
        homePage = new HomePage(driver);
        homePage.Click(homePage.menSection);
        homeProducts = new HomeProducts(driver);
        homeProducts.moveMaxPriceSlier();
        homeProducts.getMinMaxRangeCheckItemInRange();
        Assert.assertTrue(homeProducts.isInRange);
    }
}
