package Base;

import Pages.*;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.time.Duration;
import java.util.Random;

public class BaseTest {

    public static WebDriver driver;
    public static WebDriverWait wait;
    public LoginPage loginPage;
    public AdminPage adminPage;
    public BuzzPage buzzPage;
    public ClaimPage claimPage;
    public DashboardPage dashboardPage;
    public DirectoryPage directoryPage;
    public LeavePage leavePage;
    public MaintenancePage maintenancePage;
    public MyInfoPage myInfoPage;
    public PerformancePage performancePage;
    public PIMPage pimPage;
    public RecruitmentPage recruitmentPage;
    public ResetPasswordPage resetPasswordPage;
    public TimePage timePage;
    public Resources resources;


    @BeforeClass
    public void beforeClass() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        adminPage = new AdminPage();
        buzzPage = new BuzzPage();
        claimPage = new ClaimPage();
        directoryPage = new DirectoryPage();
        dashboardPage = new DashboardPage();
        leavePage = new LeavePage();
        maintenancePage = new MaintenancePage();
        myInfoPage = new MyInfoPage();
        performancePage = new PerformancePage();
        pimPage = new PIMPage();
        recruitmentPage = new RecruitmentPage();
        resetPasswordPage = new ResetPasswordPage();
        timePage = new TimePage();
        loginPage = new LoginPage();
        resources = new Resources("C:\\Users\\aleksandar.rokvic\\Desktop/credentials.txt");
    }

    //--------------------HELPERS--------------------------


    public void scrollToBottom() {
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight);");
    }


    private static final String[] adjectives = {
            "Cool", "Fast", "Clever", "Happy", "Brave", "Bright", "Witty", "Smart", "Fierce", "Loyal"
    };

    private static final String[] nouns = {
            "Tiger", "Eagle", "Lion", "Shark", "Wolf", "Falcon", "Panther", "Fox", "Bear", "Dragon"
    };

    private static final Random random = new Random();

    public static String generateUsername() {
        String adjective = adjectives[random.nextInt(adjectives.length)];
        String noun = nouns[random.nextInt(nouns.length)];
        int number = random.nextInt(1000);
        return adjective + noun + number;
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
