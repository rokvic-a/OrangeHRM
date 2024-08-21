package Pages;

import Base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class DashboardPage extends BaseTest {


    public DashboardPage() {
        PageFactory.initElements(driver, this);
    }

    public List<String> getSearchOptions() {
        return Arrays.asList("Admin", "PIM", "Leave", "Time", "Recruitment", "My Info", "Performance", "Dashboard", "Directory", "Maintenance", "Claim", "Buzz");
    }

    @FindBy(css = "button.orangehrm-upgrade-button")
    public WebElement upgradeButton;

    @FindBy(css = ".oxd-userdropdown-tab")
    public WebElement profileMenu;

    @FindBy(css = "a[role='menuitem'][href='/web/index.php/auth/logout']")
    public WebElement logoutButton;

    @FindBy(css = "input[placeholder='Search']")
    public WebElement searchBar;


    @FindBy(className = "oxd-main-menu-item")
    public List<WebElement> navigationItems;

    /////////////////////////////////////////////////////


    public void goToThePage(String elementName) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("oxd-main-menu")));
        for (WebElement el : navigationItems) {
            if (el.getText().equals(elementName)) {
                el.click();
                break;
            }
        }
    }

    public void logOut() {
        profileMenu.click();
        logoutButton.click();
    }

    public boolean isUpgradeButtonDisplayed() {
        return upgradeButton.isDisplayed();
    }

    public String getSearchBarValue() {
        return searchBar.getAttribute("value");
    }

    public void searchForOption(String option) {
        searchBar.click();
        searchBar.sendKeys(Keys.CONTROL + "a");
        searchBar.sendKeys(Keys.DELETE);
        searchBar.sendKeys(option);

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}














