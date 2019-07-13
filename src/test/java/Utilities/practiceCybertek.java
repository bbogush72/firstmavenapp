package Utilities;

import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class practiceCybertek {

    static WebDriver driver = BrowserFactory.getDriver("chrome");

    public static void main(String[] args) {
        open();
    }

    public static void open() {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/radio_buttons");
    }


}
