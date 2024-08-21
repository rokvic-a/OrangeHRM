package Test;

import Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class BuzzTest extends BaseTest {

    @BeforeClass
    public void pageSetUp() {
        String username = resources.getUsername();
        String password = resources.getPassword();
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        loginPage.userLogin(username, password);
        dashboardPage.goToThePage("Buzz");
    }

    @Test(priority = 1)
    public void sharePostOnBuzz() {
        buzzPage.writePost("testvega");

        Assert.assertEquals(buzzPage.getPostText(), "testvega");
    }

    @Test(priority = 2)
    public void likePostOnBuzz() {
        buzzPage.likePost();

        Assert.assertEquals(buzzPage.getLikeText(), "1 Like");
    }

    @Test(priority = 3)
    public void commentPostOnBuzz() {
        buzzPage.commentPost("komentar");

        Assert.assertEquals(buzzPage.getCommentText(), "komentar");
    }

    @Test(priority = 4)
    public void sortPostsByLikes() {
        buzzPage.sortPosts("Most Liked Posts");
        buzzPage.arePostsSortedByLikes();
    }

    @Test(priority = 5)
    public void sortPostsByComments() {
        buzzPage.sortPosts("Most Commented Posts");
        buzzPage.arePostsSortedByComments();
    }

    @Test(priority = 6)
    public void sortPostsByDate() {
        buzzPage.sortPosts("Most Recent Posts");
        buzzPage.arePostsSortedByDate();
    }
}
