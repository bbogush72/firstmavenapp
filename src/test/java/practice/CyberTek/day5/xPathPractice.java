package practice.CyberTek.day5;

import Utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class xPathPractice {
    static WebDriver driver = BrowserFactory.getDriver("chrome");


    public static void main(String[] args) throws Exception {
        test();


    }

    public static void test() throws Exception {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/sign_up");
        driver.findElement(By.xpath("//input[@name='full_name']"));
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys("student@gmail.com");
        driver.findElement(By.xpath("//button[@name='wooden_spoon']"));

        Thread.sleep(3000);
        driver.close();
    }

}
