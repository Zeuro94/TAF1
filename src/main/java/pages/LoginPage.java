package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.HashMap;

public class LoginPage extends BasePage {
    @FindBy(css = "input[placeholder='Username']")
    private WebElement userId;

    @FindBy(css = "input[placeholder='Password']")
    private WebElement userPassword;

    @FindBy(css = "button[type='submit']")
    private WebElement btnLogin;

    @FindBy(css = ".oxd-text.oxd-text--p.oxd-alert-content-text")
    public WebElement invalidCredentials;

    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void login(String username, String password) {
        elementControl.setText((WebElement)loginPageElements().get("userId"), username);
        elementControl.setText((WebElement)loginPageElements().get("userPassword"), password);
        elementControl.clickElement((WebElement)loginPageElements().get("btnLogin"));
    }

    public HashMap loginPageElements() {
        HashMap<String, WebElement> hashMap = new HashMap<>();
        hashMap.put("userId", driver.findElement(By.cssSelector("input[placeholder='Username']")));
        hashMap.put("userPassword", driver.findElement(By.cssSelector("input[placeholder='Password']")));
        hashMap.put("btnLogin", driver.findElement(By.cssSelector("button[type='submit']")));
       // hashMap.put("invalidCredentials", driver.findElement(By.cssSelector(".oxd-text.oxd-text--p.oxd-alert-content-text")));

        return hashMap;
    }

    public String getTitle(){
        return elementControl.getTitleOfThePage();
    }
}