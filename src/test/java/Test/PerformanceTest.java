package Test;

import Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.time.Duration;

public class PerformanceTest extends BaseTest {

    @BeforeClass
    public void pageSetUp() {
        String username = resources.getUsername();
        String password = resources.getPassword();
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        loginPage.userLogin(username, password);
        dashboardPage.goToThePage("Performance");
    }

    @Test(priority = 1)
    public void addNewTrackerLog() {
        performancePage.addTrackerLog("test", "vega");

        Assert.assertTrue(performancePage.isProfilePictureDisplayed());
    }

    @Test(priority = 2)
    public void editNewTrackerLog() {
        performancePage.editTrackerLog("update", "update");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
        }
        performancePage.retrieveUpdatedLogText();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
        }
        Assert.assertTrue(performancePage.updatedValue.contains("update"));
    }

    @Test(priority = 3)
    public void deleteNewTrackerLog() {
        performancePage.deleteTrackerLog();
    }
}
