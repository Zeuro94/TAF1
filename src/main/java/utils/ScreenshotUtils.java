package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;


public class ScreenshotUtils {
    private final TakesScreenshot camera;

    public ScreenshotUtils(WebDriver driver){
        camera =(TakesScreenshot) driver;
    }

    public void saveScreenshot(String filename) {



        filename = filename.trim();
        File imgFile;
        File tmpFile;

        imgFile = new File(filename);

        tmpFile = camera.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.moveFile(tmpFile, imgFile);
        }
        catch (IOException existsException){
            existsException.getStackTrace();
        }
    }
}
