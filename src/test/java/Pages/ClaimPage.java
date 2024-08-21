package Pages;

import Base.BaseTest;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ClaimPage extends BaseTest {
    public ClaimPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(linkText = "Submit Claim")
    public WebElement submitClaimButton;

    @FindBy(css = "div:nth-of-type(1) > .oxd-input-field-bottom-space.oxd-input-group > div:nth-of-type(2) > .oxd-select-wrapper > .oxd-select-text > .oxd-select-text-input")
    public WebElement eventDropdown;

    @FindBy(css = "div:nth-of-type(2) > .oxd-input-field-bottom-space.oxd-input-group > div:nth-of-type(2) > .oxd-select-wrapper > .oxd-select-text > .oxd-select-text-input")
    public WebElement currencyDropdown;

    @FindBy(css = ".oxd-textarea.oxd-textarea--resize-vertical")
    public WebElement remarksField;

    @FindBy(css = ".orangehrm-left-space.oxd-button.oxd-button--medium.oxd-button--secondary")
    public WebElement createButton;

    @FindBy(css = ".orangehrm-sm-button.oxd-button.oxd-button--medium.oxd-button--secondary")
    public WebElement submitButton;

    ///////////////////////////////////////////////////////////////////////////////////////////////

    public void submitClaim(String remark) {
        submitClaimButton.click();
        eventDropdown.click();
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
        }
        eventDropdown.sendKeys(Keys.ARROW_DOWN);
        eventDropdown.sendKeys(Keys.ENTER);
        currencyDropdown.click();
        currencyDropdown.sendKeys(Keys.ARROW_DOWN);
        currencyDropdown.sendKeys(Keys.ENTER);
        remarksField.sendKeys(remark);
        createButton.click();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
        }
        submitButton.click();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
        }
    }

    public boolean isSubmitButtonDisplayed() {
        try {
            return submitButton.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}
