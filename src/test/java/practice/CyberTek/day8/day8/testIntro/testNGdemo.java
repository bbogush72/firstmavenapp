package practice.CyberTek.day8.day8.testIntro;

import org.testng.Assert;
import org.testng.annotations.Test;

public class testNGdemo {

    @Test(priority = 1)
    public void test1() {
        String a = "A";
        String b = "B";
        Assert.assertEquals(a, b);
    }

    @Test(priority = 2)
    public void test2() {
        String str1 = "apple";
        String str2 = "orange";
        Assert.assertEquals(str1, str2);
    }

    @Test(priority = 3)
    public void test3() {
        String str1 = "ADAF";
        String str2 = "AAA";
        Assert.assertTrue(str1.contains(str2));

    }

    @Test
    public void test4() {
        Assert.assertFalse(false);
    }
}
