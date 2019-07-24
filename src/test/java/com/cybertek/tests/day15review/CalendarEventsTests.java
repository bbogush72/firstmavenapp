package com.cybertek.tests.day15review;


import com.cybertek.Utilities.ConfigurationReader;
import com.cybertek.Utilities.TestBase;
import com.cybertek.Utilities.VYTrackUtils;
import com.cybertek.pages.VYTrackProject.CalendarEventsPage;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class CalendarEventsTests extends TestBase {
    //BeforeMethod is coming from TestBase
    CalendarEventsPage calendarPage = new CalendarEventsPage();

    @Test
    public void verifyRepeatOptions() {
        //we are reading storemanagerUsername from .properties file
        String username = ConfigurationReader.getProperty("storemanagerusername");
        //we are reading storemanagerPassword from .properties file
        String password = ConfigurationReader.getProperty("storemanagerpassword");

        VYTrackUtils.login(driver, username, password); //login

        //go to Calendar Events
        VYTrackUtils.navigateToModule(driver, "Activities", "Calendar Events");

        VYTrackUtils.waitUntilLoaderScreenDisappear(driver);
        driver.findElement(By.cssSelector(calendarPage.createCalendarEventBtnLocator)).click();

        VYTrackUtils.waitUntilLoaderScreenDisappear(driver);
        driver.findElement(By.cssSelector(calendarPage.repeatCheckBoxLocator)).click();

        List<String> expectedOptions = Arrays.asList("Daily", "Weekly", "Monthly", "Yearly");
        List<String> actualOptions = calendarPage.getRepeatOptions();

        //correct way to check if 2 collections are equals
        Assert.assertEquals(actualOptions, expectedOptions);
        System.out.println(expectedOptions);
        System.out.println(actualOptions);
    }

    @Test
    public void DailyRepeatOptionRepeatEveryTest() {

    }


    //AfterMethod id coming from TestBase
}