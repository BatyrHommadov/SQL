package utils;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.time.Duration;

public class BrowserManager {
    public static ChromeDriver getChromeDriver(){

        ChromeOptions chromeOptions=new ChromeOptions();
        // This option will disable the notifications from chrome
        chromeOptions.addArguments("--disable-notifications");
        // to avoid the security related bug in certain versions of selenium
        chromeOptions.addArguments("--remote-allow-origins=*");

        ChromeDriver chromeDriver=new ChromeDriver(chromeOptions);
        chromeDriver.manage().window().maximize();
        chromeDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        chromeDriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        return chromeDriver;
    }
    public static FirefoxDriver getFireFoxDriver(){

        FirefoxOptions firefoxOptions=new FirefoxOptions();
        // This option will disable the notifications from chrome
        firefoxOptions.addArguments("--disable-notifications");
        FirefoxDriver firefoxDriver=new FirefoxDriver(firefoxOptions);
        firefoxDriver.manage().window().maximize();
        firefoxDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Constants.IMPLICIT_WAIT));
        firefoxDriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Constants.PAGE_LOAD_TIMEOUT));
        return firefoxDriver;

    }

}
