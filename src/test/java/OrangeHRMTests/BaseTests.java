package OrangeHRMTests;

import implementation.CommonDriver;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import pages.LoginPage;

public class BaseTests {

    CommonDriver cmnDriver;
    String url;
    WebDriver driver;
    LoginPage loginPage;
    @BeforeClass
    public void setUp() throws Exception {
        url = "https://opensource-demo.orangehrmlive.com/index.php/auth/login";
        cmnDriver = new CommonDriver("chrome");
        driver = cmnDriver.getDriver();
        loginPage = new LoginPage( driver );
        cmnDriver.navigateTo(url);
    }

    @AfterClass
    public void tearDown() {
        cmnDriver.closeBrowser();
    }
}
