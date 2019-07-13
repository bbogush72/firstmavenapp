package practice.CyberTek.day6;

import Utilities.BrowserFactory;
import Utilities.SeleniumUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class radioButtons {

    static WebDriver driver = BrowserFactory.getDriver("chrome");

    public static void main(String[] args) {
        open();
        test1();
        driver.close();
    }

    public static void open() {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/radio_buttons");
    }

    public static void test1() {
        WebElement blueButton = driver.findElement(By.id("blue"));

        if (blueButton.isSelected()) {
            System.out.println("passed");
        } else {
            System.out.println("failed");
        }

        SeleniumUtils.wait(2);

    }
}
