package Pages;

import Base.BaseTest;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class PIMPage extends BaseTest {
    public PIMPage() {
        PageFactory.initElements(driver, this);
    }
    @FindBy(css = "input[name='firstName']")
    public WebElement firstNameField;

    @FindBy(css = "input[name='lastName']")
    public WebElement lastNameField;

    @FindBy(css = "[class='oxd-grid-2 orangehrm-full-width-grid'] input")
    public WebElement employeeIdField;

    @FindBy(css = ".orangehrm-full-width-grid.oxd-grid-4 .oxd-input")
    public WebElement employeeIdSearchField;

    @FindBy(css = ".orangehrm-left-space.oxd-button.oxd-button--medium.oxd-button--secondary")
    public WebElement searchButton;

    @FindBy(css = ".orangehrm-horizontal-padding.orangehrm-vertical-padding > .oxd-text.oxd-text--span")
    public WebElement recordFoundText;

    @FindBy(css = ".orangehrm-horizontal-padding.orangehrm-vertical-padding > .oxd-text.oxd-text--span")
    public WebElement noRecordsFoundText;

    @FindBy(css = ".oxd-form-actions > .orangehrm-left-space.oxd-button.oxd-button--medium.oxd-button--secondary")
    public WebElement saveButton;

    @FindBy(css = "div:nth-of-type(1) > div[role='row'] > div:nth-of-type(9) > div > button:nth-of-type(2) > .bi-trash.oxd-icon")
    public WebElement deleteButton;

    @FindBy(css = ".orangehrm-button-margin.oxd-button.oxd-button--label-danger.oxd-button--medium")
    public WebElement confirmDeleteButton;

    @FindBy(css = ".orangehrm-header-container .oxd-button--secondary")
    public WebElement addButton;

    @FindBy(css = "li:nth-of-type(2) > .oxd-main-menu-item")
    public WebElement pimLink;

    @FindBy(xpath = "//div[@class='oxd-table-body']/div/div/div[3]/div")
    public WebElement employeeNameInResults;

    private String storedEmployeeId;

///////////////////////////////////////////////////////////////////////


    public void addEmployeeAndStoreId(String firstName, String lastName) {
        addButton.click();
        wait.until(ExpectedConditions.visibilityOf(firstNameField));
        firstNameField.sendKeys(firstName);
        lastNameField.sendKeys(lastName);
        storedEmployeeId = employeeIdField.getAttribute("value");
        saveButton.click();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
        }
    }

    public String getStoredEmployeeId() {
        return storedEmployeeId;
    }

    public String getRecordFoundText() {
        return recordFoundText.getText();
    }

    public void searchEmployeeByStoredId() {
        wait.until(ExpectedConditions.visibilityOf(employeeIdSearchField));
        employeeIdSearchField.sendKeys(Keys.CONTROL + "a", Keys.DELETE);
        employeeIdSearchField.sendKeys(storedEmployeeId);
        searchButton.click();
    }

    public void editEmployeeDetails(String newFirstName, String newLastName) {
        wait.until(ExpectedConditions.visibilityOf(firstNameField));
        firstNameField.sendKeys(Keys.CONTROL + "a", Keys.DELETE);
        firstNameField.sendKeys(newFirstName);
        lastNameField.sendKeys(Keys.CONTROL + "a", Keys.DELETE);
        lastNameField.sendKeys(newLastName);

        saveButton.click();
    }

    public void deleteEmployeeByStoredId() {
        searchEmployeeByStoredId();
        wait.until(ExpectedConditions.elementToBeClickable(deleteButton));
        deleteButton.click();
        wait.until(ExpectedConditions.elementToBeClickable(confirmDeleteButton));
        confirmDeleteButton.click();
    }


    public String getNoRecordsFoundText() {
        wait.until(ExpectedConditions.visibilityOf(noRecordsFoundText));
        return noRecordsFoundText.getText();
    }

    public String getEmployeeNameFromResults() {
        wait.until(ExpectedConditions.visibilityOf(employeeNameInResults));
        return employeeNameInResults.getText();
    }
}