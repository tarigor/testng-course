package parameterization;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Date;

public class TestParameterizationParallel {

    @Test(dataProvider = "getData")
    public void getBrowser(String browser) throws InterruptedException {
        System.out.println("browser: " + browser + "-----" + " date: " + new Date().toString());
        Thread.sleep(2000);
    }

    @DataProvider(parallel = true)
    public Object[][] getData() {
        Object[][] data = new Object[2][1];
        data[0][0] = "firefox";
        data[1][0] = "chrome";
        return data;
    }
}
