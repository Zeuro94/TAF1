package orangeHRMTests;

import com.aventstack.extentreports.Status;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LoginTest extends Base {

    @Parameters({"usernameValid", "passwordValid"})
    @Test
    public void verifyLoginWithCorrectCredentials(String username, String password) {
        reportUtils.createTestCare(new Throwable().getStackTrace()[0].getMethodName());
        reportUtils.addTestLog(Status.INFO, "Performing log");
        loginPage.login(username, password);
        reportUtils.addTestLog(Status.INFO, "User is logged");
        String expectedTitle = "OrangeHRM";
        String actualTitle = loginPage.getTitle();
        reportUtils.addTestLog(Status.INFO, "Comparing expected and actual title");
        Assert.assertEquals(actualTitle, expectedTitle);
    }

   @Parameters({"usernameInvalid", "passwordValid"})
    @Test
    public void verifyLoginWithWrongUsername(String username, String password) {
        reportUtils.createTestCare(new Throwable().getStackTrace()[0].getMethodName());
        reportUtils.addTestLog(Status.INFO, "Performing log");
        loginPage.login(username, password);
        reportUtils.addTestLog(Status.INFO, "Comparing expected and actual title");
        Assert.assertTrue(elementControl.isDisplayed(loginPage.invalidCredentials));
    }

    @Parameters({"usernameValid", "passwordInvalid"})
    @Test
    public void verifyLoginWithWrongPassword(String username, String password) {
        reportUtils.createTestCare(new Throwable().getStackTrace()[0].getMethodName());
        reportUtils.addTestLog(Status.INFO, "Performing log");
        loginPage.login(username, password);
        reportUtils.addTestLog(Status.INFO, "Comparing expected and actual title");
        Assert.assertTrue(elementControl.isDisplayed(loginPage.invalidCredentials));
    }
}
