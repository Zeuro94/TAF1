package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.HashMap;
import java.util.Map;

public class LoginPage extends BasePage {

    @FindBy(css = "input[placeholder='Username']")
    private WebElement userId;

    @FindBy(css = "input[placeholder='Password']")
    private WebElement userPassword;

    @FindBy(css = "button[type='submit']")
    public WebElement btnLogin;

    @FindBy(css = ".oxd-text.oxd-text--p.oxd-alert-content-text")
    public WebElement invalidCredentials;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Step("Test runner use the following credentials {0} {1}")
    public void login(String username, String password) {
        elementControl.setText(loginPageElements().get("userId"), username);
        logger.info("Username entered");
        elementControl.setText(loginPageElements().get("userPassword"), password);
        elementControl.clickElement(loginPageElements().get("btnLogin"));
    }

    @Step
    public Map<String, WebElement> loginPageElements() {
        HashMap<String, WebElement> hashMap = new HashMap<>();
        hashMap.put("userId", driver.findElement(By.cssSelector("input[placeholder='Username']")));
        hashMap.put("userPassword", driver.findElement(By.cssSelector("input[placeholder='Password']")));
        hashMap.put("btnLogin", driver.findElement(By.cssSelector("button[type='submit']")));

        return hashMap;

    }

    @Step("Get title")
    public String getTitle(){
        return elementControl.getTitleOfThePage();
    }
}