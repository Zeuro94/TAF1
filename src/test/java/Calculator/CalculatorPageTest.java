package Calculator;

import BrowserManager.BrowserManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CalculatorPageTest {
    WebDriver driver = BrowserManager.getChromeDriver();
    CalculatorPage calculatorPage = new CalculatorPage( driver );

    @BeforeTest
    public void setup(){
        driver.get( "https://testpages.herokuapp.com/calculate.php" );
    }

    @Test(priority = 0)
    public void sumCalculator(){
        calculatorPage.setInputNumber1("30");
        calculatorPage.setInputNumber2("30");
        calculatorPage.selectPlus();
        driver.findElement( By.cssSelector( "input#calculate" ) ).click();
        Assert.assertTrue( driver.findElement( By.cssSelector( "span#answer" ) ).getText().contains( "60" ) );
    }
    @Test(priority = 1)
    public void minusCalculator() throws InterruptedException {

        calculatorPage.selectMinus();
        driver.findElement( By.cssSelector( "input#calculate" ) ).click();
        Assert.assertTrue( driver.findElement( By.cssSelector( "span#answer" ) ).getText().contains( "0" ) );

    }
}
