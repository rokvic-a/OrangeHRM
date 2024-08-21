package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class PerformancePage extends BaseTest {
    public PerformancePage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(linkText = "My Trackers")
    public WebElement myTrackersButton;

    @FindBy(css = "button[name='view']")
    public WebElement viewButton;

    @FindBy(css = ".oxd-button.oxd-button--medium.oxd-button--secondary")
    public WebElement addLogButton;

    @FindBy(css = ".oxd-form > div:nth-of-type(1) .oxd-input")
    public WebElement logInput;

    @FindBy(css = ".oxd-textarea.oxd-textarea--resize-vertical")
    public WebElement commentInput;

    @FindBy(css = ".oxd-form  .oxd-button.oxd-button--medium.oxd-button--secondary")
    public WebElement saveButton;

    @FindBy(css = "div:nth-of-type(1) > .orangehrm-employee-tracker-log .oxd-table-dropdown > .oxd-icon-button > .bi-three-dots-vertical.oxd-icon")
    public WebElement threeDotsButton;

    @FindBy(css = "li:nth-of-type(1) > .oxd-text.oxd-text--p")
    public WebElement editButton;

    @FindBy(css = "ul[role='menu'] > li:nth-of-type(2)")
    public WebElement deleteButton;

    @FindBy(css = ".orangehrm-button-margin.oxd-button.oxd-button--label-danger.oxd-button--medium")
    public WebElement yesDeleteButton;

    @FindBy(xpath = "//td[text()='test']")
    public WebElement addedLog;

    @FindBy(css = ".oxd-text.oxd-text--p.oxd-text--toast-message.oxd-toast-content-text")
    public WebElement successMessage;

    @FindBy(css = "div:nth-of-type(1) > .orangehrm-employee-tracker-log img[alt='profile picture']")
    public WebElement profilePicture;

    @FindBy(css = "div:nth-of-type(1) > .orangehrm-employee-tracker-log .orangehrm-employee-tracker-log-body-text.oxd-text.oxd-text--p")
    public WebElement updatedLog;

    ////////////////////////////////////////////////////////////////////

    public void addTrackerLog(String log, String comment) {
        myTrackersButton.click();
        viewButton.click();
        addLogButton.click();
        logInput.sendKeys(log);
        commentInput.sendKeys(comment);
        saveButton.click();
    }

    public void editTrackerLog(String updateLog, String updateComment) {
        myTrackersButton.click();
        viewButton.click();
        threeDotsButton.click();
        editButton.click();
        logInput.sendKeys(updateLog);
        commentInput.sendKeys(updateComment);
        saveButton.click();
    }

    public void deleteTrackerLog() {
        myTrackersButton.click();
        viewButton.click();
        threeDotsButton.click();
        deleteButton.click();
        yesDeleteButton.click();
    }
/*
    public void verifySuccessMessage() {
        WebElement successMessageLocator = successMessage;
        waitForElementAndAssertText(successMessageLocator, "Successfully Deleted");
    }

 */

    public boolean isProfilePictureDisplayed() {
        return profilePicture.isDisplayed();
    }

    public String updatedValue;

    public void retrieveUpdatedLogText() {
        updatedValue = updatedLog.getText();
    }
}
