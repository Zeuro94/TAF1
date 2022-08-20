package herokuAppTests;

import com.aventstack.extentreports.Status;
import implementation.CommonDriver;
import implementation.ElementControl;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import pages.LoginPage;
import utils.ConfigUtils;
import utils.ReportUtils;
import utils.ScreenshotUtils;

import java.io.IOException;
import java.util.Properties;

public class Base {

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
        reportFileName = currentWorkingDirectory + "/reports/HerokuApp.html";
        configProperty = ConfigUtils.readProperties(configFileName);
        reportUtils = new ReportUtils(reportFileName);
    }

    @BeforeMethod
    public void setUp() throws Exception {
        elementControl = new ElementControl(driver);
        url = configProperty.getProperty("urlHerokuApp");
        String browserType = configProperty.getProperty("browserType");
        cmnDriver = new CommonDriver(browserType);
        driver = cmnDriver.getDriver();
        loginPage = new LoginPage(driver);
        screenshot = new ScreenshotUtils(driver);
        cmnDriver.navigateTo(url);
     }

    @AfterMethod
    public void postTestAction(ITestResult result) {
        String testCaseName = result.getName();
        String screenshotFilename = currentWorkingDirectory + "/screenshots/" + testCaseName + ".jpeg";
        if(result.getStatus() == ITestResult.FAILURE){
            reportUtils.addTestLog(Status.FAIL, "Step failed");
            screenshot.saveScreenshot(screenshotFilename);
        } else if (result.getStatus() == ITestResult.SUCCESS) {
            reportUtils.addTestLog(Status.PASS, "Test passed");
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

