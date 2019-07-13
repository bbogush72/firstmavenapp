package practice.CyberTek.day5;

import Utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class EbayTest {

    public static void main(String[] args) throws Exception {
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.manage().window().maximize();
        //selenium will wait up to 30 seconds to find elements then if not throw exception
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("https://www.ebay.com/");

        driver.findElement(By.id("gh-ac")).sendKeys("laptop");
        driver.findElement(By.id("gh-btn")).submit();
        String actual = driver.findElement(By.className("srp-controls__count-heading")).getText();
        System.out.println(actual);

        Thread.sleep(3000);

        driver.close();
    }

}

