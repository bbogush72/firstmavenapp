package practice.CyberTek.day6;

import Utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class Warmup {

    static WebDriver driver = BrowserFactory.getDriver("chrome");

    public static void main(String[] args) {
        testAmazon();

        testWiki();
    }


    public static void testAmazon() {

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        driver.get("https://amazon.com");

        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Laptop");

        driver.findElement(By.className("nav-input")).click();

        String title = driver.getTitle();

        if (title.contains("Laptop")) {
            System.out.println("passed");
        } else {
            System.out.println("failed");
        }
        driver.close();

    }


    public static void testWiki() {

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        driver.get("https://www.wikipedia.org/");

        driver.findElement(By.id("searchInput")).sendKeys("world war 1");

        driver.findElement(By.xpath("//*[@id=\"search-form\"]/fieldset/button")).click();

        String title = driver.getTitle();
        System.out.println(title);
        if (title.contains("ww1")) {
            System.out.println("passed");
        } else {
            System.out.println("failed");
        }
        driver.close();

    }
}
