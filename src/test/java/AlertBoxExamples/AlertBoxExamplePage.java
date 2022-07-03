package AlertBoxExamples;


import BrowserManager.BrowserManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;

public class AlertBoxExamplePage {
    WebDriver driver;
    By alertBox = By.cssSelector( "input#alertexamples.styled-click-button" );
    By confirmBox = By.cssSelector( "input#confirmexample.styled-click-button" );

    By confirmReturn = By.cssSelector( "p#confirmreturn" );

    public AlertBoxExamplePage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickAlertBox() {
        driver.findElement( alertBox ).click();
    }

    public void selectOkFromAlertBox() {
        driver.switchTo().alert().accept();
    }

    public String getMessageFromAlertBox() {
        return driver.switchTo().alert().getText();
    }

    public void clickConfirmBox() {
        driver.findElement( confirmBox ).click();
    }

    public void selectOkFromConfirmBox() {
        driver.switchTo().alert().accept();
    }

    public void selectCancelFromConfirmBox() {
        driver.switchTo().alert().dismiss();
    }

    public String getMessageFromConfirmBox() {
        return driver.switchTo().alert().getText();
    }

    public boolean getConfirmBox(boolean confirmBox) {
        if (driver.findElement( confirmReturn ).getText().equals( "true" )){
            return true;}


        if (driver.findElement( confirmReturn ).getText().equals( "false" ))
        { return false;}

        return confirmBox;
    }
}

