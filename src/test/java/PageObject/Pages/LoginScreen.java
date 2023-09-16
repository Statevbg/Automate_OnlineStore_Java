package PageObject.Pages;

import PageObject.Base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginScreen extends BasePage {
    public LoginScreen(WebDriver driver) {
        super(driver);
    }
    public WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    WebElement emailField = driver.findElement(By.cssSelector("input[name='email']"));
    WebElement passwordField = driver.findElement(By.cssSelector("input[name='password']"));
    WebElement submit = driver.findElement(By.cssSelector(".button.primary"));
  //  public WebElement errorMsg = driver.findElement(By.cssSelector("text-critical.mb-1"));
  //  String name = "Doncho Randoma";
   // String email = "testEmail@comshiyata.com";
   // String password = "random123";

    public void enterCredentials(String email, String pass){
        emailField.sendKeys(email);
        passwordField.sendKeys(pass);
        submit.click();
    }
}
