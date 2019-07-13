package practice.CyberTek.day9;

import Utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class study1 {

    private WebDriver driver = BrowserFactory.getDriver("chrome");

    @BeforeMethod // runs before every @TestPLT
    public void setup() {
        driver.get("http://practice.cybertekschool.com/sign_up");
    }

    @Test
    public void test1() {
        driver.findElement(By.xpath("html/body/div/div[2]/div/div/form/div/div[1][@name='full_name']"));
        driver.findElement(By.xpath("html/body/div/div[2]/div/div/form/div/div[1][@name='email']"));
        driver.findElement(By.xpath("html/body/div/div[2]/div/div/form/button")).click();
        String expectedMessage = "Thank you for signing up. Click the button below to return to the home page.";
        //String actualMessage = driver.findElement
    }
}
