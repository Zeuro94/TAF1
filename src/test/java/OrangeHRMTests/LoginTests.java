package OrangeHRMTests;

import com.aventstack.extentreports.Status;
import implementation.ElementControl;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.lang.reflect.Field;

public class LoginTests extends BaseTests {

    ElementControl elementControl;
    @Parameters({"usernameValid", "passwordValid"})
    @Test
    public void verifyLoginWithCorrectCredentials(String username, String password) {
        reportUtils.createTestCare("Verify Login With Correct Credentials");
        reportUtils.addTestLog(Status.INFO, "Performing log");
        loginPage.login(username, password);
        String expectedTitle = "OrangeHRM";
        String actualTitle = cmnDriver.getTitleOfThePage();
        reportUtils.addTestLog(Status.INFO, "Comparing expected and actual title");
        Assert.assertEquals(actualTitle, expectedTitle);
    }

    @Parameters({"usernameInvalid", "passwordValid"})
    @Test
    public void verifyLoginWithWrongCredentials(String username, String password) throws NoSuchFieldException, IllegalAccessException {
        elementControl = new ElementControl(driver);
        reportUtils.createTestCare("Verify Login With Wrong Credentials");
        reportUtils.addTestLog(Status.INFO, "Performing log");
        loginPage.login(username, password);
        String expectedMessage = "Invalid credentials";
        Field field = loginPage.getClass().getDeclaredField("invalidCredentials");
        field.setAccessible(true);
        Object value = field.get(loginPage);
        String actualMessage = elementControl.getTextFromElement( (WebElement) value );
        reportUtils.addTestLog(Status.INFO, "Comparing expected and actual message for Invalid credentials");
        Assert.assertEquals(actualMessage,expectedMessage);
    }
}
