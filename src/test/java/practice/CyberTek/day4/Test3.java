package practice.CyberTek.day4;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test3 {

    public static void main(String[] args) throws Exception {
        //this line replaces System.setProperty("webdriver", "pah to the webdriver")
        WebDriverManager.chromedriver().setup(); //setup webdriver
        //driver will give us access to the browser
        WebDriver driver = new ChromeDriver(); // create object of chrome driver
        driver.manage().window().maximize(); // open browser maximized
        driver.get("http://practice.cybertekschool.com/forgot_password"); // open url

        WebElement emailInputBox = driver.findElement(By.name("email")); //we found input box
        WebElement submitButton = driver.findElement(By.id("form_submit"));//we found submit button


        emailInputBox.sendKeys("sdetpro3000@gmail.com"); //to enter tex into input box
        System.out.println(emailInputBox.getAttribute("pattern")); //to read value of pattern attribute
        System.out.println(emailInputBox.getAttribute("value")); //info you input in the field
        submitButton.submit(); //it only works with buttons Click method is more flexible
        //submitButton.click();

        //pattern should print : [a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,3}$

        Thread.sleep(3000);
        driver.close();

    }
}
