package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ResetPasswordPage extends BaseTest {
    public ResetPasswordPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "input[name='username']")
    public WebElement usernameField;

    @FindBy(css = "button[type='submit']")
    public WebElement resetPasswordButton;

    @FindBy(css = ".oxd-text.oxd-text--p.orangehrm-login-forgot-header")
    public WebElement passwordRestore;

    ///////////////////////////////////////

    public void resetPassword(String username) {
        passwordRestore.click();
        usernameField.sendKeys(username);
        resetPasswordButton.click();
    }
}
