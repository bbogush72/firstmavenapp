package com.cybertek.Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class BriteTestBase {
    public static WebDriver driver;
    Actions action;

    @BeforeMethod
    public void setup() {
        driver = Driver.getDriver();
        action = new Actions(driver);
        driver.manage().timeouts().implicitlyWait
                (Long.valueOf(ConfigurationReader
                        .getProperty("implicitwait")), TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(ConfigurationReader.getProperty("urlBriteERP"));

    }

    @AfterMethod
    public void teardown() {
        Driver.closeDriver();
    }
}

