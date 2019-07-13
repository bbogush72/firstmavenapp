package practice.CyberTek.day7;

import Utilities.BrowserFactory;
import Utilities.SeleniumUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static java.util.concurrent.TimeUnit.SECONDS;

public class CheckBoxTestsBySnailMail {
    //"http://practice.cybertekschool.com/checkboxes"
    // CheckBox 1 and CheckBox 2
    // We will try to write xpath locations of these two boxes.
    // use isSelected() ?? verifies if a checkbox is selected
    // isDisplayed() ?? verifies if element we look for is visible.
    // True, false(element might be hidden), exception(not present at all)
    static WebDriver driver = BrowserFactory.getDriver("chrome");

    public static void main(String[] args) {
        //openPage();
        TestPageDisplayed();
        TestPageIsChecked();
        driver.quit();

    }

    public static void openPage() {
        driver.manage().window().maximize();
        //we want all elements loaded in time, no exception should be thrown
        //to do that, we must add an impicitWait method to make sure all works out.
        driver.manage().timeouts().implicitlyWait(10, SECONDS);
        driver.get("http://practice.cybertekschool.com/checkboxes");
    }

    public static void TestPageDisplayed() {
        openPage();
        SeleniumUtils.wait(2);
        WebElement checkBoxLogo = driver.findElement(By.tagName("h3"));
        if (checkBoxLogo.isDisplayed()) {
            System.out.println("Logo is visible");
        } else {
            System.out.println("Logo is not found");
        }
    }

    public static void TestPageIsChecked() {
        openPage();
        SeleniumUtils.wait(2);
        //common syntax writing relative xpath locator:     //tagName[@attribute='value']
        WebElement checkbox1 = driver.findElement(By.xpath("//input[@type='checkbox'][1]"));
        WebElement checkbox2 = driver.findElement(By.xpath("//input[@type='checkbox'][2]"));

        if (!checkbox1.isSelected()) {
            System.out.println("passed");
        } else {
            System.out.println("failed");
        }
        SeleniumUtils.wait(2);

        if (checkbox2.isSelected()) {
            System.out.println("passed");
        } else {
            System.out.println("failed");
        }
    }


}
