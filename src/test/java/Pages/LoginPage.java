package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BaseTest {
    public LoginPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "input[name='username']")
    public WebElement usernameField;

    @FindBy(css = "input[name='password']")
    public WebElement passwordField;

    @FindBy(css = "button[type='submit']")
    public WebElement loginButton;

    @FindBy(css = "span.oxd-input-field-error-message")
    public WebElement errorText;

    @FindBy(css = "p.oxd-alert-content-text")
    public WebElement invalidCredentialsError;

    ///////////////////////////////////////////////


    public void userLogin(String username, String password) {
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        loginButton.click();

    }

    public String getErrorText() {
        return errorText.getText();
    }

    public String getInvalidCredentialsErrorText() {
        return invalidCredentialsError.getText();
    }
}
