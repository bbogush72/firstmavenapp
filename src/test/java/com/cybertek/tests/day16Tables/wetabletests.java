package com.cybertek.tests.day16Tables;

import com.cybertek.Utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class wetabletests extends TestBase {

    @Test
    public void printTableTest() {
        String table = driver.findElement(By.id("table1")).findElement(By.tagName("thead")).getText();
        System.out.println(table);
    }

    @Test
    public void printHeaderRow() {
        WebElement header = driver.findElement(By.id("table1")).findElement(By.tagName("thead"));
        System.out.println(header.getText());
    }

    @Test
    public void printHeaderRow2() {
        WebElement table = driver.findElement(By.id("table1"));
        int num = driver.findElements(By.tagName("thead")).size();

        for (int i = 1; i < num; i++) {
            System.out.println(driver.findElements(By.tagName("thead")).get(i).getText());
        }

    }

    @Test
    public void countHeaderRow() {
        //means find table with id table1 then go to tbody and to tr
        //represents the number of rows in first table
        String locator = "table[id='table1']> tbody tr";
        List<WebElement> rows = driver.findElements(By.cssSelector(locator));
        System.out.println("Size: " + rows.size());
    }


    @Test //get the number of rows in the second tbale, include the heading
    public void countRowTest2() {
        String locator = "#table2 tr";
        List<WebElement> rows = driver.findElements(By.cssSelector(locator));
        Assert.assertEquals(5, rows.size());
    }

    @Test
    public void printTableHeaders() {
        String locator = "#table1 th";
        List<WebElement> headers = driver.findElements(By.cssSelector(locator));
        for (WebElement header : headers) {
            System.out.println(header.getText());
        }
    }

    //print certain row
    @Test
    public void printSpecificRow() {
        int row = 3;
        String locator = "//table[1]//tbody//tr[" + row + "]";
        WebElement rowElement = driver.findElement(By.xpath(locator));
        System.out.println(rowElement.getText());
    }

    //method returns column based on column name
    @Test
    public List<String> getColumn(String columnName) {

        List<String> values = new ArrayList<>();
        //all headings
        List<WebElement> headings = driver.findElements(By.xpath("//table[1]//th"));
        int columnNumber = 0;
        //we are looping though collection of headings
        for (int i = 0; i < headings.size(); i++) {
            //we are looking for position of heading
            if (headings.get(i).getText().equals(columnName)) {
                columnNumber = i + 1;
                break;
            }
        }
        //based on position that we found in previous loop, we allocating column
        List<WebElement> columnList = driver.findElements(By.xpath("//table[1]//tr//td[" + columnNumber + "]"));

        for (WebElement columnValue : columnList) {
            values.add(columnValue.getText());
        }

        return values;
    }

    @Test
    public void printColumn() {
        // getColumn("Email");

        System.out.println(getColumn("First Name"));
    }

    @Test
    public void verifyThatNameDisplays() {
        String lastName = "Doe";
        String firstName = "Jason";
        /*
         String firstNameLocator = "//table[1]//tbody//tr[3]//td[2]";
        String lastNameLocator = "//table[1]//tbody//tr[3]//td[1]";
         */
        String firstNameLocator = "//table[1]//tbody///tr[3]//td[2]";
        String lastNameLocator = "//table[1]//tbody///tr[3]//td[1]";
        String actualName = driver.findElement(By.xpath(firstNameLocator)).getText();
        String actualLastName = driver.findElement(By.xpath(lastNameLocator)).getText();

        Assert.assertEquals(actualLastName, lastName);
        Assert.assertEquals(firstName, actualName);

    }

    @Test(dependsOnMethods = "verifyThatNameDisplays")
    public void verifyThatRecordHasBeenDeletedTest() {
        String firstName = "Jason";
        String lastName = "Doe";
        String firstNameLocator = "//table[1]//tbody//tr[3]//td[2]";
        String lastNameLocator = "//table[1]//tbody//tr[3]//td[1]";

        String target = "//table[1]//td[text()='" + lastName + "']";

        String deleteLocator = "//table[1]//td[text()='" + lastName + "']/following-sibling::td//a[text()='delete']";

        driver.findElement(By.xpath(deleteLocator)).click();

        Assert.assertTrue(driver.findElements(By.xpath(target)).isEmpty());
    }


}
