package pages;

import implementation.ElementControl;
import org.openqa.selenium.WebDriver;

public class BasePage {
   final WebDriver driver;
    final ElementControl elementControl;
    public BasePage(WebDriver driver) {
        this.driver = driver;
        elementControl = new ElementControl(driver);
    }

}
