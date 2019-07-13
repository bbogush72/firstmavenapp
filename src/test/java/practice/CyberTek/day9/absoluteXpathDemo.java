package practice.CyberTek.day9;

import Utilities.BrowserFactory;
import Utilities.SeleniumUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class absoluteXpathDemo {
    //we use only inside this class, that's why it's private
    private WebDriver driver = BrowserFactory.getDriver("chrome");

    @BeforeMethod // it runs before every @TestPLT
    public void setup() {
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/sign_up");
    }

    @Test
    public void test1() {
        //find input box to enter name
        driver.findElement(By.xpath("html/body/div/div[2]/div/div/form/div/div[1]/input[@name='full_name']")).sendKeys("Java GURU");
        //find input box to enter email
        driver.findElement(By.xpath("html/body/div/div[2]/div/div/form/div/div[1]/input[@name='email']")).sendKeys("tomsmith@email.com");
        SeleniumUtils.wait(2);
        //find button to click sign up
        driver.findElement(By.xpath("html/body/div/div[2]/div/div/form/button")).click();
        SeleniumUtils.wait(2);
        //expected message
        String expectedMessage = "Thank you for signing up. Click the button below to return to the home page.";
        //actual will be coming from the page
        String actualMessage = driver.findElement(By.xpath("html/body/div/div[2]/div/div/h3")).getText();
        //verify that expected and actual message is the same
        //if no, it will stop test and throw exception
        //you will see in the console log what's exactly didn't match
        Assert.assertEquals(actualMessage, expectedMessage);
    }

    @AfterMethod // it will run after every @TestPLT
    public void teardown() {
        driver.quit();
    }
}
//html/body/div/div[2]div/div/form/div/div[1]/input/