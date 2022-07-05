package OrangeHRMTests;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LoginTests extends BaseTests {

    @Parameters({"username", "password"})
    @Test
    public void verifyLoginWithCorrectCredentials(String username, String password) {
        loginPage.login( username, password );
        String expectedTitle = "OrangeHRM";
        String actualTitle = cmnDriver.getTitleOfThePage();
        Assert.assertEquals( actualTitle, expectedTitle );
    }
}
