package practice.CyberTek.day7;

import Utilities.BrowserFactory;
import Utilities.SeleniumUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class dropDownXPath {
    /**
     * Agenda;
     * get this website--> "http://practice.cybertekschool.com/dropdown"
     * use seleniumUtils verify isDisplayed(element); element
     * Select class; must create an object from select class to handle dropdown menus
     * <select id="state">
     * <option value="" selected="selected">Select a State</option>
     * <option value="TX">Texas</option>
     * <option value="UT">Utah</option>
     * <option value="VT">Vermont</option>
     * <option value="VA">Virginia</option>
     * <option value="WA">Washington</option>
     * </select>
     * <p>
     * To access option items, we must create a select class object
     * create a list of WebElements to store all options and use getOptions();
     * method to acquire/get all results printed
     */
    //driver object will help with methods and get them up and running
    static WebDriver driver = BrowserFactory.getDriver("chrome");

    public static void main(String[] args) {
        test1();
    }

    public static void test1() {
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/dropdown");

        // String expected = "Dropdown List";
        // String actual = driver.findElement(By.tagName("h3")).getText();
        //compare if actual equals expected;
        //We need a WebElement that will show the way to comparison
        //tag//attribute//value
        WebElement element = driver.findElement(By.xpath("//h3[text()='Dropdown List']"));

        SeleniumUtils.wait(2);
        //isDisplayed() method checks if element is present
        SeleniumUtils.verifyIsDisplayed(element);
        //=======================================================================================//
        //access options in the select class
        // WebElement dropDown = driver.findElement(By.id("dropdown"));
        WebElement dropDown = driver.findElement(By.id("state"));
        // WebElement dropDown = driver.findElement(By.id("year"));
        // WebElement dropDown = driver.findElement(By.id("month"));

        //in order to work with elements in Select class,
        // we must use an object from Select class
        //import org.openqa.selenium.support.ui.Select;
        Select dropDownSelect = new Select(dropDown);

        //get a list of options present in the dropdown menu
        List<WebElement> options = dropDownSelect.getOptions();
        for (WebElement eachOption : options) {
            //eachOption can getText() method to print all options
            System.out.println(eachOption.getText());
        }

        driver.close();

    }


}
