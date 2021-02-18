package testcases;

import org.testng.SkipException;
import org.testng.annotations.*;
import utility.BaseTest;

public class TestCase1 extends BaseTest {

    @BeforeTest
    public void CreatingDbConnection() {
        System.out.println("Creating DB Connection");
    }

    @AfterTest
    public void ClosingDBConnection() {
        System.out.println("Closing DB Connection");
    }

    @BeforeMethod
    public void LaunchBrowser() {
        System.out.println("Launching Browser");
    }

    @AfterMethod
    public void CloseBrowser() {
        System.out.println("Closing Browser");
    }

    @Test(priority = 2, groups = "functional")
    public void doLogin() {
        System.out.println("Executing login test");
    }

    @Test(priority = 1, groups = "functional")
    public void doUserRegistration() {
        System.out.println("Executing User Registration");
    }

    @Test(priority = 3)
    public void isSkip() {
        if (false)
            throw new SkipException("Skipping the test");
    }
}
