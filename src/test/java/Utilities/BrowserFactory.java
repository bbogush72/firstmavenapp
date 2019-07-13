package Utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserFactory {
    /**
     * @param Browser name
     * @return browser object, otherwise throw exception  to prevent test run
     */

    public static WebDriver getDriver(String Browser) {
        if (Browser.equals("chrome")) {
            WebDriverManager.chromedriver().setup();
            return new ChromeDriver();
        } else if (Browser.equals("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            return new FirefoxDriver();
        } else {
            //unchecked exception; or runtime exception
            throw new IllegalArgumentException("Wrong browser name!");

        }
    }


}
