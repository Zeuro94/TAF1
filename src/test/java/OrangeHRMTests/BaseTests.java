package OrangeHRMTests;

import implementation.CommonDriver;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import pages.LoginPage;
import utils.ConfigUtils;
import utils.ReportUtils;

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
        cmnDriver.navigateTo(url);
    }

    @AfterClass
    public void tearDown() {
        cmnDriver.closeBrowser();
    }
    @AfterSuite
    public void clearReport(){
        reportUtils.flushReport();
    }
}

