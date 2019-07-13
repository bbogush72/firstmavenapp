package practice.CyberTek.day5;

import Utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ClassNamePractice {

    static WebDriver driver = BrowserFactory.getDriver("chrome");

    public static void main(String[] args) {
        test();

    }

    public static void test() {
        driver.get("http://practice.cybertekschool.com/");
        List<WebElement> list1 = driver.findElements(By.className("list-group-item"));
        for (WebElement element : list1) {
            System.out.println(element.getText());
        }
        driver.close();


    }
}
