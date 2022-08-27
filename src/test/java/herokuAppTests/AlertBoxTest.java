package herokuAppTests;

import com.aventstack.extentreports.Status;
import implementation.ElementControl;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AlertPage;

import java.util.logging.Logger;

public class AlertBoxTest extends Base {
    AlertPage alertPage;
    ElementControl elementControl;
    Logger logger;

    @Test
    public void verifyAlert(){
        reportUtils.createTestCare(new Throwable().getStackTrace()[0].getMethodName());
        reportUtils.addTestLog(Status.INFO,"Performing log");
        alertPage = new AlertPage(driver);
        elementControl = new ElementControl(driver);
        Assert.assertFalse(alertPage.isAlertPresent());
        alertPage.clickOnAlertBox();
        Assert.assertTrue(alertPage.isAlertPresent());
        elementControl.okAlert();
    }
}
