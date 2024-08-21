package Pages;

import Base.BaseTest;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AdminPage extends BaseTest {
    public AdminPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "li:nth-of-type(7) > .oxd-topbar-body-nav-tab-item")
    public WebElement configurationDropdown;

    @FindBy(css = "li:nth-of-type(5) > a[role='menuitem']")
    public WebElement configurationOptions;

    @FindBy(css = "div:nth-of-type(11) > .oxd-switch-wrapper  .--label-right.oxd-switch-input")
    public WebElement toggleBuzzButton;

    @FindBy(css = ".oxd-form-actions > .orangehrm-left-space.oxd-button.oxd-button--medium.oxd-button--secondary")
    public WebElement configurationSaveButton;

    @FindBy(css = "li:nth-of-type(12) > .oxd-main-menu-item > .oxd-main-menu-item--name.oxd-text.oxd-text--span")
    public WebElement buzzOption;

    @FindBy(css = ".orangehrm-header-container .oxd-button--secondary")
    public WebElement addButton;

    @FindBy(css = "div:nth-of-type(1) > .oxd-input-field-bottom-space.oxd-input-group > div:nth-of-type(2) > .oxd-select-wrapper > .oxd-select-text > .oxd-select-text-input")
    public WebElement userRoleDropdown;

    @FindBy(css = ".oxd-autocomplete-text-input > input[placeholder='Type for hints...']")
    public WebElement employeeNameField;

    @FindBy(css = "div:nth-of-type(3) > .oxd-input-field-bottom-space.oxd-input-group > div:nth-of-type(2) > .oxd-select-wrapper > .oxd-select-text > .oxd-select-text-input")
    public WebElement statusDropdown;

    @FindBy(css = ".oxd-form .oxd-form-row:nth-of-type(1) [autocomplete]")
    public WebElement usernameField;

    @FindBy(css = ".oxd-grid-item.oxd-grid-item--gutters.user-password-cell > .oxd-input-field-bottom-space.oxd-input-group  .oxd-input")
    public WebElement passwordField;

    @FindBy(css = ".oxd-grid-item--gutters:nth-of-type(2) [type]")
    public WebElement confirmPasswordField;

    @FindBy(css = ".orangehrm-left-space.oxd-button.oxd-button--medium.oxd-button--secondary")
    public WebElement adminSaveButton;

    @FindBy(css = ".orangehrm-left-space.oxd-button.oxd-button--medium.oxd-button--secondary")
    public WebElement searchButton;

    @FindBy(css = ".oxd-form .oxd-input")
    public WebElement systemUsername;

    @FindBy(css = "div:nth-of-type(2) > .oxd-input-field-bottom-space.oxd-input-group > div:nth-of-type(2) > .oxd-select-wrapper > .oxd-select-text > .oxd-select-text-input")
    public WebElement systemUserRole;

    @FindBy(css = ".oxd-autocomplete-text-input > input[placeholder='Type for hints...']")
    public WebElement systemEmployeeName;

    @FindBy(css = "div:nth-of-type(4) > .oxd-input-field-bottom-space.oxd-input-group > div:nth-of-type(2) > .oxd-select-wrapper > .oxd-select-text > .oxd-select-text-input")
    public WebElement systemStatusDropdown;

    @FindBy(css = "button:nth-of-type(1) > .bi-trash.oxd-icon")
    public WebElement trashCanIcon;

    @FindBy(css = ".orangehrm-button-margin.oxd-button.oxd-button--label-danger.oxd-button--medium")
    public WebElement yesDeleteButton;

    ////////////////////////////////////////////////////////

    public void selectOption() {
        configurationDropdown.click();
        configurationOptions.click();
        toggleBuzzButton.click();
        configurationSaveButton.click();
    }

    public boolean isBuzzOptionDisplayed() {
        try {
            return buzzOption.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public void addUser(String name, String password) {
        addButton.click();
        userRoleDropdown.click();
        userRoleDropdown.sendKeys(Keys.ARROW_DOWN);
        userRoleDropdown.sendKeys(Keys.ENTER);
        employeeNameField.sendKeys(name);
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
        }
        employeeNameField.sendKeys(Keys.ARROW_DOWN);
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
        }
        employeeNameField.sendKeys(Keys.ENTER);
        statusDropdown.click();
        statusDropdown.sendKeys(Keys.ARROW_DOWN);
        statusDropdown.sendKeys(Keys.ENTER);
        usernameField.sendKeys(generateUsername());
        passwordField.sendKeys(password);
        confirmPasswordField.sendKeys(password);
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
        }
        adminSaveButton.click();
    }

    public void searchUser(String name) {
        systemUsername.sendKeys("");
        systemUserRole.sendKeys(Keys.ARROW_DOWN);
        systemUserRole.sendKeys(Keys.ENTER);
        systemEmployeeName.sendKeys(name);
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
        }
        systemEmployeeName.sendKeys(Keys.ARROW_DOWN);
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
        }
        systemEmployeeName.sendKeys(Keys.ENTER);
        systemStatusDropdown.click();
        systemStatusDropdown.sendKeys(Keys.ARROW_DOWN);
        systemStatusDropdown.sendKeys(Keys.ENTER);
        searchButton.click();
    }

    public void deleteUser(String name) {
        systemEmployeeName.sendKeys(name);
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
        }
        systemEmployeeName.sendKeys(Keys.ARROW_DOWN);
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
        }
        systemEmployeeName.sendKeys(Keys.ENTER);
        searchButton.click();
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
        }
        trashCanIcon.click();
        yesDeleteButton.click();
    }

    public String getEmployeeName(String employeeName) {
        try {
            Thread.sleep(3000);
            List<WebElement> employeeCells = driver.findElements(By.cssSelector("div[role='table'] div[role='row'] > div:nth-of-type(4)"));
            for (WebElement cell : employeeCells) {
                if (cell.getText().equals(employeeName)) {
                    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", cell);
                    return cell.getText();
                }
            }
            return null;
        } catch (InterruptedException e) {
            e.printStackTrace();
            return null;
        } catch (NoSuchElementException e) {
            return null;
        }
    }
}

