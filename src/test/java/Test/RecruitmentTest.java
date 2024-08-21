package Test;

import Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class RecruitmentTest extends BaseTest {

    @BeforeClass
    public void pageSetUp() {
        String username = resources.getUsername();
        String password = resources.getPassword();
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        loginPage.userLogin(username, password);
        dashboardPage.goToThePage("Recruitment");
    }

    @Test(priority = 1)
    public void addNewCandidate() {
        recruitmentPage.addCandidate("Mita", "Mitic", "mita.mitic@gmail.com", "vegatest");

        Assert.assertTrue(recruitmentPage.isRejectButtonDisplayed());
    }

    @Test(priority = 2)
    public void viewNewCandidate() {
        recruitmentPage.clickOnRecruitment();
        recruitmentPage.viewCandidate("Mita");

        Assert.assertTrue(recruitmentPage.isRejectButtonDisplayed());
    }

    @Test(priority = 3)
    public void deleteNewCandidate() {
        recruitmentPage.clickOnRecruitment();
        recruitmentPage.deleteCandidate("Mita");
    }
}
