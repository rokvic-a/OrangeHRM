package Test;

import Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class TimeTest extends BaseTest {

    @BeforeClass
    public void pageSetUp() {
        String username = resources.getUsername();
        String password = resources.getPassword();
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        loginPage.userLogin(username, password);
        dashboardPage.goToThePage("Time");
    }

    @Test(priority = 1)
    public void addNewProjectFromTime() {
        timePage.addProject("orangehrmvegap", "test");
    }

    @Test(priority = 2)
    public void editNewProjectFromTime() {
        timePage.editProject("update");

        Assert.assertTrue(timePage.nameValue.contains("update"));
    }

    @Test(priority = 3)
    public void searchForProject() {
        timePage.searchProject();

        Assert.assertEquals(timePage.getRecordFoundText(), "(1) Record Found");
    }

    @Test(priority = 4)
    public void deleteNewProjectFromTime() {
        timePage.deleteProject();
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
        }
        Assert.assertEquals(timePage.getRecordFoundText(), "(1) Record Found");
    }
}
