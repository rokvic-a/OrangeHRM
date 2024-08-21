package Test;

import Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class SearchTest extends BaseTest {

    @BeforeClass
    public void pageSetUp() {
        String username = resources.getUsername();
        String password = resources.getPassword();
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        loginPage.userLogin(username, password);
    }

    @Test
    public void searchBar() {
        for(String option : dashboardPage.getSearchOptions()) {
            dashboardPage.searchForOption(option);
            String currentValue = dashboardPage.getSearchBarValue();
            Assert.assertEquals(currentValue, option);
        }
    }
}
