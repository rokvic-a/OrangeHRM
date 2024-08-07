import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class Task1 {

    public static void main(String[] args)  {

        WebDriver driver;

        driver = new ChromeDriver();

        String URL = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
        String website = "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index";
        String adminPage = "https://opensource-demo.orangehrmlive.com/web/index.php/admin/viewSystemUsers";
        String pimPage = "https://opensource-demo.orangehrmlive.com/web/index.php/pim/viewEmployeeList";
        String leavePage = "https://opensource-demo.orangehrmlive.com/web/index.php/leave/viewLeaveList";
        String timePage = "https://opensource-demo.orangehrmlive.com/web/index.php/time/viewEmployeeTimesheet";
        String recruitmentPage = "https://opensource-demo.orangehrmlive.com/web/index.php/recruitment/viewCandidates";
        String myInfoPage = "https://opensource-demo.orangehrmlive.com/web/index.php/pim/viewPersonalDetails/empNumber/7";
        String performancePage = "https://opensource-demo.orangehrmlive.com/web/index.php/performance/searchEvaluatePerformanceReview";
        String dashboardPage = "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index";
        String directoryPage = "https://opensource-demo.orangehrmlive.com/web/index.php/directory/viewDirectory";
        String claimPage = "https://opensource-demo.orangehrmlive.com/web/index.php/claim/viewAssignClaim";
        String buzzPage = "https://opensource-demo.orangehrmlive.com/web/index.php/buzz/viewBuzz";

        driver.get(URL);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        WebElement userNameInput = driver.findElement(By.cssSelector("input[name='username']"));
        WebElement passwordInput = driver.findElement(By.cssSelector("input[name='password']"));
        WebElement submitButton = driver.findElement(By.cssSelector("button[type='submit']"));
        userNameInput.sendKeys("Admin");
        passwordInput.sendKeys("admin123");
        submitButton.click();
        Assert.assertEquals(driver.getCurrentUrl(), website);

        WebElement adminModule = driver.findElement(By.cssSelector("a[href='/web/index.php/admin/viewAdminModule']"));
        adminModule.click();
        Assert.assertEquals(driver.getCurrentUrl(), adminPage);

        WebElement pimModule = driver.findElement(By.cssSelector("a[href='/web/index.php/pim/viewPimModule']"));
        pimModule.click();
        Assert.assertEquals(driver.getCurrentUrl(),pimPage);

        WebElement leaveModule = driver.findElement(By.cssSelector("a[href='/web/index.php/leave/viewLeaveModule']"));
        leaveModule.click();
        Assert.assertEquals(driver.getCurrentUrl(), leavePage);

        WebElement timeModule = driver.findElement(By.cssSelector("a[href='/web/index.php/time/viewTimeModule']"));
        timeModule.click();
        Assert.assertEquals(driver.getCurrentUrl(), timePage);

        WebElement recruitmentModule = driver.findElement(By.cssSelector("a[href='/web/index.php/recruitment/viewRecruitmentModule']"));
        recruitmentModule.click();
        Assert.assertEquals(driver.getCurrentUrl(), recruitmentPage);

        WebElement myInfoModule = driver.findElement(By.cssSelector("a[href='/web/index.php/pim/viewMyDetails']"));
        myInfoModule.click();
        Assert.assertEquals(driver.getCurrentUrl(), myInfoPage);

        WebElement performanceModule = driver.findElement(By.cssSelector("a[href='/web/index.php/performance/viewPerformanceModule']"));
        performanceModule.click();
        Assert.assertEquals(driver.getCurrentUrl(), performancePage);

        WebElement dashboardModule = driver.findElement(By.cssSelector("a[href='/web/index.php/dashboard/index']"));
        dashboardModule.click();
        Assert.assertEquals(driver.getCurrentUrl(), dashboardPage);

        WebElement directoryModule = driver.findElement(By.cssSelector("a[href='/web/index.php/directory/viewDirectory']"));
        directoryModule.click();
        Assert.assertEquals(driver.getCurrentUrl(), directoryPage);

        WebElement claimModule = driver.findElement(By.cssSelector("a[href='/web/index.php/claim/viewClaimModule']"));
        claimModule.click();
        Assert.assertEquals(driver.getCurrentUrl(),claimPage);

        WebElement buzzModule = driver.findElement(By.cssSelector("a[href='/web/index.php/buzz/viewBuzz']"));
        buzzModule.click();
        Assert.assertEquals(driver.getCurrentUrl(), buzzPage);
        }
    }





