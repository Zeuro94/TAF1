package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ReportUtils {

    ExtentHtmlReporter htmlReporter;
    ExtentReports extentReports;
    ExtentTest extentTest;

    public ReportUtils(String htmlReportFilename){
        htmlReportFilename = htmlReportFilename.trim();

        htmlReporter = new ExtentHtmlReporter(htmlReportFilename);
        extentReports = new ExtentReports();
        extentReports.attachReporter(htmlReporter);
    }

    public void createTestCare(String testCaseName){
        extentTest = extentReports.createTest(testCaseName);
    }

    public void addTestLog(Status status, String comment){
        extentTest.log(status, comment);
    }

    public void flushReport(){
        extentReports.flush();
    }
}
