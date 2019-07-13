package Utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class SeleniumUtils {

    public static void verifyEquals(String expectedResult, String actualResult) {
        if (expectedResult.equals(actualResult)) {
            System.out.println("Passed");
        } else {
            System.out.println("Failed");
            System.out.println("Expected result: " + expectedResult);
            System.out.println("Actual result: " + actualResult);
        }
    }

    /**
     * This method will put on pause execution
     *
     * @param seconds
     */
    public static void wait(int seconds) {

        try {
            Thread.sleep(seconds * 1000);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


    /**
     * @param page
     * @param driver This method will open example page based on link
     */
    public static void openPage(String page, WebDriver driver) {

        //find all examples on the webpage
        List<WebElement> listOfExamples = driver.findElements(By.tagName("a"));

        for (WebElement example : listOfExamples) {
            if (example.getText().contains(page)) {
                example.click();
                break;
            }


        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/checkboxes");
    }

    public static void verifyIsDisplayed(WebElement element) {
        if (element.isDisplayed()) {
            System.out.println("Passed");
            System.out.println(element.getText() + " is visible");
        } else {
            System.out.println(element.getText() + " is not visible");
        }
    }

}
