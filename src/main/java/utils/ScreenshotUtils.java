package utils;

import org.apache.commons.io.FileExistsException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;


public class ScreenshotUtils {
    private TakesScreenshot camera;

    public ScreenshotUtils(WebDriver driver){
        camera =(TakesScreenshot) driver;
    }

    public void saveScreenshot(String filename) throws Exception {



        filename = filename.trim();
        File imgFile, tmpFile;

        imgFile = new File(filename);

        tmpFile = camera.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.moveFile(tmpFile, imgFile);
        }
        catch (FileExistsException existsException){
            System.out.prinln(existsException);
        }
    }

}
