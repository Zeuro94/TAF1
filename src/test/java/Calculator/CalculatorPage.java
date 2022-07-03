package Calculator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class CalculatorPage {
    public static By answer = By.cssSelector("span#answer");
    static WebDriver driver;
    private final By inputNumber1 = By.cssSelector("input#number1");
    private final By inputNumber2 = By.cssSelector("input#number2");
    private final By selectFunction = By.cssSelector("select#function");
    private final By calculate = By.cssSelector("input#calculate");


    public CalculatorPage(WebDriver driver) {
        CalculatorPage.driver = driver;
    }

    protected void setInputNumber1(String inputNumber1) {
        driver.findElement(this.inputNumber1).sendKeys(inputNumber1);
    }

    public void setInputNumber2(String inputNumber2) {
        driver.findElement(this.inputNumber2).sendKeys(inputNumber2);
    }

    public void selectOperator(String operator) {
        WebElement p = driver.findElement(selectFunction);
        Select sel = new Select( p );
        switch (operator) {
            case "plus" -> {
                sel.selectByVisibleText("plus");
                calculate();
            }
            case "minus" -> {
                sel.selectByVisibleText("minus");
                calculate();
            }
            case "times" -> {
                sel.selectByVisibleText("times");
                calculate();
            }
            case "divide" -> {
                sel.selectByVisibleText("divide");
                calculate();
            }
        }
    }

    public void calculate() {
        driver.findElement(calculate).click();
    }

}
