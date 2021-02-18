package listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class Listener implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {

    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("The method " + result.getName() + " has successfully finished");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        String path = "E:\\screenshots\\";
        Reporter.log("<a href=\"E:/screenshots/scr.jpg\" target=\"_blank\">Screenshot link</a>");
        Reporter.log("<br>");
        Reporter.log("<a href=\"" + path + "scr.jpg\" target=\"_blank\"><image src=\"https://img.vz.ru/upimg/m10/m1085392.jpg\"></a>");
    }

    @Override
    public void onTestSkipped(ITestResult result) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {

    }

    @Override
    public void onStart(ITestContext context) {

    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("The method " + context.getName() + " has finished");
    }
}
