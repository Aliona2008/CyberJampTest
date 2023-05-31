import org.example.core.driver.WebDriverFactory;
import org.example.pages.HomePage;
import org.example.utils.ConfigProvider;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.example.utils.WaitUtils.waitUntilsElementIsClicable;
import static org.example.utils.WaitUtils.waitUntilsElementIsVisible;

public class TestRunner {
    public static void main(String[] args) {
//        WebDriver driver = WebDriverFactory.getDriver();
//        driver.get(ConfigProvider.getBASE_URL());
//     WebElement elAllPriceTitle = driver.findElement(By.xpath("//div[@class='logo']//span[contains(text(), 'Все цены')]"));
//        waitUntilsElementIsVisible(driver, elAllPriceTitle);
//       System.out.println("Title is visible");
//
//        WebElement elHeadPhonesCta = driver.findElement(By.xpath("//div[@class='pc-block']//a[@title='Наушники']"));
//        waitUntilsElementIsClicable(driver, elHeadPhonesCta);
//        elHeadPhonesCta.click();
//        driver.quit();
//
//
//        WebElement elElectricKettle = driver.findElement(By.xpath("//span[contains(text(), 'Электрочайник')]"));
//        waitUntilsElementIsClicable(driver, elElectricKettle);
//        elElectricKettle.click();
//        driver.quit();

        WebDriver driver = WebDriverFactory.getDriver();
        HomePage homePage = new HomePage(driver);
        homePage.open();
        waitUntilsElementIsClicable(driver, homePage.getElHeadPhoneCta());
        homePage.getElHeadPhoneCta().click();
        driver.quit();
    }
}
