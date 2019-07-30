package com.cybertek.BriteERPproject;

import com.cybertek.Utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class rev3 {


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
    WebDriver driver;
    String userNameLocator = "//input[@name='login']";
    //xpath for the storemanagerPassword box //input[@name='storemanagerPassword']
    String passwordLocator = "//input[@id='password']";
    String loginButtonLocator = "//button[@type='submit']";
    String CrmButton = "//span[@class='oe_menu_text' and contains(text(),'CRM')]";
    // public String pipelineButton = "//li[@class='active']//span[@class='oe_menu_text'][contains(text(),'Pipeline')]";
    // div:nth-child(5) > ul:nth-child(2) > li:nth-child(1) > a > span
    String pipelineButton = "div:nth-child(5) > ul:nth-child(2) > li:nth-child(1) > a > span";
    String listButton = "//button[@class='btn btn-icon fa fa-lg fa-list-ul o_cp_switch_list']";
    String listNewTotals = "tr:nth-child(3) > td:nth-child(9)";


    String pivotButton = "//button[@class='btn btn-icon fa fa-lg fa-table o_cp_switch_pivot']";
    String pivotNewTotals = "tr:nth-child(2) > td:nth-child(2)";

    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 5);

    @BeforeClass
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("http://34.220.250.213/web/login");
        // driver.get("//http://54.148.96.210/web/login");
        driver.findElement(By.xpath(userNameLocator)).sendKeys("Lunch_InvoicingManager3@info.com");
        driver.findElement(By.xpath(passwordLocator)).sendKeys("LD686gfX24", Keys.ENTER);
        // driver.findElement(By.xpath(loginButtonLocator)).click();
    }

    @Test
    public void ListView() throws IOException {
        // BriteLogin.login();


//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='o_thread_title']")));
//        Assert.assertEquals(driver.getTitle(), "#Inbox - Odoo");

        driver.findElement(By.xpath(CrmButton)).click();
        //driver.findElement(By.xpath(pipelineButton)).click(); //problem here

        driver.findElement(By.cssSelector(listButton)).click();
        String listMoney = driver.findElement(By.cssSelector(listNewTotals)).getText();


        driver.findElement(By.cssSelector(pivotButton)).click();
        String pivotMoney = driver.findElement(By.cssSelector(pivotNewTotals)).getText();

        Assert.assertEquals(listMoney, pivotMoney);


    }

    @AfterClass
    public void exit() {
        driver.quit();
    }


}
