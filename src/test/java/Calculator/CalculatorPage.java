package Calculator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class CalculatorPage {
    WebDriver driver;
    By inputNumber1 = By.cssSelector( "input#number1" );
    By inputNumber2 = By.cssSelector( "input#number2" );
    By selectFunction = By.cssSelector( "select#function" );


    public CalculatorPage(WebDriver driver) {
        this.driver = driver;
    }

    public void setInputNumber1(String inputNumber1) {
        driver.findElement( this.inputNumber1 ).sendKeys( inputNumber1 );
    }

    public void setInputNumber2(String inputNumber2) {
        driver.findElement( this.inputNumber2 ).sendKeys( inputNumber2 );
    }

    public void selectPlus() {
        WebElement p = driver.findElement( selectFunction );
       Select sel = new Select(p);
       sel.selectByVisibleText( "plus" );

    }

    public void selectMinus() {
        WebElement p = driver.findElement( selectFunction );
        Select sel = new Select(p);
        sel.selectByVisibleText( "minus" );

    }

}
