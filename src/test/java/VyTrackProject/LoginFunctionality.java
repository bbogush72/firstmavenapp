package VyTrackProject;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class LoginFunctionality {

    //static Webdriver driver;

    public static void main(String[] args) throws Exception {
        //setup webdriver manager to access google chrome
        WebDriverManager.chromedriver().setup();
        //Driver object to call all available methods
        WebDriver driver = new ChromeDriver();
        //make the page maximized when it opens
        driver.manage().window().maximize();
        //use get method to go to webpage; driver object opens the page
        driver.get("http://qa2.vytrack.com/user/login");
        //implicit wait allows program to load everything if not throw exception
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //stay on page for 3 seconds, use Thread.sleep method
        //don't forget to use try/catch or "throws Exception after method signature
        Thread.sleep(2000);

        //WebElements made; UserNameBox, passwordBox and submitButton
        WebElement UserNameBox = driver.findElement(By.id("prependedInput"));
        WebElement passwordBox = driver.findElement(By.id("prependedInput2"));
        WebElement submitButton = driver.findElement(By.id("_submit"));

        //first let's type in the user name in the "Username" field
        UserNameBox.sendKeys("user40");
        //second let's type in the password in the "Password" field
        passwordBox.sendKeys("UserUser123");
        //wait on the page for another two seconds
        Thread.sleep(2000);


        //click on "LOG IN" button to access vyTrack modules
        submitButton.submit();


        // Create if else condition to check whether the title of web page is correct
        if (driver.getTitle().contains("Dashboard")) {   //Print out if title equals expected result: Dashboard
            System.out.println("passed\nExpected: " + driver.getTitle());
        }
        //if the title is not correct, use else
        else {
            //create a text if login is unsuccessful
            String failed = "Invalid user name or password.";
            //print out the failed message that was stored above
            System.out.println(failed);
            //print out the actual result that failed the verification of title condition
            System.out.println("Actual: " + driver.getTitle());

        }

        //exit the program as soon as condition is met.
        driver.close();
        //if there are multiple tabs opened, use quit method to exit all.
        //  driver.quit();

    }

}
