package utils;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class WebDriverUtils extends PageInitializer{
    public static WebDriver webDriver;

    public static void launchBrowser(String url) {

        switch (ConfigFileReader.getPropertyV("browserType")) {
            case "GoogleChrome":
                webDriver = BrowserManager.getChromeDriver();
                break;
            case "FireFox":
                webDriver = BrowserManager.getFireFoxDriver();
                break;
            default:
                throw new IllegalArgumentException("Please make sure you are providing the correct " +
                        "browser name in the browserType key in Config.properties file. Allowed  names are GoogleChrome " +
                        "FireFox");
        }
        webDriver.get(url);
        PageInitializer.initPageObjects();

    }

    public static void closeWebDriver() {
        webDriver.close();
    }

    public static byte[] takeScreenshot(String fileName) {
        TakesScreenshot ts = (TakesScreenshot) webDriver;
        byte[] picBytes = ts.getScreenshotAs(OutputType.BYTES);
        File sourceFile = ts.getScreenshotAs(OutputType.FILE);

        try {
            org.apache.commons.io.FileUtils.copyFile(sourceFile,
                    new File(Constants.SCREENSHOT_FILE_PATH + fileName + " " +
                            getTimeStamp("yyyy-MM-dd-HH-mm-ss") + ".png"));

        } catch (IOException e) {
            e.printStackTrace();
        }
        return picBytes;
    }

    public static String getTimeStamp(String pattern) {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        return sdf.format(date);
    }

    public static void selectDDByText(WebElement webElement, String visibleText) {
        new Select(webElement).selectByVisibleText(visibleText);
    }

    public static void selectDDByIndex(WebElement webElement, int index) {
        new Select(webElement).selectByIndex(index);
    }

    public static void jsClick(WebElement webElement) {
        JavascriptExecutor js = (JavascriptExecutor) webDriver;
        js.executeScript("arguments[0].click()", webElement);
    }

    public static void jsScroll(int x, int y) {
        JavascriptExecutor js = (JavascriptExecutor) webDriver;
        js.executeScript("window.scroll(" + x + "," + y + ")");
    }

    public static void moveToElement(WebElement webElement) {
        Actions action = new Actions(webDriver);
        action.moveToElement(webElement).perform();
    }

}
