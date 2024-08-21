package Pages;

import Base.BaseTest;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RecruitmentPage extends BaseTest {

    public RecruitmentPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".orangehrm-header-container .oxd-button--secondary")
    public WebElement addButton;

    @FindBy(css = "input[name='firstName']")
    public WebElement firstNameField;

    @FindBy(css = "input[name='lastName']")
    public WebElement lastNameField;

    @FindBy(css = ".oxd-select-text > .oxd-select-text-input")
    public WebElement vacancyDropdown;

    @FindBy(css = "div:nth-of-type(3) > .orangehrm-full-width-grid.oxd-grid-3 > div:nth-of-type(1) > .oxd-input-field-bottom-space.oxd-input-group  .oxd-input")
    public WebElement emailField;

    @FindBy(css = ".oxd-textarea.oxd-textarea--resize-vertical")
    public WebElement notesField;

    @FindBy(css = ".oxd-form-actions > .orangehrm-left-space.oxd-button.oxd-button--medium.oxd-button--secondary")
    public WebElement saveButton;

    @FindBy(css = "[placeholder='yyyy-dd-mm']")
    public WebElement datePicker;

    @FindBy(css = "div:nth-of-type(13) > .oxd-calendar-date")
    public WebElement dayPicker;

    @FindBy(css = ".oxd-button.oxd-button--danger.oxd-button--medium")
    public WebElement rejectButton;

    @FindBy(css = ".oxd-autocomplete-text-input > input[placeholder='Type for hints...']")
    public WebElement candidateNameField;

    @FindBy(css = ".orangehrm-left-space.oxd-button.oxd-button--medium.oxd-button--secondary")
    public WebElement searchButton;

    @FindBy(css = "div:nth-of-type(1) > div[role='row'] > div:nth-of-type(7) > div > button:nth-of-type(1) > .bi-eye-fill.oxd-icon")
    public WebElement eyeIcon;

    @FindBy(css = "div:nth-of-type(1) > div[role='row'] > div:nth-of-type(7) > div > button:nth-of-type(2) > .bi-trash.oxd-icon")
    public WebElement trashCanIcon;

    @FindBy(css = ".orangehrm-button-margin.oxd-button.oxd-button--label-danger.oxd-button--medium")
    public WebElement yesDeleteButton;

    @FindBy(css = "li:nth-of-type(5) > .oxd-main-menu-item > .oxd-main-menu-item--name.oxd-text.oxd-text--span")
    public WebElement recruitmentLink;

    //////////////////////////////////////////////////////////////////////////

    public void addCandidate(String name, String lastName, String email, String notes) {
        addButton.click();
        firstNameField.sendKeys(name);
        lastNameField.sendKeys(lastName);
        vacancyDropdown.click();
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
        }
        vacancyDropdown.sendKeys(Keys.ARROW_DOWN);
        vacancyDropdown.sendKeys(Keys.ENTER);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
        }
        emailField.sendKeys(email);
        datePicker.click();
        dayPicker.click();
        notesField.sendKeys(notes);
        saveButton.click();
    }

    public boolean isRejectButtonDisplayed() {
        return rejectButton.isDisplayed();
    }

    public void clickOnRecruitment() {
        recruitmentLink.click();
    }

    public void viewCandidate(String name) {
        candidateNameField.sendKeys(name);
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
        }
        candidateNameField.sendKeys(Keys.ARROW_DOWN);
        candidateNameField.sendKeys(Keys.ENTER);
        searchButton.click();
        eyeIcon.click();
    }

    public void deleteCandidate(String name) {
        candidateNameField.sendKeys(name);
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
        }
        candidateNameField.sendKeys(Keys.ARROW_DOWN);
        candidateNameField.sendKeys(Keys.ENTER);
        searchButton.click();
        trashCanIcon.click();
        yesDeleteButton.click();
    }
}
