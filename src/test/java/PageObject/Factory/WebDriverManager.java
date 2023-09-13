package PageObject.Factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WebDriverManager {
    public WebDriver initializeDriver(){
        WebDriver driver;
        String browser = "chrome";
        if (browser.equals("chrome")) {
            ChromeOptions options = new ChromeOptions();
         //   options.addArguments("--headless");
            driver = new ChromeDriver(options);
        } else if (browser.equals("safari")) {
            SafariOptions options = new SafariOptions();
            options.setAcceptInsecureCerts(true);
            driver = new SafariDriver(options);
        } else if (browser.equals("mozilla")) {
            FirefoxOptions options = new FirefoxOptions();
            options.addArguments("--headless");
            driver = new FirefoxDriver(options);
        } else {
            EdgeOptions options = new EdgeOptions();
          //  options.addArguments("--headless");
            driver = new EdgeDriver(options);
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        return driver;
    }
}
