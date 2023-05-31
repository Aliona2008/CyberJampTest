package org.example.core.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.example.core.Browsers;
import org.example.utils.ConfigProvider;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.safari.SafariDriver;

import static org.example.core.Browsers.CHROME;
import static org.example.core.Browsers.SAFARI;

public class WebDriverFactory {
    private static  final String BROWSER = System.getProperty("browser");
    public static WebDriver driver;
    public static  WebDriver getDriver(){
        String browserType = BROWSER != null ? BROWSER : ConfigProvider.getBROWSER();
            return getDriver(Browsers.valueOf(browserType.toUpperCase()));
    }

    public static WebDriver getDriver(Browsers browser) {
        switch (browser) {
            case CHROME:
                return getChromeDriver();

            case SAFARI:
                return getSAFARIDriver();

            case FIREFOX:
                return getFIREFOXDriver();

            case OPERA:
                return getOPERADriver();
            default:
                throw new IllegalArgumentException("Wrong browser was chose");
        }
    }

    public  static  WebDriver getChromeDriver() {
        if (driver == null) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }
        return driver;
    }

    public  static  WebDriver getSAFARIDriver() {
        if (driver == null) {
            WebDriverManager.safaridriver().setup();
            driver = new SafariDriver();
        }
        return driver;
    }

    public  static  WebDriver getFIREFOXDriver() {
        if (driver == null) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }
        return driver;
    }

    public  static  WebDriver getOPERADriver() {
        if (driver == null) {
            WebDriverManager.operadriver().setup();
            driver = new OperaDriver();
        }
        return driver;
    }
}