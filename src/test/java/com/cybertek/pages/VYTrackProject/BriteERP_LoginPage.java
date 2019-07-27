package com.cybertek.pages.VYTrackProject;

import com.cybertek.Utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class BriteERP_LoginPage {
    //xpath for userName button //input[@name='login']
    static String userNameLocator = "//input[@name='login']";
    //xpath for the storemanagerPassword box //input[@name='storemanagerPassword']
    static String passwordLocator = "//input[@id='password']";
    static String loginButtonLocator = "//button[@type='submit']";
    WebDriver driver;

    public static void login() throws IOException {
        String path = "X:/AppHangar/firstmavenapp/configuration.properties";
        //create object of inputs stream to access file
        FileInputStream input = new FileInputStream(path);
        //initialize config file
        Properties configFile = new Properties();
        //load properties file
        configFile.load(input);
        Driver.getDriver().findElement(By.xpath(userNameLocator)).sendKeys(configFile.getProperty("em"));
        Driver.getDriver().findElement(By.xpath(passwordLocator)).sendKeys(configFile.getProperty("pw"));
        Driver.getDriver().findElement(By.xpath(loginButtonLocator)).click();


    }
}
