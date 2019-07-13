package practice.CyberTek.day4;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test1 {

    public static void main(String[] args) throws Exception {
        //this line replaces System.setProperty();
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/forgot_password");

        WebElement submitButton = driver.findElement(By.id("form_submit"));
        WebElement inputBox = driver.findElement(By.name("email"));

        inputBox.sendKeys("email@gmail.com");
        Thread.sleep(2000);

        submitButton.click();
        Thread.sleep(2000);

        WebElement confirmationMessage = driver.findElement(By.name("confirmation_message"));

        String expectedMessage = "Your e-mail's been sent!";
        String actualMessage = confirmationMessage.getText(); // how to get text of element

        //we verify that expected message is the same as on the page
        if (actualMessage.equals(expectedMessage)) {
            System.out.println("TestPLT passed");
        } else {
            System.out.println("TestPLT failed");
            System.out.println("Expected message: " + expectedMessage);
            System.out.println("Actual message: " + actualMessage);
        }
        driver.close();
    }
}
