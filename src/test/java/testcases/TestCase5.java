package testcases;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

public class TestCase5 {

    @Test
    public void logIn() {
        System.out.println("Login procedure has successfully completed");
    }

    @Test
    public void userRegistration() {
        Assert.fail("The user registration has filed");
    }

    @Test
    public void testSkip() {
        throw new SkipException("The test has skipped");
    }
}
