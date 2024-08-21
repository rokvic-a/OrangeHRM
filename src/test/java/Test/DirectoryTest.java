package Test;

import Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class DirectoryTest extends BaseTest {

    @BeforeClass
    public void pageSetUp() {
        String username = resources.getUsername();
        String password = resources.getPassword();
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        loginPage.userLogin(username, password);
        dashboardPage.goToThePage("Directory");
    }

    @Test(priority = 1)
    public void searchEmployeeByName() throws InterruptedException {
        directoryPage.searchByName("Pera");
        Thread.sleep(5000);

        Assert.assertEquals(directoryPage.getRecordFoundText(), "(1) Record Found");
    }

    @Test(priority = 2)
    public void searchEmployeeByJobTitle() throws InterruptedException {
        driver.navigate().refresh();
        directoryPage.searchByJobTitle();
        Thread.sleep(3000);

       Assert.assertEquals(directoryPage.getRecordFoundText(), "No Records Found");
    }

    @Test(priority = 3)
    public void searchEmployeeByLocation() throws InterruptedException {
        driver.navigate().refresh();
        directoryPage.searchByLocation();
        Thread.sleep(3000);

        Assert.assertEquals(directoryPage.getRecordFoundText(), "No Records Found");
    }

    @Test(priority = 4)
    public void searchEmployeeUsingAllFilters() throws InterruptedException {
        driver.navigate().refresh();
        directoryPage.searchUsingAllFilters("Pera");
        Thread.sleep(3000);

        Assert.assertEquals(directoryPage.getRecordFoundText(), "No Records Found");
    }
}
