package pages;

import implementation.ElementControl;
import org.awaitility.Awaitility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;
import java.util.concurrent.Callable;
import java.util.logging.Logger;

public class BasePage {
    protected final WebDriver driver;
    protected final ElementControl elementControl;
    final Logger logger;
    public BasePage(WebDriver driver) {
        this.driver = driver;
        elementControl = new ElementControl(driver);
        this.logger= Logger.getLogger(this.getClass().getName());
        PageFactory.initElements(driver, this);
    }

    protected void awaitilityForElement(WebElement element){
        Awaitility.waitAtMost(Duration.ofSeconds(1000)).with().pollInterval(Duration.ofMillis(500)).until(conditionDisplayed(element));
    }

    private Callable<Boolean> conditionDisplayed(WebElement element){
       return element::isDisplayed;
    }
}
