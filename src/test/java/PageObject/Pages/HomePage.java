package PageObject.Pages;

import PageObject.Base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v116.indexeddb.model.Key;

public class HomePage extends BasePage {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    public WebElement menSection = driver.findElement(By.cssSelector("li:nth-child(1) > a"));
    public WebElement womanSection = driver.findElement(By.cssSelector("li:nth-child(2) > a"));
    public WebElement kidsSection = driver.findElement(By.cssSelector("li:nth-child(3) > a"));
  //  public WebElement searchBox = driver.findElement(By.cssSelector(" div.search-box "));
    public WebElement cartIcon = driver.findElement(By.cssSelector(" div.mini-cart-wrapper.self-center > a"));

    public void searchingField(String search) {
        driver.findElement(By.cssSelector(" div.search-box ")).click();
        driver.findElement(By.cssSelector("input[type=text]")).sendKeys(search, Keys.ENTER);
    }


}
