package PageObject.Pages;

import PageObject.Base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import javax.swing.*;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class HomePage extends BasePage {
    public HomePage(WebDriver driver) {
        super(driver);
    }
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

    public WebElement menSection = driver.findElement(By.cssSelector("li:nth-child(1) > a"));
    public WebElement womanSection = driver.findElement(By.cssSelector("li:nth-child(2) > a"));
    public WebElement kidsSection = driver.findElement(By.cssSelector("li:nth-child(3) > a"));
    public WebElement cartIcon = driver.findElement(By.cssSelector(" div.mini-cart-wrapper.self-center > a"));
    public WebElement searchIcon = driver.findElement(By.cssSelector(" div.search-box "));
    public WebElement maxPriceSlider = driver.findElement(By.cssSelector("input.max"));
    public WebElement minPriceSlider = driver.findElement(By.cssSelector("input.min"));
    public boolean isOrdered = true;
    String selectCriteria = "price";

    public void Click(WebElement element){
        element.click();
    }
    public void searchingField(String search) {
        driver.findElement(By.cssSelector(" div.search-box ")).click();
        driver.findElement(By.cssSelector("input[type=text]")).sendKeys(search, Keys.ENTER);
    }
    public void checkResultOrderByPrice(){
        Select se = new Select(driver.findElement(By.cssSelector("select.form-field")));
        se.selectByValue(selectCriteria);
        wait.until(ExpectedConditions.urlContains(selectCriteria));
        List<WebElement> shoes = driver.findElements(By.cssSelector(".sale-price.font-semibold"));
        List<Float> floatList = new ArrayList<>();
        for (WebElement shoe : shoes) {
            String elementText = shoe.getText().replace("$", "");
            floatList.add(Float.parseFloat(elementText));
        }

        for (int i = 0; i < floatList.size() - 1; i++) {
            if (floatList.get(i) < floatList.get(i + 1)) {
                isOrdered = false;
                break;
            }
        }
    }

}
