package listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import utility.ExtentReportManager;

import java.util.Arrays;
import java.util.Date;

public class Listener implements ITestListener {

    public static ThreadLocal<ExtentTest> testReport = new ThreadLocal<ExtentTest>();
    static Date date = new Date();
    static String fileName = "extentReport_" + date.toString().replace(":", "_").replace(" ", "_") + ".html";
    private static ExtentReports extentReport = ExtentReportManager.creatInstanceOfExtentReport(System.getProperty("user.dir") + "\\reports\\" + fileName);

    @Override
    public void onTestStart(ITestResult result) {
        ExtentTest test = extentReport.createTest(result.getTestClass().getName() + "   @TestCase: " + result.getMethod().getMethodName());
        testReport.set(test);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        String methodName = result.getMethod().getMethodName();
        String logText = "<b>" + "TEST CASE:- " + methodName.toUpperCase() + " PASSED" + "</b>";
        Markup markup = MarkupHelper.createLabel(logText, ExtentColor.GREEN);
        testReport.get().pass(markup);
    }

    @Override
    public void onTestFailure(ITestResult result) {
        String exceptionMessage = Arrays.toString(result.getThrowable().getStackTrace());
        testReport.get().fail("<details>" + "<summary>" + "<b>" + "<font color=" + "red>" + "Exception Occurred: Click to see"
                + "</font>" + "</b>" + "</summary>" + exceptionMessage.replaceAll(",", "<br>") + "</details>" + " \n");
        String failureLog = "TEST CASE FAILED";
        Markup markup = MarkupHelper.createLabel(failureLog, ExtentColor.RED);
        testReport.get().log(Status.FAIL, markup);
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        String methodName = result.getMethod().getMethodName();
        String logText = "<b>" + "Test Case:- " + methodName + " Skipped" + "</b>";
        Markup markup = MarkupHelper.createLabel(logText, ExtentColor.YELLOW);
        testReport.get().skip(markup);
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
        if (extentReport != null) {
            extentReport.flush();
        }
    }
}
