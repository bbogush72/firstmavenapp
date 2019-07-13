package practice.CyberTek.day10;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class cssSelector {
    /**
     * css selector cannot find element by text.
     * .h3 gives you the header in css method
     * do not put spaces in between the characters
     * .btn.btn-primary:nth-of-type[5] css writing
     * //button[@class='btn btn-primary'][5] with xpath writing
     * [class='btn btn-primary']:nth-of-type(5) css writing
     * <p>
     * caret "^" sign means starts with
     * in xpath / means direct child
     * in css we use > sign
     * html > body > div > div:nth-of-type(2) > div > div:nth-of-type(1) > p
     * * star means any element
     * - stands for id
     */

    String button1locator = "[onclick='button1()']";
    String button2locator = ".btn.btn-primary:nth-of-type(2)";
    String button3locator = "[id^='button_']"; //find id starts with button_
    String button4locator = "[id$='_button'][onlick='button4()]";
    String button5locator = "[onclick*='5']";
    String button6locator = "#disappearing_button";
    String resultLocator = "#result";

    WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        WebDriverManager.chromedriver().setup();

    }

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/multiple_buttons");
    }

    @Test(priority = 1, description = "Verifying button 1")
    public void test1() {
        driver.findElement(By.cssSelector(button1locator)).click();
        String expectedMessage = "Clicked on button one";
        String actualMessage = driver.findElement(By.cssSelector(resultLocator)).getText();
        Assert.assertEquals(actualMessage, expectedMessage);
    }

    @AfterMethod
    public void tearDown() {
        driver.close();
    }


}
