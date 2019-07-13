package AmazonTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;


public class AmazonTestTrial2 {
    static WebDriver driver;

    public static void main(String[] args) throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("http://amazon.com");
        inputBox("laptop");
        driver.navigate().back();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);


        inputBox("smart phone");
    }

    public static void inputBox(String str) throws Exception {

        WebElement inputBox = driver.findElement(By.id("twotabsearchtextbox"));
        inputBox.sendKeys(str);
        WebElement submitButton = driver.findElement(By.name("field-keywords"));
        Thread.sleep(2000);
        submitButton.submit();
        Thread.sleep(2000);
        //  inputBox.clear();
        driver.close();
    }

}