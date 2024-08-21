package Pages;

import Base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LeavePage extends BaseTest {
    public LeavePage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".oxd-select-text > .oxd-select-text-input")
    public WebElement leaveTypeDropdown;

    @FindBy(css = "div:nth-of-type(1) > .oxd-input-field-bottom-space.oxd-input-group > div:nth-of-type(2) > .oxd-date-wrapper > .oxd-date-input > .oxd-input")
    public WebElement fromDatePicker;

    @FindBy(css = "div:nth-of-type(2) > .oxd-input-field-bottom-space.oxd-input-group > div:nth-of-type(2) > .oxd-date-wrapper > .oxd-date-input > .oxd-input")
    public WebElement toDatePicker;

    @FindBy(css = "div:nth-of-type(29) > .oxd-calendar-date")
    public WebElement fromDateDay;

    @FindBy(css = "div:nth-of-type(31) > .oxd-calendar-date")
    public WebElement toDateDay;

    @FindBy(css = ".orangehrm-left-space.oxd-button.oxd-button--medium.oxd-button--secondary")
    public WebElement applyButton;

    @FindBy(linkText = "Apply")
    public WebElement applyPage;

    @FindBy(css = ".orangehrm-directory-card.oxd-sheet.oxd-sheet--rounded.oxd-sheet--white > .--break-words.orangehrm-directory-card-header.oxd-text.oxd-text--p")
    public WebElement successMessage;

    //////////////////////////////////////////////////////////////////

    public void applyLeave() {
        applyPage.click();
        leaveTypeDropdown.click();
        leaveTypeDropdown.sendKeys(Keys.ARROW_DOWN);
        leaveTypeDropdown.sendKeys(Keys.ENTER);
        fromDatePicker.click();
        fromDateDay.click();
        toDatePicker.click();
        toDateDay.click();
        applyButton.click();
    }
/*
    public void verifySuccessMessage() {
        WebElement successMessageLocator = successMessage;
        waitForElementAndAssertText(successMessageLocator, "Success");
    }

 */
}
