package Test;

import Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.time.Duration;

public class LoginTest extends BaseTest {

    @BeforeMethod
    public void pageSetUp() {
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test(priority = 8)
    public void loginWithValidCredentials() {
        String username = resources.getUsername();
        String password = resources.getPassword();

        loginPage.userLogin(username,password );

        Assert.assertEquals(driver.getCurrentUrl(), "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index");
        Assert.assertTrue(dashboardPage.isUpgradeButtonDisplayed());
    }

    @Test(priority = 5)
    public void loginWithEmptyUsernameAndPassword() {
        loginPage.userLogin("", "");

        Assert.assertEquals(driver.getCurrentUrl(), "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        Assert.assertEquals(loginPage.getErrorText(), "Required");
    }

    @Test(priority = 1)
    public void loginWithoutUsername() {
        String password = resources.getPassword();

        loginPage.userLogin("", password);

        Assert.assertEquals(driver.getCurrentUrl(), "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        Assert.assertEquals(loginPage.getErrorText(), "Required");
    }

    @Test(priority = 2)
    public void loginWithoutPassword() {
        String username = resources.getUsername();
        loginPage.userLogin(username, "");

        Assert.assertEquals(driver.getCurrentUrl(), "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        Assert.assertEquals(loginPage.getErrorText(), "Required");
    }

    @Test(priority = 6)
    public void loginWithInvalidUsername() {
        String password = resources.getPassword();
        loginPage.userLogin("adminfff", password);

        Assert.assertEquals(driver.getCurrentUrl(), "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        Assert.assertEquals(loginPage.getInvalidCredentialsErrorText(), "Invalid credentials");
    }

    @Test(priority = 7)
    public void loginWithInvalidPassword() {
        String username = resources.getUsername();
        loginPage.userLogin(username, "admin1234");

        Assert.assertEquals(driver.getCurrentUrl(), "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        Assert.assertEquals(loginPage.getInvalidCredentialsErrorText(), "Invalid credentials");
    }

    @Test(priority = 3)
    public void passwordRestore() {
        String username = resources.getUsername();
        resetPasswordPage.resetPassword(username);

        Assert.assertEquals(driver.getCurrentUrl(), "https://opensource-demo.orangehrmlive.com/web/index.php/auth/sendPasswordReset");
    }

    @Test(priority = 4)
    public void userLogOut() {
        String username = resources.getUsername();
        String password = resources.getPassword();
        loginPage.userLogin(username, password);
        dashboardPage.logOut();

        Assert.assertEquals(driver.getCurrentUrl(), "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }
}
