package parameterization;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.Date;

public class TestParameterizationXML {

    @Parameters({"browser", "env"})
    @Test
    public void browserSetUp(String browser, String env) throws InterruptedException {
        System.out.println("browser: " + browser + "-----" + "environmental: " + env + " date: " + new Date().toString());
        Thread.sleep(2000);
    }
}
