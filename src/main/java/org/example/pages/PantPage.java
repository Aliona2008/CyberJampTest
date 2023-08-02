package org.example.pages;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.example.utils.WaitUtils.waitUntilsElementIsClicable;
import static org.example.utils.WaitUtils.waitUntilsElementIsVisible;

public class PantPage extends BasePage{
    public PantPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
    @Getter
    private final String PANT_PAGE_URL = "https://magento2-demo.magebit.com/cora-parachute-pant.html";

    @FindBy(xpath = "//div[@class='page-title-wrapper product']")
    private WebElement elTitleCta;
@Getter
    @FindBy(xpath = "//div[@id='option-label-size-157-item-175']")
    private WebElement elSizeCta;

    @FindBy(xpath = "//div[@id='option-label-color-93-item-49']")
    private WebElement elColorBlackCta;

    @FindBy(xpath = "//div[@id='option-label-color-93-item-50']")
    private WebElement elColorBlueCta;

    @FindBy(xpath = "//div[@id='option-label-color-93-item-59']")
    private WebElement elColorWhiteCta;
@Getter
    @FindBy(xpath = "//div[@id='super_attribute[157]-error']")
    private WebElement elSizeError;
@Getter
    @FindBy(xpath = "//div[@id='super_attribute[93]-error']")
    private WebElement elColorError;

    @Override
    public void open() {
        super.driver.get(PANT_PAGE_URL);
        ensureOpened();
    }

    @Override
    public void ensureOpened() {

        waitUntilsElementIsVisible(driver, elTitleCta);
    }

    public void setTitle(String title) {
        waitUntilsElementIsVisible(driver, elTitleCta);
        elTitleCta.clear();
        elTitleCta.sendKeys(title);
    }

    public void setSize(String size) {
        waitUntilsElementIsVisible(driver, elSizeCta);
        elSizeCta.clear();
        elSizeCta.sendKeys(size);
    }

    public void setColor(String color) {
        switch (color) {
            case "Black":
                waitUntilsElementIsClicable(driver, elColorBlackCta);
                elColorBlackCta.click();
            case "Blue":
                waitUntilsElementIsClicable(driver, elColorBlueCta);
                elColorBlueCta.click();
            case "White":
                waitUntilsElementIsClicable(driver, elColorWhiteCta);
                elColorWhiteCta.click();
        }
    }

    public void isSizeError(String size) {
        waitUntilsElementIsClicable(driver, elSizeError);
        elSizeError.sendKeys(size);
    }

    public void isColorError(String color) {
        waitUntilsElementIsClicable(driver, elColorError);
        elColorError.sendKeys(color);
    }

}
