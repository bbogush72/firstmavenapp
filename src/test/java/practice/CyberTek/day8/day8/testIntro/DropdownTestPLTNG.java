package practice.CyberTek.day8.day8.testIntro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/*
//    open website http://practice.cybertekschool.com/dropdown
//    verify default year is current 2019
//    verify default month is current July
//    verify default day is current 7
 */
public class DropdownTestPLTNG {
    WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @BeforeMethod
    public void setup() {
        // WebDriverManager.chromedriver().setup();
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/dropdown");
    }

    @Test(priority = 1)
    public void test1() {
        int expectedYear = 2019;
        String expectedMonth = "July";
        int expectedDay = 7;

        //Assert.assertEquals(a, b);
        Select selectYear = new Select(driver.findElement(By.id("year")));
        Select selectMonth = new Select(driver.findElement(By.id("month")));
        Select selectDay = new Select(driver.findElement(By.id("day")));

        int actualYear = Integer.parseInt(selectYear.getFirstSelectedOption().getText());
        String actualMonth = selectMonth.getFirstSelectedOption().getText();
        int actualDay = Integer.parseInt(selectDay.getFirstSelectedOption().getText());

        Assert.assertEquals(actualDay, expectedDay);
        Assert.assertEquals(actualMonth, expectedMonth);
        Assert.assertEquals(actualYear, expectedYear);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
