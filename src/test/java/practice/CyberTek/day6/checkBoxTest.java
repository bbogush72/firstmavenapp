package practice.CyberTek.day6;

import Utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class checkBoxTest {

    static WebDriver driver = BrowserFactory.getDriver("chrome");

    public static void main(String[] args) {
        openCheckBoxPage();
        test1();

        driver.close();
    }

    public static void openCheckBoxPage() {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/checkboxes");
    }


    public static void test1() {
        List<WebElement> checkBoxes = driver.findElements(By.xpath("//input[@type='checkbox']"));
        WebElement checkBox1 = driver.findElement(By.xpath("//input[@type='checkbox'] [1]"));
        WebElement checkBox2 = driver.findElement(By.xpath("//input[@type='checkbox'] [2]"));

        for (WebElement checkBox : checkBoxes) {
            if (checkBox1.isSelected()) {
                System.out.println("passed");
            } else {
                System.out.println("failed");
            }
        }

    }
}



