package Tests;

import AlertBoxExamples.AlertBoxExamplePage;
import BrowserManager.BrowserManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class AlertBoxExamplePageTest {
    WebDriver driver = BrowserManager.getChromeDriver();
    AlertBoxExamplePage alertBoxExamplePage = new AlertBoxExamplePage( driver );


    @BeforeTest
    public void setup() {

        driver.get( "https://testpages.herokuapp.com/styled/alerts/alert-test.html" );
    }

    @Test
    public void testAlertBox() {
        alertBoxExamplePage.clickAlertBox();
        alertBoxExamplePage.getMessageFromAlertBox();
        Assert.assertTrue( alertBoxExamplePage.getMessageFromAlertBox().contains( "I am an alert box!" ) );
        alertBoxExamplePage.selectOkFromAlertBox();
    }

    @Test
    public void testConfirmBoxPositive() {
        alertBoxExamplePage.clickConfirmBox();
        alertBoxExamplePage.getMessageFromConfirmBox();
        Assert.assertTrue( alertBoxExamplePage.getMessageFromConfirmBox().contains( "I am a confirm alert" ));
        alertBoxExamplePage.selectOkFromConfirmBox();
        Assert.assertTrue( alertBoxExamplePage.getConfirmBox( true ) );
    }
    @Test
    public void testConfirmBoxNegative() {
        alertBoxExamplePage.clickConfirmBox();
        alertBoxExamplePage.getMessageFromConfirmBox();
        Assert.assertTrue( alertBoxExamplePage.getMessageFromConfirmBox().contains( "I am a confirm alert" ));
        alertBoxExamplePage.selectCancelFromConfirmBox();
        Assert.assertFalse( alertBoxExamplePage.getConfirmBox( false ));
    }
    @AfterTest
    public void afterTest() {
        driver.close();
        driver.quit();
    }

}
