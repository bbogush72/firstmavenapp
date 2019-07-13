package practice.CyberTek.day6;

import Utilities.BrowserFactory;
import Utilities.SeleniumUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class radioButtonByVasyl {
    static WebDriver driver = BrowserFactory.getDriver("chrome");

    public static void main(String[] args) {
        openRadioButtonPage();
        test1();
        test2();
        test3();
        test4();
        driver.close();
    }


    public static void openRadioButtonPage() {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/radio_buttons");
    }

    //let's check if blue radio button is selected
    public static void test1() {
        WebElement blueBtn = driver.findElement(By.id("blue"));
        if (blueBtn.isSelected()) {
            System.out.println("PASSED");
        } else {
            System.out.println("FAILED");
        }
        SeleniumUtils.wait(2);
    }

    public static void test2() {
        WebElement blkButton = driver.findElement(By.id("black"));
        WebElement greenButton = driver.findElement(By.id("green"));
        if (blkButton.isEnabled() && !greenButton.isEnabled()) {
            System.out.println("passed only black selected");
        } else {
            System.out.println("failed, black is not selected");

        }
    }

    public static void test3() {
        WebElement blueBtn = driver.findElement(By.id("blue"));
        WebElement blkButton = driver.findElement(By.id("black"));
        if (blueBtn.isSelected() && blkButton.isSelected()) {
            System.out.println("passed blue and black " + blueBtn.isSelected() + " " + blkButton.isSelected());
        } else {
            System.out.println("failed blue and failed black " + blueBtn.isSelected() + " " + blkButton.isSelected());
        }
    }

    public static void test4() {
        List<WebElement> listRadioButtons = driver.findElements(By.xpath("//input[@type='radio']"));
        int counter = 0;
        for (WebElement radioButton : listRadioButtons) {
            if (radioButton.isSelected()) {
                counter++;

            }

        }
        System.out.println("selected button numbers: " + counter);


    }

}
