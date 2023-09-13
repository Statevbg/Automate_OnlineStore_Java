package PageObject.Pages;

import PageObject.Base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginScreen extends BasePage {
    public LoginScreen(WebDriver driver) {
        super(driver);
    }
    WebElement emailField = driver.findElement(By.cssSelector("input[name='email']"));
    WebElement passwordField = driver.findElement(By.cssSelector("input[name='password']"));
    WebElement submit = driver.findElement(By.cssSelector(".button.primary"));
    String name = "Doncho Randoma";
    String email = "testEmail@comshiyata.com";
    String password = "random123";

    public void enterCredentials(){
        emailField.sendKeys(email);
        passwordField.sendKeys(password);
        submit.click();
    }
}
