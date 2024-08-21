package Test;

import Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.time.Duration;

public class PIMTest extends BaseTest {

    @BeforeClass
    public void pageSetUp() {
        String username = resources.getUsername();
        String password = resources.getPassword();
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        loginPage.userLogin(username, password);
        dashboardPage.goToThePage("PIM");
    }

    @Test(priority = 1)
    public void addNewEmployee() {
        pimPage.addEmployeeAndStoreId("Mika", "Mikic");

        String storedEmployeeId = pimPage.getStoredEmployeeId();
        Assert.assertNotNull(storedEmployeeId);
    }

    @Test(priority = 2)
    public void editNewEmployee() {
        pimPage.editEmployeeDetails("Pera", "Peric");
        pimPage.pimLink.click();
        pimPage.searchEmployeeByStoredId();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
        }
        String updatedEmployeeName = pimPage.getEmployeeNameFromResults();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
        }
        Assert.assertEquals(updatedEmployeeName, "Pera");
    }

    @Test(priority = 3)
    public void searchNewEmployee() {
        pimPage.searchEmployeeByStoredId();
        String recordFoundText = pimPage.getRecordFoundText();

        Assert.assertEquals(recordFoundText, "(1) Record Found");

    }
}
