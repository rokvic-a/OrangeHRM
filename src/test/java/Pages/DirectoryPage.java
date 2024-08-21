package Pages;

import Base.BaseTest;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DirectoryPage extends BaseTest {
    public DirectoryPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "input[placeholder='Type for hints...']")
    public WebElement employeeNameField;

    @FindBy(css = ".oxd-grid-3 > div:nth-of-type(2) .oxd-select-text-input")
    public WebElement jobTitleDropdown;

    @FindBy(css = "div:nth-of-type(3) .oxd-select-text-input")
    public WebElement locationDropdown;

    @FindBy(css = ".orangehrm-left-space.oxd-button.oxd-button--medium.oxd-button--secondary")
    public WebElement searchButton;

    @FindBy(css = ".orangehrm-directory-card.oxd-sheet.oxd-sheet--rounded.oxd-sheet--white > .--break-words.orangehrm-directory-card-header.oxd-text.oxd-text--p")
    public WebElement employeeCard;

    @FindBy(css = ".orangehrm-horizontal-padding .oxd-text--span")
    public WebElement recordFoundText;

    /////////////////////////////////////////////////////////////


    public String getRecordFoundText() {
        return recordFoundText.getText();
    }
    public void searchByName(String name) {
        employeeNameField.sendKeys(name);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
        }
        employeeNameField.sendKeys(Keys.ARROW_DOWN);
        employeeNameField.sendKeys(Keys.ENTER);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
        }
        searchButton.click();
    }

    public void searchByJobTitle() {
        jobTitleDropdown.click();
        jobTitleDropdown.sendKeys(Keys.ARROW_DOWN);

        jobTitleDropdown.sendKeys(Keys.ENTER);
        searchButton.click();
    }

    public void searchByLocation() {
        locationDropdown.click();
        locationDropdown.sendKeys(Keys.ARROW_DOWN);
        locationDropdown.sendKeys(Keys.ENTER);
        searchButton.click();
    }

    public void searchUsingAllFilters(String name) {
        employeeNameField.sendKeys(name);
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
        }
        employeeNameField.sendKeys(Keys.ARROW_DOWN);
        employeeNameField.sendKeys(Keys.ENTER);
        jobTitleDropdown.click();
        jobTitleDropdown.sendKeys(Keys.ARROW_DOWN);
        jobTitleDropdown.sendKeys(Keys.ENTER);
        locationDropdown.click();
        locationDropdown.sendKeys(Keys.ARROW_DOWN);
        locationDropdown.sendKeys(Keys.ENTER);
        searchButton.click();
    }
}
