package testcases;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utility.BaseTest;

public class TestCase2 extends BaseTest {

    @Test
    public void validateTitles() {

        String expected_title = "yahoo.com";
        String actual_title = "gmail.com";

        SoftAssert softAssert = new SoftAssert();

        System.out.println("test1");
        softAssert.assertEquals(actual_title, expected_title);
        System.out.println("test2");
        softAssert.assertEquals(actual_title, expected_title);
        System.out.println("test3");
        softAssert.assertTrue(false, "element not found");
        System.out.println("test4");
        softAssert.fail("Test failed");
    }
}
