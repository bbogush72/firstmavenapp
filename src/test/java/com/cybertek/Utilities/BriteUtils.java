package com.cybertek.Utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;

public class BriteUtils {
    WebDriver driver = Driver.getDriver();
    String actionButtonLocator = "//button[contains(text(),'Action')]";
    String okLocator = "//span[text()='Ok']";

    WebDriverWait wait = new WebDriverWait(driver, 10);

    /**
     * Select opportunity based on opportunity title
     *
     * @param opportunity
     */
    public void selectOpportunity(String opportunity) {
        String locator = "//td[text()='" + opportunity + "']/preceding-sibling::td//input";
        driver.findElement(By.xpath(locator)).click();
    }

    /**
     * Method that deletes opportunity based on opportunity title
     *
     * @param opportunity
     */
    public void deleteOpportunity(String opportunity) {
        selectOpportunity(opportunity);
        selectAction("Delete");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(okLocator)));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(okLocator))));
        driver.findElement(By.xpath(okLocator)).click();
    }

    /**
     * Method that selects action for opportunity
     *
     * @param actionName
     */
    public void selectAction(String actionName) {
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(actionButtonLocator))));
        driver.findElement(By.xpath(actionButtonLocator)).click();
        String optionLocator = "//a[contains(@data-section,'other') and contains(text(),'" + actionName + "')]";
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(optionLocator))));
        driver.findElement(By.xpath(optionLocator)).click();
    }

    /**
     * Based on opportunity title this method will verify that there is no cell with a given text
     *
     * @param opportunity
     */
    public void verifyThatOpportunityDeleted(String opportunity) {
        String locator = "//td[text()='" + opportunity + "']";
        List<WebElement> elements = driver.findElements(By.xpath(locator));
        Assert.assertTrue(elements.isEmpty());
    }

    /**
     * =====================================================================================================
     * This method is to send keys with Explicit waits
     * you will change time, or elements, this is biggest advantages
     *
     * @param driver
     * @param element
     * @param timeout
     * @param value
     */
    public static void sendKeys(WebDriver driver, WebElement element, int timeout, String value) {
        new WebDriverWait(driver, timeout).until(ExpectedConditions.visibilityOf(element));
        element.sendKeys(value);
    }

    /**
     * This method for click button with with Explicit waits
     *
     * @param driver
     * @param element
     * @param timeout
     */
    public static void clickOn(WebDriver driver, WebElement element, int timeout) {
        new WebDriverWait(driver, timeout).until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    /**
     * This method to verify a Page Title
     *
     * @param driver
     * @param title
     * @param timeout
     */
    public static void checkTitle(WebDriver driver, String title, int timeout) {
        new WebDriverWait(driver, timeout).until(ExpectedConditions.titleIs(title));
        //      Assert.assertTrue( driver.getTitle().contains(title));
        System.out.println(driver.getTitle());
    }




}