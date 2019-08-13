package com.cybertek.JavaPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class DiceJobSearch {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();        //Set up driver path
        WebDriver driver = new ChromeDriver();        //


        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        String url = "https://dice.com";
        driver.get(url);

        String actualTitle = driver.getTitle();
        String expectedTitle = "Job Search for Technology Professionals | Dice.com";

        if (actualTitle.equals(expectedTitle)) {
            System.out.println("Step Pass. Dice homepage successfully loaded");
        } else {
            System.out.println("Step FAIL. Dice homepage did not load successfully");
            throw new RuntimeException("Step FAIL. Dice homepage did not load successfully");
//			throw new RuntimeErrorException("Step FAIL. Dice homepage did not load successfully");
        }

        String keyword = "java developer";
        driver.findElement(By.id("search-field-keyword")).clear();
        driver.findElement(By.id("search-field-keyword")).sendKeys(keyword);

        String location = "78717";
        driver.findElement(By.id("search-field-location")).clear();
        driver.findElement(By.id("search-field-location")).sendKeys(location);

        driver.findElement(By.id("findTechJobs")).click();

        String count = driver.findElement(By.id("posiCountId")).getText();
        System.out.println(count);
        int countResult = Integer.parseInt(count.replaceAll(",", ""));

        if (countResult > 0) {
            System.out.println("Step PASS: keyword " + keyword + " search returned " + countResult + " results in " + location);
        } else {
            System.out.println("Step FAIL: keyword " + keyword + " search returned " + countResult + " results in " + location);
        }

        driver.close();


    }

}
