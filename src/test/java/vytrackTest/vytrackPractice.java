package vytrackTest;

import com.cybertek.Utilities.ConfigurationReader;
import com.cybertek.Utilities.TestBase;
import com.cybertek.Utilities.VYTrackUtils;
import com.cybertek.pages.VYTrackProject.CalendarEventsPage;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class vytrackPractice extends TestBase {
/*
Daily repeat option, Repeat every
Log in as Valid user
Go to Activities -> Calendar Events
Click on create new calendar event
Click on Repeat checkbox
Verify that Daily is selected by default
Verify day(s) checkbox is selected and default value is 1
Verify summary says Daily every 1 day
  Check the weekday checkbox
Verify that days input now disabled
Verify summary says Daily every weekday

Daily repeat option, Repeat every, default values
Log in as Valid user
Go to Activities -> Calendar Events
Click on create new calendar event
Click on Repeat checkbox
Verify that Daily is selected by default
Verify day(s) checkbox is selected and default value is 1
Verify summary says Daily every 1 day
 */


    // Calendar of Events
    CalendarEventsPage calendarPage = new CalendarEventsPage();


    @Test
    public void DailyRepeatOptionRepeatEveryTest() {
        //we are reading storemanagerUsername from .properties file
        String username = ConfigurationReader.getProperty("storemanagerUsername");
        //we are reading storemanagerPassword from .properties file
        String password = ConfigurationReader.getProperty("storemanagerPassword");
        VYTrackUtils.login(driver, username, password); //login
        //go to Calendar Events
        VYTrackUtils.navigateToModule(driver, "Activities", "Calendar Events");
        VYTrackUtils.waitUntilLoaderScreenDisappear(driver);
        driver.findElement(By.cssSelector(calendarPage.createCalendarEventBtnLocator)).click();

        VYTrackUtils.waitUntilLoaderScreenDisappear(driver);
        driver.findElement(By.cssSelector(calendarPage.repeatCheckBoxLocator)).click();
        VYTrackUtils.waitUntilLoaderScreenDisappear(driver);
        //SeleniumUtils.clickWithWait(driver, 5 );

    }


}
