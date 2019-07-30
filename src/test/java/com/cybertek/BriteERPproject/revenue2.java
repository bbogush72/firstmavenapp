package com.cybertek.BriteERPproject;

import com.cybertek.Utilities.BriteTestBase;
import com.cybertek.Utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class revenue2 extends BriteTestBase {
    /**
     * User story: The system should display the correct information
     * for each opportunity on the view list page and the pivot table
     * <p>
     * Acceptance Criteria: Verify that second opportunity' Expected Revenue value
     * on the pivot board should be the same as Expected
     * Revenue column value on the list board.
     * user1: eventscrmmanager36@info.com
     * user2: eventscrmmanager37@info.com"
     * eventscrmmanager
     */
//    WebDriver driver;
//    static String userNameLocator = "//input[@name='login']";
//    //xpath for the storemanagerPassword box //input[@name='storemanagerPassword']
//    static String passwordLocator = "//input[@id='password']";
//    static String loginButtonLocator = "//button[@type='submit']";
    BriteLogin login = new BriteLogin();
    Paths1 path = new Paths1();

    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 5);

//    @BeforeMethod
//    public void setup(){
//        driver = new ChromeDriver();
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        driver.manage().window().maximize();
//        driver.get("http://34.220.250.213/web/login");
//        driver.get("//http://54.148.96.210/web/login");
//        driver.findElement(By.xpath(userNameLocator)).sendKeys("eventscrmmanager36@info.com");
//        driver.findElement(By.xpath(passwordLocator)).sendKeys("eventscrmmanager", Keys.ENTER);
//        // driver.findElement(By.xpath(loginButtonLocator)).click();
//    }

    @Test
    public void ListView() throws IOException {
        BriteLogin.login();


        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='o_thread_title']")));
        Assert.assertEquals(driver.getTitle(), "#Inbox - Odoo");

        driver.findElement(By.xpath(path.CrmButton)).click();
        //  driver.findElement(By.xpath(path.pipelineButton)).click(); //problem here

        driver.findElement(By.cssSelector(path.listButton)).click();
        String listMoney = driver.findElement(By.cssSelector(path.listNewTotals)).getText();


        driver.findElement(By.cssSelector(path.pivotButton)).click();
        String pivotMoney = driver.findElement(By.cssSelector(path.pivotNewTotals)).getText();

        Assert.assertEquals(listMoney, pivotMoney);


    }

    @AfterMethod
    public void exit() {
        driver.quit();
    }


}

