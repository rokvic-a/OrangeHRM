package Test;

import Base.BaseTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class CleanUp extends BaseTest {

    @BeforeClass
    public void pageSetUp() {
        String username = resources.getUsername();
        String password = resources.getPassword();
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        loginPage.userLogin(username, password);
    }
/*
    @Test (priority = 2)
    public void deleteNewEmployeeFromPIM() {
        dashboardPage.goToThePage("PIM");
        pimPage.deleteEmployeeByStoredId();

        String noRecordFoundText = pimPage.getNoRecordsFoundText();
        Assert.assertEquals(noRecordFoundText, "No Records Found");
    }

 */

    @Test (priority = 1)
    public void deleteNewUserFromAdmin() {
        dashboardPage.goToThePage("Admin");
        adminPage.deleteUser("Pera");
    }
}
