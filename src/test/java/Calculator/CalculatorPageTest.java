package Calculator;

import BrowserManager.BrowserManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CalculatorPageTest {
    WebDriver driver = BrowserManager.getChromeDriver();
    CalculatorPage calculatorPage = new CalculatorPage(driver);

    @BeforeTest
    public void setup() {
        driver.get("https://testpages.herokuapp.com/calculate.php");
    }

    @Test
    public void sumCalculator() {
        calculatorPage.setInputNumber1("30");
        calculatorPage.setInputNumber2("30");
        calculatorPage.selectOperator("plus");
        Assert.assertTrue( driver.findElement(CalculatorPage.answer).getText().contains("60"));
    }

    @Test(priority = 1)
    public void minusCalculator() {
        calculatorPage.selectOperator("minus");
        Assert.assertTrue( driver.findElement(CalculatorPage.answer).getText().contains("0"));
    }

    @Test(priority = 2)
    public void timesCalculator() {
        calculatorPage.selectOperator( "times" );
        Assert.assertTrue( driver.findElement(CalculatorPage.answer).getText().contains("900"));
    }

    @Test(priority = 3)
    public void divideCalculator() {
        calculatorPage.selectOperator("divide");
        Assert.assertTrue( driver.findElement(CalculatorPage.answer).getText().contains("1"));
    }

    @AfterTest
    public void afterTest() {
        driver.close();
        driver.quit();
    }
}
