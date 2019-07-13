package VyTrackProject;


import Utilities.BrowserFactory;
import Utilities.SeleniumUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class LogInVyTrack {

    //static Webdriver driver; to access in all methods
    static WebDriver driver = BrowserFactory.getDriver("chrome");

    public static void main(String[] args) throws Exception {
        //setup webdriver manager to access google chrome
        //WebDriverManager.chromedriver().setup();
        // WebDriver driver = BrowserFactory.getDriver("chrome");
        //Driver object to call all available methods
        // WebDriver driver = new ChromeDriver();
        //make the page maximized when it opens

        testLogin();

        testLogout();
    }


    public static void testLogin() throws Exception {
        driver.manage().window().maximize();
        //use get method to go to webpage; driver object opens the page
        driver.get("http://qa2.vytrack.com/user/login");
        //implicit wait 10 seconds allows program to load everything and keep away  throw exception
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //driver.manage().timeouts().explicitlyWait(10, TimeUnit.SECONDS);

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
        if (driver.getTitle().equalsIgnoreCase("dashboard")) {   //Print out if title equals expected result: Dashboard
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
        //wait on the page for another two seconds
        Thread.sleep(2000);
        //exit the program as soon as condition is met.
        //driver.close();
        //if there are multiple tabs opened, use quit method to exit all.
        //  driver.quit();

    }

    public static void testLogout() throws Exception {
        //driver.get("http://qa2.vytrack.com/user/login");
        //implicit wait 10 seconds allows program to load everything and keep away  throw exception
        // driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //driver.findElement(By.id("wooden_spoon")).click();

        driver.findElement(By.className("dropdown-menu")).click();
        //  driver.findElement(By.className("no-hash")).click();
        driver.findElement(By.xpath("//a[@href='/user/logout']")).click();
        //driver.findElement(By.xpath("//id[@id='user-menu'")).click();

        ////id[@id='user-menu'
        Thread.sleep(2000);

        String expected = "Welcome to the Secure Area. When you are done click logout below.";
        String actual = driver.findElement(By.className("subheader")).getText();
        SeleniumUtils.verifyEquals(expected, actual);

        Thread.sleep(2000);
        driver.close();

    }

}
