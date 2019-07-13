package practice.CyberTek.day8;

import org.testng.annotations.Test;

public class TestPLTNG {
    /**
     * --> TestPLT data: array1{1,2,1453,3};
     * --> assertEquals(findMax(array1), 1453) if true, unit test is passed
     * <p>
     * assertTrue(true);
     * assertTrue(1==1);
     * assertTrue(element.isDisplayed());
     * <p>
     * --> TestPLTNG let's you to write unit test and do assertions.
     * --> helps generate reports.
     * <p>
     * --> use testNG to write, organize, assert and run selenium scripts
     * <p>
     * --> TestPLTNG assertions are mechanisms for verifying/asserting
     * <p>
     * --> Assert class provides assertions
     * <p>
     * assertFalse(), assertTrue().
     * ==> How can I access them? Just make sure you have dependecies for the testNG
     * Then
     * <p>
     * Annotations are cool: You use them on top of the method header. Syntax is @NameOfMethod
     * 1- @BeforeMethod will run before the test method
     * <p>
     * 2- @TestPLT will run after beforeMethod.
     * <p>
     * 3- @AfterMethod will run after test method
     * <p>
     * prioritize methods like @TestPLT(priority =1), @TestPLT(priority=2)
     * lower the number higher the priority
     * default value is set to 0;
     * priority maintained by alphabetic order.
     */

    @Test
    public int findMax(int[] array) {
        int max = array[0];
        for (int i : array) {
            if (i > max) max = i;

        }
        return max;
    }

}