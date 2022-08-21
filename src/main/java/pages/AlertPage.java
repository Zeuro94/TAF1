package pages;

import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AlertPage extends BasePage {

    public AlertPage(WebDriver driver) {
        super( driver );
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "alertexamples")
    private WebElement showAlertBox;

    @FindBy(id ="confirmexample")
    private WebElement showConfirmBox;

    @FindBy(id = "promptexample")
    private WebElement showPromptBox;

    public void clickOnAlertBox(){
        elementControl.clickElement(showAlertBox);
    }

    public boolean isAlertPresent(){
        try {
            driver.switchTo().alert();
            return true;
        }
        catch (NoAlertPresentException e){
            return false;
        }
    }
}
