package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {
    @FindBy(id = "txtUsername")
    private WebElement userId;

    @FindBy(id = "txtPassword")
    private WebElement userPassword;

    @FindBy(id = "btnLogin")
    private WebElement btnLogin;

    @FindBy(id = "spanMessage")
    public WebElement invalidCredentials;

    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void login(String username, String password) {
        elementControl.setText(userId, username);
        elementControl.setText(userPassword, password);
        elementControl.clickElement(btnLogin);
    }
}