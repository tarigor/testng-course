package utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportManager {

    private static ExtentReports extentReport;

    public static ExtentReports creatInstanceOfExtentReport(String fileName) {

        ExtentSparkReporter extentSparkReporter = new ExtentSparkReporter(fileName);

        extentSparkReporter.config().setTheme(Theme.STANDARD);
        extentSparkReporter.config().setDocumentTitle(fileName);
        extentSparkReporter.config().setEncoding("utf-8");
        extentSparkReporter.config().setReportName(fileName);

        extentReport = new ExtentReports();
        extentReport.attachReporter(extentSparkReporter);
        extentReport.setSystemInfo("Automation Tester", "Igor Taren");
        extentReport.setSystemInfo("Organization", "EPAM");
        extentReport.setSystemInfo("Build No", "EPAM-1234");

        return extentReport;
    }
}
