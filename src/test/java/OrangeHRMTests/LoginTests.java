package OrangeHRMTests;

import com.aventstack.extentreports.Status;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LoginTests extends BaseTests {

    @Parameters({"usernameValid", "passwordValid"})
    @Test
    public void verifyLoginWithCorrectCredentials(String username, String password) {
        reportUtils.createTestCare("Verify Login With Correct Credentials");
        reportUtils.addTestLog(Status.INFO, "Performing log");
        loginPage.login(username, password);
        String expectedTitle = "aaOrangeHRM";
        String actualTitle = cmnDriver.getTitleOfThePage();
        reportUtils.addTestLog(Status.INFO, "Comparing expected and actual title");
        Assert.assertEquals(actualTitle, expectedTitle);
    }

    @Parameters({"usernameInvalid", "passwordValid"})
    @Test
    public void verifyLoginWithWrongCredentials(String username, String password) {
        reportUtils.createTestCare("Verify Login With Wrong Credentials");
        reportUtils.addTestLog(Status.INFO, "Performing log");
        loginPage.login(username, password);
        reportUtils.addTestLog(Status.INFO, "Comparing expected and actual title");
        Assert.assertTrue(elementControl.isDisplayed(loginPage.invalidCredentials));
    }
}
