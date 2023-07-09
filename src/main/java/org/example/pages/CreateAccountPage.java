package org.example.pages;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import static org.example.utils.WaitUtils.waitUntilsElementIsVisible;

public class CreateAccountPage extends BasePage{
    @Getter
    private final String CREATE_ACCOUNT_URL = "https://magento2-demo.magebit.com/customer/account/create/";

    @FindBy(xpath = "//input[@id='firstname']")
    private WebElement elFirstNameInput;

    @FindBy(xpath = "//div[@id='firstname-error']")
    private WebElement elFirstnameError;
    @FindBy(xpath = "//input[@id='lastname']")
    private WebElement elLastNameInput;
    @FindBy(xpath = "//div[@id='lastname-error']")
    private WebElement elLastnameError;
    @FindBy(xpath = "//input[@id='is_subscribed']")
    private WebElement elIsSubscribedCheckBox;

    @FindBy(xpath = "//input[@id='email_address']")
    private WebElement elEmailInput;

    @FindBy(xpath = "//div[@id='email_address-error']")
    private WebElement elEmailError;

    @FindBy(xpath = "//input[@id='password']")
    private WebElement elPasswordInput;
    @FindBy(xpath = "//div[@id='password-error']")
    private WebElement elPasswordError;
    @FindBy(xpath = "//input[@id='password-confirmation']")
    private WebElement elPasswordConfirmationInput;
    @FindBy(xpath = "//div[@id='password-confirmation-error']")
    private WebElement elPasswordConfirmationError;
    @Getter
    @FindBy(xpath = "//button[@class='action submit primary']")
    private WebElement elCreateAccountCta;

    public CreateAccountPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Override
    public void open() {
        super.driver.get(CREATE_ACCOUNT_URL);
        ensureOpened();
    }

    @Override
    public void ensureOpened() {
        waitUntilsElementIsVisible(driver, elFirstNameInput);
    }

    public void setFirstName(String firstName) {
        waitUntilsElementIsVisible(driver, elFirstNameInput);
        elFirstNameInput.sendKeys(firstName);
    }

    public void setLastName(String lastName) {
        waitUntilsElementIsVisible(driver, elLastNameInput);
        elLastNameInput.sendKeys(lastName);
    }

    public void setEmail(String email) {
        waitUntilsElementIsVisible(driver, elEmailInput);
        elEmailInput.sendKeys(email);
    }

    public void setPassword(String password) {
        waitUntilsElementIsVisible(driver, elPasswordInput);
        elPasswordInput.sendKeys(password);
    }

    public void setConfirmPassword(String confirmPassword) {
        waitUntilsElementIsVisible(driver, elPasswordConfirmationInput);
        elPasswordConfirmationInput.sendKeys(confirmPassword);
    }

    public void checkFirstNameError(String firstName) {
        if (firstName.isEmpty()){
            waitUntilsElementIsVisible(driver, elFirstnameError);
            Assert.assertEquals(elFirstnameError.getText(),
                    "Данное поле является обязательным к заполнению",
                    "expected firstname error massage doesn't match actual massage");
        }
    }

    public void checkLastNameError(String lastName) {
        if (lastName.isEmpty()){
            waitUntilsElementIsVisible(driver, elLastnameError);
            Assert.assertEquals(elLastnameError.getText(),
                    "Данное поле является обязательным к заполнению",
                    "expected firstname error massage doesn't match actual massage");
        }
    }

    public void checkEmailError(String email) {
        if (email.isEmpty()){
            waitUntilsElementIsVisible(driver, elEmailError);
            Assert.assertEquals(elEmailError.getText(),
                    "Данное поле является обязательным к заполнению",
                    "expected firstname error massage doesn't match actual massage");
        }
    }

    public void checkPasswordError(String password) {
        if (password.isEmpty()){
            waitUntilsElementIsVisible(driver, elPasswordError);
            Assert.assertEquals(elPasswordError.getText(),
                    "Данное поле является обязательным к заполнению",
                    "expected firstname error massage doesn't match actual massage");
        }
    }

    public void checkConfirmPasswordError(String confirmPassword) {
        if (confirmPassword.isEmpty()){
            waitUntilsElementIsVisible(driver, elPasswordConfirmationError);
            Assert.assertEquals(elPasswordConfirmationError.getText(),
                    "Данное поле является обязательным к заполнению",
                    "expected firstname error massage doesn't match actual massage");
        }
    }

    public void checkAllErrorFields(String firstName, String lastName, String email, String password, String confirmPassword) {
        checkFirstNameError(firstName);
        checkLastNameError(lastName);
        checkEmailError(email);
        checkPasswordError(password);
        checkConfirmPasswordError(confirmPassword);

    }
}
