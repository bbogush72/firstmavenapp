package practice.CyberTek.day5;

import Utilities.BrowserFactory;
import Utilities.SeleniumUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class LocatorPractice {
    //To use driver object in every method, make a static WebDriver driver object
    // driver = BrowserFactory.getDriver("")
    //add a main method
    //add a test static no return type(void) test method

    static WebDriver driver = BrowserFactory.getDriver("chrome");

    public static void main(String[] args) throws Exception {
        try {
            test();
        } catch (Exception e) {
            // System.out.println("NoSuchElementException");

        }

        test2();


    }

    public static void test() throws Exception {
        driver.manage().window().maximize();
        // driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/login");
        driver.findElement(By.name("username")).sendKeys("tomsmith1");
        driver.findElement(By.name("password")).sendKeys("SuperSecretPassword");
        driver.findElement(By.id("wooden_spoon")).click();

        Thread.sleep(3000);
        // driver.close();
    }

    public static void test2() throws Exception {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/login");
        driver.findElement(By.name("username")).sendKeys("tomsmith");
        driver.findElement(By.name("password")).sendKeys("SuperSecretPassword");
        driver.findElement(By.id("wooden_spoon")).click();
        Thread.sleep(2000);

        String expected = "Welcome to the Secure Area. When you are done click logout below.";
        String actual = driver.findElement(By.className("subheader")).getText();
        SeleniumUtils.verifyEquals(expected, actual);

        Thread.sleep(2000);
        driver.close();
    }

}
