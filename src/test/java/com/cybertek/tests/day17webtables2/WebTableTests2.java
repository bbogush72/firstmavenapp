package com.cybertek.tests.day17webtables2;

import com.cybertek.Utilities.TestBase;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WebTableTests2 extends TestBase {

    /**
     * Write a method returns count of rows
     */
    @Test
    public int getCountOfRows() {
        return driver.findElements(By.cssSelector("#table1 tr")).size();
    }

    /**
     * Write a method that will return count of rows
     */
    public int getCountOfRows(By by) {
        return driver.findElements(by).size();
    }

    @Test
    public void countOfRowsTest1() {
        Assert.assertEquals(getCountOfRows(), 5, "Number of rows doesn't match");
    }

    @Test
    public void countOfRowsTest2() {
        Assert.assertNotEquals(getCountOfRows(By.xpath("//table[1]//tr")), 5, "Number of rows doesn't match");
    }
}
