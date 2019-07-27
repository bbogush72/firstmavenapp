package com.cybertek.BriteERPproject;

import com.cybertek.Utilities.BriteTestBase;
import com.cybertek.Utilities.Driver;
import com.cybertek.pages.VYTrackProject.BriteERP_LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class BriteErpRevenue extends BriteTestBase {
    /**
     * User story: The system should display the correct information
     * for each opportunity on the view list page and the pivot table
     * <p>
     * Acceptance Criteria: Verify that second opportunity' Expected Revenue value
     * on the pivot board should be the same as Expected
     * Revenue column value on the list board.
     * user1: eventscrmmanager36@info.com
     * user2: eventscrmmanager37@info.com"
     * eventscrmmanager
     */
    BriteERP_LoginPage login = new BriteERP_LoginPage();
    BriteERP_Paths path = new BriteERP_Paths();

    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 5);

    @Test
    public void ListView() throws IOException {
        BriteERP_LoginPage.login();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='o_thread_title']")));
        Assert.assertEquals(driver.getTitle(), "#Inbox - Odoo");

    }

}
