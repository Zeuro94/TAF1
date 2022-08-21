package pages;

import implementation.ElementControl;
import org.openqa.selenium.WebDriver;

import java.util.logging.Logger;

public class BasePage {
    final WebDriver driver;
    final ElementControl elementControl;
    final Logger logger;
    public BasePage(WebDriver driver) {
        this.driver = driver;
        elementControl = new ElementControl(driver);
        this.logger= Logger.getLogger(this.getClass().getName());
    }

}
