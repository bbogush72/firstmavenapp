package practice.CyberTek.day7;

import Utilities.BrowserFactory;
import Utilities.SeleniumUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class dropDownPractice {
    static WebDriver driver = BrowserFactory.getDriver("chrome");

    public static void main(String[] args) {
        openDropDownPage();
        // test1();
        //test2();
        // test3();
        //test4();
        nonSelectDropdown();
        driver.close();
    }

    public static void openDropDownPage() {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/dropdown");

        String expected = "Dropdown List";
        String actual = driver.findElement(By.tagName("h3")).getText();
        //h3[text()='Dropdown List']

        WebElement element = driver.findElement(By.xpath(" //h3[text()='Dropdown List']"));
        SeleniumUtils.verifyIsDisplayed(element);
    }

    public static void test1() {
        WebElement dropdown1 = driver.findElement(By.id("dropdown"));
        //to work with select elements
        //we need to use Select class
        Select dropdownSelect = new Select(dropdown1);
        String selected = dropdownSelect.getFirstSelectedOption().getText();
        System.out.println(selected);

        //getFirstSelectedOption() returns already selected option.
        //we usually read text  to verify if text equals expected, use .getText()
        String actual = dropdownSelect.getFirstSelectedOption().getText();
        String expected = "Please select an option";
        SeleniumUtils.verifyEquals(expected, actual);

        //get list of options present in the dropdown menu
        List<WebElement> options = dropdownSelect.getOptions();
        for (WebElement option : options) {
            System.out.println(option.getText());
        }

    }

    public static void test2() {
        WebElement dropdownState = driver.findElement(By.id("state"));

        //use this object to find text/options
        Select dropDownSelect = new Select(dropdownState);

        //getOptions is list of elements
        List<WebElement> states = dropDownSelect.getOptions();

        for (WebElement element : states) {
            System.out.println(element.getText());
        }

        //let's select Virginia, use object of Select class
        dropDownSelect.selectByVisibleText("Virginia");

        SeleniumUtils.wait(2);

        dropDownSelect.selectByVisibleText("Texas");

        SeleniumUtils.wait(2);

        dropDownSelect.selectByVisibleText("Arkansas");

        SeleniumUtils.wait(2);
    }

    public static void test3() {
        WebElement dropdownState = driver.findElement(By.id("state"));

        //use this object to find text/options
        Select dropDownSelect = new Select(dropdownState);

        //getOptions is list of elements
        List<WebElement> states = dropDownSelect.getOptions();

        for (WebElement option : states) {

            SeleniumUtils.wait((int) 0.8);
            dropDownSelect.selectByVisibleText(option.getText());


        }
    }

    //select by value
    public static void test4() {
        WebElement dropdownState = driver.findElement(By.id("state"));
        Select dropDownSelect = new Select(dropdownState);

        //<option value="PA>Pennsylvania</option>
        //means find option that has value PA and select it

        dropDownSelect.selectByValue("PA");
        SeleniumUtils.wait(1);
        String expected = "Pennsylvania";
        String actual = dropDownSelect.getFirstSelectedOption().getText();
        SeleniumUtils.verifyEquals(expected, actual);
    }

    //select by index
    public static void test5() {
        WebElement dropdownState = driver.findElement(By.id("state"));
        Select dropDownSelect = new Select(dropdownState);

        dropDownSelect.selectByIndex(5);
        SeleniumUtils.wait(2);

    }

    //multiple select
    public static void test6() {
        WebElement multiSelection = driver.findElement(By.id("state"));
        Select multiSelectObj = new Select(multiSelection);

        multiSelectObj.selectByVisibleText("Java");
        multiSelectObj.selectByVisibleText("JavaScript");
        SeleniumUtils.wait(2);


    }

    // new method below
    public static void nonSelectDropdown() {
        WebElement multiSelection = driver.findElement(By.id("state"));
        Select multiSelectObj = new Select(multiSelection);

        multiSelectObj.selectByVisibleText("Java");
        multiSelectObj.selectByVisibleText("JavaScript");
        SeleniumUtils.wait(2);

        //practice these
        multiSelectObj.deselectByIndex(2);

        SeleniumUtils.wait(2);

        multiSelectObj.deselectByValue("Java");
        SeleniumUtils.wait(2);

        multiSelectObj.deselectAll();

        SeleniumUtils.wait(2);
        multiSelectObj.deselectByVisibleText("JavaScript");

        SeleniumUtils.wait(2);
        multiSelectObj.isMultiple();

    }
}

