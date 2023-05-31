package org.example.utils;

import org.example.core.driver.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.example.core.driver.WebDriverFactory.driver;

public class WaitUtils {
    private WaitUtils() {
    }

    public static void waitUntilsElementIsVisible(WebDriver driver, WebElement element) {
        WebDriverWait wait1 = new WebDriverWait(driver, 5);
        wait1.until(ExpectedConditions.visibilityOf(element));
    }
    public static void waitUntilsElementIsClicable(WebDriver driver, WebElement element) {
        WebDriverWait wait2 = new WebDriverWait(driver, 5);
        wait2.until(ExpectedConditions.elementToBeClickable(element));
    }
}
