package OrangeHRMTests;

import com.aventstack.extentreports.Status;
import implementation.CommonDriver;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pages.LoginPage;
import utils.ConfigUtils;
import utils.ReportUtils;
import utils.ScreenshotUtils;

import java.io.IOException;
import java.util.Properties;

public class BaseTests {

    CommonDriver cmnDriver;
    String url;
    WebDriver driver;
    LoginPage loginPage;
    String configFileName;
    String currentWorkingDirectory;
    Properties configProperty;
    String reportFileName;
    ReportUtils reportUtils;
    ScreenshotUtils screenshot;

    @BeforeSuite
    public void preSetup() throws IOException {
        currentWorkingDirectory = System.getProperty("user.dir");
        configFileName = currentWorkingDirectory + "/config/config.properties";
        reportFileName = currentWorkingDirectory + "/reports/OrangeHRMTestReport.html";
        configProperty = ConfigUtils.readProperties(configFileName);
        reportUtils = new ReportUtils(reportFileName);
    }

    @BeforeClass
    public void setUp() throws Exception {
        url = configProperty.getProperty("baseUrl");
        String browserType = configProperty.getProperty("browserType");
        cmnDriver = new CommonDriver(browserType);
        driver = cmnDriver.getDriver();
        loginPage = new LoginPage(driver);
        screenshot = new ScreenshotUtils(driver);
        cmnDriver.navigateTo(url);
    }

    @AfterClass
    public void tearDown() {
        cmnDriver.closeBrowser();
    }
    @AfterMethod
    public void postTestAction(ITestResult result) throws Exception {
        String testCaseName = result.getName();
        long executionTime = System.currentTimeMillis();
        String screenshotFilename = currentWorkingDirectory + "/screenshots/" + testCaseName + executionTime + ".jpeg";
        if(result.getStatus() == ITestResult.FAILURE){
            reportUtils.addTestLog(Status.FAIL, "One or more steps failed");
            screenshot.saveScreenshot(screenshotFilename);
        }
    }
    @AfterSuite
    public void clearReport(){
        reportUtils.flushReport();
    }
}

