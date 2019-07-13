package practice.CyberTek.day6;

import Utilities.BrowserFactory;
import Utilities.SeleniumUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class CheckBoxTests {

    static WebDriver driver = BrowserFactory.getDriver("chrome");

    public static void main(String[] args) {
        openCheckBoxesPage();
        test1();

        test2();
        driver.quit();
    }


    public static void openCheckBoxesPage() {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/checkboxes");
        //let's make sure that Checkboxes header is visible, not only in the code
        WebElement checkboxesLogo = driver.findElement(By.tagName("h3"));
        if (checkboxesLogo.isDisplayed()) {
            System.out.println("Checkboxes logo is visible");
        } else {
            System.out.println("Checkboxes logo not found!");
        }

    }

    //verify  that checkbox 1 is not selected and checkbox 2 is selected
    public static void test1() {
        WebElement checkbox1 = driver.findElement(By.xpath("//input[@type='checkbox'][1]"));
        WebElement checkbox2 = driver.findElement(By.xpath("//input[@type='checkbox'][2]"));
        //to verify if checkbox 1 is not selected
        if (!checkbox1.isSelected()) {
            System.out.println("PASSED");
        } else {
            System.out.println("FAILED");
        }
        //to verify if checkbox 2 is selected

        if (checkbox2.isSelected()) {
            System.out.println("PASSED");

        } else {
            System.out.println("FAILED");
        }

    }

    public static void test2() {
        openCheckBoxesPage();
        WebElement checkbox1 = driver.findElement(By.xpath("//input[@type='checkbox'][1]"));
        WebElement checkbox2 = driver.findElement(By.xpath("//input[@type='checkbox'][2]"));
        SeleniumUtils.wait(2);
        checkbox1.click();
        checkbox2.click();

        if (checkbox1.isSelected() && checkbox2.isSelected()) {
            System.out.println("PASSED");
        } else {
            System.out.println("FAILED");
        }
    }


}

