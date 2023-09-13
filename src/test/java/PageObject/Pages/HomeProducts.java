package PageObject.Pages;

import PageObject.Base.BasePage;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class HomeProducts extends BasePage {

    public HomeProducts(WebDriver driver) {
        super(driver);
    }
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

    public WebElement maxPriceSlider = driver.findElement(By.cssSelector("input.max"));
    public WebElement minPriceSlider = driver.findElement(By.cssSelector("input.min"));
    public WebElement minPriceDisplay = driver.findElement(By.cssSelector("div.tooltip.min > output"));
    public WebElement maxPriceDisplay = driver.findElement(By.cssSelector("div.tooltip.max> output"));

    public boolean isInRange = true;

    public void moveMaxPriceSlier(){
        Actions action = new Actions(driver);
        action.clickAndHold(maxPriceSlider)
                .moveToLocation(400,450)
                .release()
                .build()
                .perform();
        wait.until(ExpectedConditions.urlContains("maxPrice"));

    }

    public void getMinMaxRangeCheckItemInRange(){
        float minPrice = Float.parseFloat(minPriceDisplay.getText().replace("$", ""));
        float maxPrice = Float.parseFloat(maxPriceDisplay.getText().replace("$", ""));
        List<WebElement> shoes = driver.findElements(By.cssSelector(".sale-price.font-semibold"));
        List<Float> floatList = new ArrayList<>();
        for (WebElement shoe : shoes) {
            String elementText = shoe.getText().replace("$", "");
            floatList.add(Float.parseFloat(elementText));
        }

        for (int i = 0; i < floatList.size() - 1; i++) {
            if ( minPrice > floatList.get(i) || floatList.get(i) > maxPrice) {
                isInRange = false;
                break;
            }
        }
    }
}
