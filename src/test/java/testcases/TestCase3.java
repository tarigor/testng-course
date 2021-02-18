package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import utility.BaseTest;

public class TestCase3 extends BaseTest {

    @Test(priority = 1, groups = "functional")
    public void doUserRegistration() {
        System.out.println("Executing User Registration");
        Assert.fail("User not registered successfully");
    }

    @Test(priority = 2, dependsOnMethods = "doUserRegistration", alwaysRun = true, groups = "functional")
    public void doLogin() {
        System.out.println("Executing login test");
    }

    @Test(priority = 3)
    public void thirdTest() {
        System.out.println("Executing third test");
    }

    @Test(priority = 4)
    public void fourthTest() {
        System.out.println("Executing fourth test");
    }
}
