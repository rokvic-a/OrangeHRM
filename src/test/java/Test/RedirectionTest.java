package Test;

import Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class RedirectionTest extends BaseTest {

    @BeforeClass
    public void pageSetUp() {
        String username = resources.getUsername();
        String password = resources.getPassword();
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        loginPage.userLogin(username, password);
    }

    @Test(priority = 1)
    public void redirectToAdmin() {
        dashboardPage.goToThePage("Admin");

        Assert.assertEquals(driver.getCurrentUrl(), "https://opensource-demo.orangehrmlive.com/web/index.php/admin/viewSystemUsers");
    }

    @Test(priority = 2)
    public void redirectToPIM() {
        dashboardPage.goToThePage("PIM");

        Assert.assertEquals(driver.getCurrentUrl(), "https://opensource-demo.orangehrmlive.com/web/index.php/pim/viewEmployeeList");
    }

    @Test(priority = 3)
    public void redirectToLeave() {
        dashboardPage.goToThePage("Leave");

        Assert.assertEquals(driver.getCurrentUrl(), "https://opensource-demo.orangehrmlive.com/web/index.php/leave/viewLeaveList");
    }

    @Test(priority = 4)
    public void redirectToTime() {
        dashboardPage.goToThePage("Time");

        Assert.assertEquals(driver.getCurrentUrl(), "https://opensource-demo.orangehrmlive.com/web/index.php/time/viewEmployeeTimesheet");
    }

    @Test(priority = 5)
    public void redirectToRecruitment() {
        dashboardPage.goToThePage("Recruitment");

        Assert.assertEquals(driver.getCurrentUrl(), "https://opensource-demo.orangehrmlive.com/web/index.php/recruitment/viewCandidates");
    }

    @Test(priority = 6)
    public void redirectToMyInfo() {
        dashboardPage.goToThePage("My Info");

        Assert.assertEquals(driver.getCurrentUrl(), "https://opensource-demo.orangehrmlive.com/web/index.php/pim/viewPersonalDetails/empNumber/7");
    }

    @Test(priority = 7)
    public void redirectToPerformance() {
        dashboardPage.goToThePage("Performance");

        Assert.assertEquals(driver.getCurrentUrl(), "https://opensource-demo.orangehrmlive.com/web/index.php/performance/searchEvaluatePerformanceReview");
    }

    @Test(priority = 8)
    public void redirectToDashboard() {
        dashboardPage.goToThePage("Dashboard");

        Assert.assertEquals(driver.getCurrentUrl(), "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index");
    }

    @Test(priority = 9)
    public void redirectToDirectory() {
        dashboardPage.goToThePage("Directory");

        Assert.assertEquals(driver.getCurrentUrl(), "https://opensource-demo.orangehrmlive.com/web/index.php/directory/viewDirectory");
    }

    @Test(priority = 12)
    public void redirectToMaintenance() {
        dashboardPage.goToThePage("Maintenance");

        Assert.assertEquals(driver.getCurrentUrl(), "https://opensource-demo.orangehrmlive.com/web/index.php/maintenance/purgeEmployee");
    }

    @Test(priority = 10)
    public void redirectToClaim() {
        dashboardPage.goToThePage("Claim");

        Assert.assertEquals(driver.getCurrentUrl(), "https://opensource-demo.orangehrmlive.com/web/index.php/claim/viewAssignClaim");
    }

    @Test(priority = 11)
    public void redirectToBuzz() {
        dashboardPage.goToThePage("Buzz");

        Assert.assertEquals(driver.getCurrentUrl(), "https://opensource-demo.orangehrmlive.com/web/index.php/buzz/viewBuzz");
    }
}
