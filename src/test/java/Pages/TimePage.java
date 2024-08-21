package Pages;

import Base.BaseTest;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TimePage extends BaseTest {
    public TimePage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "li:nth-of-type(4) > .oxd-topbar-body-nav-tab-item")
    public WebElement projectInfoDropdown;

    @FindBy(css = "li:nth-of-type(2) > a[role='menuitem']")
    public WebElement projectsOption;

    @FindBy(css = ".orangehrm-header-container .oxd-button--secondary")
    public WebElement addButton;

    @FindBy(css = ".oxd-form .oxd-input")
    public WebElement nameField;

    @FindBy(css ="div:nth-of-type(2) > .oxd-input-field-bottom-space.oxd-input-group > div:nth-of-type(2) > .oxd-autocomplete-wrapper > .oxd-autocomplete-text-input > input[placeholder='Type for hints...']")
    public WebElement customerNameField;

    @FindBy(css = ".oxd-textarea.oxd-textarea--resize-vertical")
    public WebElement descriptionField;

    @FindBy(css = ".orangehrm-project-admin-input > .oxd-input-field-bottom-space.oxd-input-group .oxd-autocomplete-text-input > input[placeholder='Type for hints...']")
    public WebElement projectAdmin;

    @FindBy(css = ".orangehrm-left-space.oxd-button.oxd-button--medium.oxd-button--secondary")
    public WebElement saveButton;

    @FindBy(css = "div:nth-of-type(2) > .oxd-input-field-bottom-space.oxd-input-group .oxd-autocomplete-text-input > input[placeholder='Type for hints...']")
    public WebElement projectSearchField;

    @FindBy(css = ".orangehrm-full-width-grid.oxd-grid-3 > div:nth-of-type(1) > .oxd-input-field-bottom-space.oxd-input-group > div:nth-of-type(2) > .oxd-autocomplete-wrapper > .oxd-autocomplete-text-input > input[placeholder='Type for hints...']")
    public WebElement customerNameSearchField;

    @FindBy(css = ".orangehrm-project-admin-input > .oxd-input-field-bottom-space.oxd-input-group .oxd-autocomplete-text-input > input[placeholder='Type for hints...']")
    public WebElement projectAdminSearchField;

    @FindBy(css = ".orangehrm-left-space.oxd-button.oxd-button--medium.oxd-button--secondary")
    public WebElement searchButton;

    @FindBy(css = ".orangehrm-horizontal-padding.orangehrm-vertical-padding > .oxd-text.oxd-text--span")
    public WebElement recordFound;

    @FindBy(css = "div:nth-of-type(1) > div[role='row'] > div:nth-of-type(5) > div > button:nth-of-type(1) > .bi-trash.oxd-icon")
    public WebElement trashCanIcon;

    @FindBy(css = ".orangehrm-button-margin.oxd-button.oxd-button--label-danger.oxd-button--medium")
    public WebElement confirmDeleteButton;

    ///////////////////////////////////////////////////////////////////////////////////////////

    public String getRecordFoundText() {
        return recordFound.getText();
    }

    public void addProject(String name, String description) {
        projectInfoDropdown.click();
        projectsOption.click();
        addButton.click();
        nameField.sendKeys(name);
        customerNameField.sendKeys("A");
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
        }
        customerNameField.sendKeys(Keys.ARROW_DOWN);
        customerNameField.sendKeys(Keys.ENTER);
        descriptionField.sendKeys(description);
        projectAdmin.sendKeys("Pera");
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
        }
        projectAdmin.sendKeys(Keys.ARROW_DOWN);
        projectAdmin.sendKeys(Keys.ENTER);
        saveButton.click();
    }

    public void editProject(String newName) {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
        }
        nameField.sendKeys(newName);
        saveButton.click();
    }

    public void searchProject() {
        projectInfoDropdown.click();
        projectsOption.click();
        customerNameSearchField.sendKeys("A");
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
        }
        customerNameSearchField.sendKeys(Keys.ARROW_DOWN);
        customerNameSearchField.sendKeys(Keys.ENTER);
        projectSearchField.sendKeys("orange");
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
        }
        projectSearchField.sendKeys(Keys.ARROW_DOWN);
        projectSearchField.sendKeys(Keys.ENTER);
        projectAdminSearchField.sendKeys("Pera");
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
        }
        projectAdminSearchField.sendKeys(Keys.ARROW_DOWN);
        projectAdminSearchField.sendKeys(Keys.ENTER);
        searchButton.click();
    }

    public void deleteProject() {
        trashCanIcon.click();
        confirmDeleteButton.click();

    }
    public String nameValue;

    public void retrieveValues(String value) {
        nameValue = nameField.getAttribute(value);
    }
}
