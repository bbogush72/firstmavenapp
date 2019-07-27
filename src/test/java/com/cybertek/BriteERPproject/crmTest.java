package com.cybertek.BriteERPproject;

import com.cybertek.Utilities.SeleniumUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class crmTest {
    //driver object needed to perform functions
    WebDriver driver;
    /*
User Story =>
    As a user, when I already created an opportunity in CRM module of Bribe ERP application,
    I want to be able to delete it.

Acceptance Criteria :
    1.Verify that user should be able to see the list view.
    2.Verify that user should be able to delete the opportunity from action drop down list .

Language ---> Java, HTML
Testing tool ---> Selenium WebDriver, Maven, TestNG
Project management/ bug track tool ---> Jira (was optional)
Version control system ---> Git
Build management tool ---> Maven
IDE ---> IntelliJ
Browsers ---> Google Chrome, Firefox
Project Methodologies ---> Agile-Scrum
ERP stands for Enterprise Resource Planning, Brite is a name, BriteERP ERP is one of software in the market.
    -The application is for companies to manage their internal and external finance, communications,  day to day activities
CRM  is a major module which stands for Customer Relationship Management
     */
    // xpart for emailButton
    String emailButton = "//input[@name='login']";
    // xpart for storemanagerPassword button
    String passwordButton = "//input[@name='storemanagerPassword']";
    //Orijinal xpath /button[contains(text(), "Create")]

    String loginBox = "//button[@type='submit']";

    //description = "runs before every test method"
    @BeforeMethod
    public void login() {
        // setup to access chrome browser
        WebDriverManager.chromedriver().setup();
        //assign driver to chrome driver method
        driver = new ChromeDriver();
        // make the page full screen
        driver.manage().window().maximize();
        //wait 15 seconds if it fails to load, throw exception
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        //open the webpage
        driver.get("http://34.220.250.213/web/login");
        //type the user name
        driver.findElement(By.xpath(emailButton)).sendKeys("Lunch_InvoicingManager3@info.com");
        //type the storemanagerPassword
        driver.findElement(By.xpath(passwordButton)).sendKeys("LD686gfX24");
        driver.findElement(By.xpath(loginBox)).click(); //submit to login


    }

    @Test
    public void Crm() {
        // CRM button path clicked here
        driver.findElement(By.xpath("//span[@class='oe_menu_text' and contains(text(),'CRM')]")).click();
        SeleniumUtils.waitPlease(3);
        //List button clicked
        driver.findElement(By.xpath("//button[@aria-label='list']")).click();
        SeleniumUtils.waitPlease(3);
        //gets the total number of products in text format
        String listFirst = driver.findElement(By.xpath("//span[@class='o_pager_limit']")).getText();
        // System.out.println("Total number of products: "+ driver.findElement(By.xpath("//span[@class='o_pager_limit']")));
        System.out.println("Total number of products: " + driver.findElement(By.xpath("//span[@class='o_pager_limit']")).getText());
        //make the total number of products in the integer format
        int listNum = Integer.parseInt(listFirst);
        //verify the total number is greater than zero
        Assert.assertTrue(listNum > 0);
        //click on text box to choose a product
        driver.findElement(By.xpath("//tr[1]//td[1]//div[1]//input[1]")).click();
        SeleniumUtils.waitPlease(2);
        //click the action button to access delete tag
        driver.findElement(By.xpath("//button[@data-toggle='dropdown' and contains(text(),'Action')] ")).click();
        SeleniumUtils.waitPlease(2);
        //click the delete button
        driver.findElement(By.xpath("//a[@data-index='3']")).click();
        SeleniumUtils.waitPlease(2);
        //verify that ok button pressed
        driver.findElement(By.xpath("//span[contains(text(),'Ok')]")).click();
        SeleniumUtils.waitPlease(2);

        ////gets the total number of products in text format
        String listSec = driver.findElement(By.xpath("//span[@class='o_pager_limit']")).getText();
        System.out.println("Total number of products: " + driver.findElement(By.xpath("//span[@class='o_pager_limit']")).getText());

        //make the string into text type; of the total num of products
        int listNum1 = Integer.parseInt(listSec);
        //verify the total number of products is greater before deletion
        Assert.assertTrue(listNum > listNum1);
        //this is the element keeping path to list button
        WebElement element = driver.findElement(By.xpath("//span[@class='o_pager_limit']"));
        // if element is enabled, meaning list view clicked, print success else fail
        if (element.isEnabled()) {
            System.out.println("List view successfully opened!");
        } else {
            System.out.println("List view failed!");
        }
    }

    // close all tabs after every method
    @AfterMethod
    public void TearDown() {
        //close all
        driver.quit();
    }


}