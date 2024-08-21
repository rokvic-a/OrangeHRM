package Test;

import Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.time.Duration;

public class MyInfoTest extends BaseTest {

    @BeforeClass
    public void pageSetUp() {
        String username = resources.getUsername();
        String password = resources.getPassword();
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        loginPage.userLogin(username, password);
        dashboardPage.goToThePage("My Info");
    }

    @Test
    public void editPersonalDetails() {
        myInfoPage.editPersonalDetails("update");
        myInfoPage.retrievePersonalDetailFieldValues("value");

        Assert.assertTrue(myInfoPage.nameValue.contains("update"));
        Assert.assertTrue(myInfoPage.middleNameValue.contains("update"));
        Assert.assertTrue(myInfoPage.lastNameValue.contains("update"));
        Assert.assertTrue(myInfoPage.idValue.contains("update"));
        Assert.assertTrue(myInfoPage.otherIdValue.contains("update"));
        Assert.assertTrue(myInfoPage.driverLicenceValue.contains("update"));
    }
}
