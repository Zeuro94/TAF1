package OrangeHRMTests;

import com.aventstack.extentreports.Status;
import implementation.CommonDriver;
import implementation.ElementControl;
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
    ElementControl elementControl;

    @BeforeSuite
    public void preSetup() throws IOException {
        currentWorkingDirectory = System.getProperty("user.dir");
        configFileName = currentWorkingDirectory + "/config/config.properties";
        reportFileName = currentWorkingDirectory + "/reports/OrangeHRMTestReport.html";
        configProperty = ConfigUtils.readProperties(configFileName);
        reportUtils = new ReportUtils(reportFileName);
    }

    @BeforeMethod
    public void setUp() throws Exception {
        elementControl = new ElementControl(driver);
        url = configProperty.getProperty("baseUrl");
        String browserType = configProperty.getProperty("browserType");
        cmnDriver = new CommonDriver(browserType);
        driver = cmnDriver.getDriver();
        loginPage = new LoginPage(driver);
        screenshot = new ScreenshotUtils(driver);
        cmnDriver.navigateTo(url);
    }

    @AfterMethod
    public void postTestAction(ITestResult result) throws Exception {
        String testCaseName = result.getName();
        String screenshotFilename = currentWorkingDirectory + "/screenshots/" + testCaseName + ".jpeg";
        if(result.getStatus() == ITestResult.FAILURE){
            reportUtils.addTestLog(Status.FAIL, "Step failed");
            screenshot.saveScreenshot(screenshotFilename);
        }
    }

    @AfterMethod
    public void tearDown() {
        cmnDriver.closeBrowser();
    }
    @AfterSuite
    public void clearReport(){
        reportUtils.flushReport();
    }
}

