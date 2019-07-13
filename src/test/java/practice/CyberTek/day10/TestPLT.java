package practice.CyberTek.day10;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestPLT {
    public static void main(String[] args) {
        test();
    }

    public static void test() {
        WebDriver driver;

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        for (int i = 0; i < 3; i++) {
            driver.get("https://my.pltw.org/login?logout");
            driver.findElement(By.id("username")).sendKeys("bbogush72@gmail.com");
            driver.findElement(By.id("password")).sendKeys("Pencere7@");
            driver.findElement(By.cssSelector("[onclick= 'doLogin()']")).click();
        }

    }


}
