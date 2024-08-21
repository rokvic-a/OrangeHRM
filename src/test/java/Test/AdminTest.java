package Test;

import Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class AdminTest extends BaseTest {

    @BeforeClass
    public void pageSetUp() {
        String username = resources.getUsername();
        String password = resources.getPassword();
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        loginPage.userLogin(username, password);
        dashboardPage.goToThePage("Admin");
    }

    @Test(priority = 4)
    public void configureBuzzModule() throws InterruptedException {
        adminPage.selectOption();
        Thread.sleep(3000);
        Assert.assertFalse(adminPage.isBuzzOptionDisplayed());
    }

    @Test(priority = 1)
    public void addNewUser() {
        adminPage.addUser("Pera", "vega12345");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
        }
        scrollToBottom();
        String isUserAdded = adminPage.getEmployeeName("Pera Peric");
        Assert.assertEquals(isUserAdded, "Pera Peric");
    }

    @Test(priority = 2)
    public void searchNewUser() {
        adminPage.searchUser("Pera");

        String isUserFound = adminPage.getEmployeeName("Pera Peric");
        Assert.assertEquals(isUserFound, "Pera Peric");
    }
}
