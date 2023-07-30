package implementation;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ElementControl {
    final WebDriver driver;

    public ElementControl(WebDriver driver) {
        this.driver = driver;
    }

    @Step
    public void clickElement(WebElement element) {
       element.click();
    }

    public void clear(WebElement element) {
        element.clear();
    }

    @Step
    public void setText(WebElement element, String text) {
        element.sendKeys(text);
    }

    public boolean isEnabled(WebElement element) {
        return element.isEnabled();
    }

    @Step
    public boolean isDisplayed(WebElement element) {
        return element.isDisplayed();
    }

    @Step
    public void okAlert() {
        driver.switchTo().alert().accept();
    }

    public void cancelAlert() {
        driver.switchTo().alert().dismiss();
    }

    public String getTextFromAlert() {
        return driver.switchTo().alert().getText();
    }

    public String getTextFromElement(WebElement element){
        return element.getText();
    }

    @Step
    public String getTitleOfThePage(){
        return driver.getTitle();
    }
}
