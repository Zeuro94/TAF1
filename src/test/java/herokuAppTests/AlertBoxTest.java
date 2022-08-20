package herokuAppTests;

import com.aventstack.extentreports.Status;
import implementation.ElementControl;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AlertPage;

public class AlertBoxTest extends Base {
    AlertPage alertPage;
    ElementControl elementControl;

    @Test
    public void verifyAlert(){
        reportUtils.createTestCare(new Throwable().getStackTrace()[0].getMethodName());
        reportUtils.addTestLog(Status.INFO,"Performing log");
        alertPage = new AlertPage(driver);
        elementControl = new ElementControl( driver );
        Assert.assertFalse(alertPage.isAlertPresent());
        alertPage.clickOnAlertBox();
        alertPage.isAlertPresent();
        Assert.assertTrue(alertPage.isAlertPresent());
        elementControl.okAlert();

    }
}
