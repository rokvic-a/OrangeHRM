package Pages;

import Base.BaseTest;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class MyInfoPage extends BaseTest {
    public MyInfoPage() {
        PageFactory.initElements(driver, this);
    }


    @FindBy(css = "input[name='firstName']")
    public WebElement employeeNameField;

    @FindBy(css = "input[name='lastName']")
    public WebElement employeeLastNameField;

    @FindBy(css = "input[name='middleName']")
    public WebElement employeeMiddleNameField;

    @FindBy(css = "div:nth-of-type(1) > div:nth-of-type(1) > .oxd-input-field-bottom-space.oxd-input-group  .oxd-input")
    public WebElement employeeIdField;

    @FindBy(css = "div:nth-of-type(2) > div:nth-of-type(1) > div:nth-of-type(2) > .oxd-input-field-bottom-space.oxd-input-group  .oxd-input")
    public WebElement otherIdField;

    @FindBy(css = ".orangehrm-edit-employee-content .oxd-form-row:nth-child(3) [class='oxd-grid-3 orangehrm-full-width-grid']:nth-of-type(2) .oxd-grid-item--gutters:nth-of-type(1) input")
    public WebElement driverLicenceField;

    @FindBy(css = "div:nth-of-type(2) > div:nth-of-type(2) > .oxd-input-field-bottom-space.oxd-input-group .oxd-input")
    public WebElement licenceDatePicker;

    @FindBy(css = "div:nth-of-type(27) > .oxd-calendar-date")
    public WebElement licenceDayPicker;

    @FindBy(css = "div:nth-of-type(3) > div:nth-of-type(1) > div:nth-of-type(1) > .oxd-input-field-bottom-space.oxd-input-group .oxd-select-text > .oxd-select-text-input")
    public WebElement nationalityDropdown;

    @FindBy(css = "div:nth-of-type(2) > .oxd-input-field-bottom-space.oxd-input-group .oxd-select-text > .oxd-select-text-input")
    public WebElement maritalStatusDropdown;

    @FindBy(css = "div:nth-of-type(3) > div:nth-of-type(2) > div:nth-of-type(1) > .oxd-input-field-bottom-space.oxd-input-group .oxd-input")
    public WebElement dateOfBirthPicker;

    @FindBy(css = "div:nth-of-type(24) > .oxd-calendar-date")
    public WebElement dayOfBirthPicker;

    @FindBy(css = ".--gender-grouped-field > div:nth-of-type(2) .--label-right.oxd-radio-input")
    public WebElement femaleRadioButton;

    @FindBy(css = ".orangehrm-horizontal-padding.orangehrm-vertical-padding > .oxd-form > .oxd-form-actions > .orangehrm-left-space.oxd-button.oxd-button--medium.oxd-button--secondary")
    public WebElement saveButton;

    //////////////////////////////////////////////////////////////////////////

    public void editPersonalDetails(String update) {
        try {
            Thread.sleep(2500);
        } catch (InterruptedException e) {
        }
        employeeNameField.click();
        employeeNameField.sendKeys(update);
        employeeMiddleNameField.sendKeys(update);
        employeeLastNameField.sendKeys(update);
        employeeIdField.sendKeys(update);
        otherIdField.sendKeys(update);
        driverLicenceField.sendKeys(update);
        licenceDatePicker.click();
        licenceDayPicker.click();
        nationalityDropdown.click();
        nationalityDropdown.sendKeys(Keys.ARROW_DOWN);
        nationalityDropdown.sendKeys(Keys.ENTER);
        maritalStatusDropdown.click();
        maritalStatusDropdown.sendKeys(Keys.ARROW_DOWN);
        maritalStatusDropdown.sendKeys(Keys.ARROW_DOWN);
        maritalStatusDropdown.sendKeys(Keys.ENTER);
        dateOfBirthPicker.click();
        dayOfBirthPicker.click();
        femaleRadioButton.click();
        saveButton.click();
    }

    public String nameValue;
    public String middleNameValue;
    public String lastNameValue;
    public String idValue;
    public String otherIdValue;
    public String driverLicenceValue;

    public void retrievePersonalDetailFieldValues(String value) {
        nameValue = employeeNameField.getAttribute(value);
        middleNameValue = employeeMiddleNameField.getAttribute(value);
        lastNameValue = employeeLastNameField.getAttribute(value);
        idValue = employeeIdField.getAttribute(value);
        otherIdValue = otherIdField.getAttribute(value);
        driverLicenceValue = driverLicenceField.getAttribute(value);
    }
}
