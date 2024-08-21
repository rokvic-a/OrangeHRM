package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MaintenancePage extends BaseTest {
    public MaintenancePage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "input[name='password']")
    public WebElement passwordField;

    @FindBy(css = ".orangehrm-admin-access-button.oxd-button.oxd-button--large.oxd-button--secondary")
    public WebElement confirmButton;

    ////////////////////////////////////////////////////////////////////

    public void maintenanceLogin(String password) {
        passwordField.sendKeys(password);
        confirmButton.click();
    }


}
