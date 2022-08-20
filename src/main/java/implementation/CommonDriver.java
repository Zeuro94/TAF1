package implementation;
import org.openqa.selenium.WebDriver;

import javax.naming.NameNotFoundException;
import java.time.Duration;

public class CommonDriver {
    private final WebDriver driver;

    public long setPageLoadTimer(int pageLoadTimer) {
        return pageLoadTimer;
    }

    public long setElementDetectionTimeout(int elementDetectionTimeout) {
        return elementDetectionTimeout;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public CommonDriver(String browserType) throws NameNotFoundException {

        if (browserType.equalsIgnoreCase("chrome")){
            driver = BrowserManager.getChromeDriver();
        } else if (browserType.equalsIgnoreCase("firefox")){
            driver = BrowserManager.getFirefoxDriver();
        } else if (browserType.equalsIgnoreCase("edge")){
            driver = BrowserManager.getEdgeDriver();
        } else {
            throw new NameNotFoundException("Invalid browser type" + browserType);
        }

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
    }

    public void navigateTo(String url) {
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(setPageLoadTimer(10)));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(setElementDetectionTimeout(10)));
        driver.get(url);
    }

    public void closeBrowser(){
        driver.close();
        driver.quit();
    }

}
