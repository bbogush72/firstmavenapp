package AmazonTest;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AmazonTest {

    public static void main(String[] args) throws Exception {


        //
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://amazon.com");
        driver.manage().window().maximize();
        WebElement inputBox = driver.findElement(By.id("twotabsearchtextbox"));

        inputBox("java book");
        // inputBox("laptop");
        // Thread.sleep(2000);

        //WebElement inputBox = driver.findElement(By.id("twotabsearchtextbox"));
        //inputBox.sendKeys("laptop");

//        WebElement submitButton = driver.findElement(By.name("field-keywords"));
//        Thread.sleep(2000);
//        submitButton.submit();


        // driver.navigate().back();
        //  WebElement inputBox2 = driver.findElement(By.id("twotabsearchtextbox"));
        // WebElement submitButton2 = driver.findElement(By.id("nav-search-submit-text"));
        //  inputBox.sendKeys("java book");
        //  submitButton.submit();
        //  Thread.sleep(3000);


        // driver.navigate().back();
        Faker faker = new Faker();
        // WebElement inputBox3 = driver.findElement(By.id("twotabsearchtextbox"));
        // WebElement submitButton3 = driver.findElement(By.id("nav-search-submit-text"));
        String name = faker.chuckNorris().fact();
        // inputBox.clear();
        //  inputBox.sendKeys(name);
        // submitButton.submit();
        //   Thread.sleep(3000);
//use clear method ==>emailInputBox.clear();
//continue using sendKeys() method
// WebElement creation driver.findElement(By.LocName());
// getAttribute() utilize   InputBox.getAttribute("pattern")


    }

    public static void inputBox(String str) throws Exception {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        WebElement inputBox = driver.findElement(By.id("twotabsearchtextbox"));
        // driver.get("http://amazon.com");
        inputBox.sendKeys("laptop");

        WebElement submitButton = driver.findElement(By.name("field-keywords"));
        Thread.sleep(2000);
        submitButton.submit();
        Thread.sleep(2000);
        driver.close();
    }

}
