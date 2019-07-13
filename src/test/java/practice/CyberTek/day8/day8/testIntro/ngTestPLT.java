package practice.CyberTek.day8.day8.testIntro;

import Utilities.SeleniumUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;

public class ngTestPLT {
    WebDriver driver = new ChromeDriver();


    @BeforeMethod
    public void openAmazon() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://amazon.com");
    }


    @Test(priority = 2)
    public void amazonTest() {
        String currentWindow = driver.getWindowHandle();
        driver.findElement(By.id("dropdownMenuLink")).click();
        driver.findElement(By.linkText("Amazon")).click();
        SeleniumUtils.wait(2);

        String expectedURL = "https://www.amazon.com/";
        Set<String> windows = driver.getWindowHandles();

        for (String w : windows) {
            if (!currentWindow.equals(w)) {
                driver.switchTo().window(w);
            }
        }
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL);
    }

    @Test(priority = 3)
    public void openAmazonTest() {
        String currentWindow = driver.getWindowHandle();
        driver.findElement(By.id("dropdownMenuLink")).click();
        driver.findElement(By.linkText("Amazon")).click();
        SeleniumUtils.wait(2);
        String expectedURL = "https://www.amazon.com/";
        Set<String> windows = driver.getWindowHandles();
        for (String w : windows) {
            if (!currentWindow.equals(w)) {
                driver.switchTo().window(w);
            }
        }
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL);
    }

    @AfterMethod
    public void exit() {
        driver.quit();
    }
}
