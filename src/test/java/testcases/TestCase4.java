package testcases;

import org.testng.annotations.Test;
import parameterization.TestParameterizationExcel;

import java.util.Hashtable;

public class TestCase4 {
    @Test(dataProviderClass = TestParameterizationExcel.class, dataProvider = "testData")
    public void userTest(Hashtable<String, String> data) {
        System.out.println(data.get("user") + "---" + data.get("password") + "---" + data.get("is_correct") + "---" + data.get("age") + "---" + data.get("gender") + "---");
    }

    @Test(dataProviderClass = TestParameterizationExcel.class, dataProvider = "testData")
    public void loginTest(Hashtable<String, String> data) {
        System.out.println(data.get("user") + "---" + data.get("password") + "---" + data.get("email"));
    }
}
