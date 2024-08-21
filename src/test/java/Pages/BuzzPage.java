package Pages;

import Base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class BuzzPage extends BaseTest {
    public BuzzPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".oxd-buzz-post-input")
    public WebElement postInput;

    @FindBy(css = ".oxd-button.oxd-button--main.oxd-button--medium")
    public WebElement postButton;

    @FindBy(css = "path#heart")
    public WebElement likeButton;

    @FindBy(css = "div:nth-of-type(1) > .orangehrm-buzz.oxd-sheet.oxd-sheet--rounded.oxd-sheet--white .orangehrm-buzz-post-body-text.oxd-text.oxd-text--p")
    public WebElement postText;

    @FindBy(css = "div:nth-of-type(1) > .orangehrm-buzz.oxd-sheet.oxd-sheet--rounded.oxd-sheet--white  .orangehrm-buzz-stats > div:nth-of-type(1) > .oxd-text.oxd-text--p")
    public WebElement likeText;

    @FindBy(css = "div:nth-of-type(1) > .orangehrm-buzz.oxd-sheet.oxd-sheet--rounded.oxd-sheet--white  .orangehrm-buzz-post-actions > button:nth-of-type(1) > .bi-chat-text-fill.oxd-icon")
    public WebElement commentButton;

    @FindBy(css = ".oxd-form .oxd-input")
    public WebElement commentInput;

    @FindBy(css = "div:nth-of-type(2) > .orangehrm-post-comment > .orangehrm-post-comment-area > .orangehrm-post-comment-text.oxd-text.oxd-text--span")
    public WebElement commentText;

    @FindBy(className = "orangehrm-post-filters-button")
    public List<WebElement> sortButtonsList;

    @FindBy(css = ".post-container")
    public List<WebElement> postElements;


    ///////////////////////////////////////////////////////////////////////

    public void writePost(String text) {
        postInput.sendKeys(text);
        postButton.click();
    }

    public String getPostText() {
        return postText.getText();
    }

    public String getLikeText() {
        return likeText.getText();
    }

    public String getCommentText() {
        return commentText.getText();
    }

    public void commentPost(String comment) {
        commentButton.click();
        commentInput.sendKeys(comment);
        commentInput.sendKeys(Keys.ENTER);
    }

    public void likePost() {
        likeButton.click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }
    }

    public void sortPosts(String sortingMethod) {
        for (int i = 0; i < sortButtonsList.size(); i++) {
            if (sortingMethod.equals("Most Recent Posts")) {
                sortButtonsList.get(0).click();
            } else if (sortingMethod.equals("Most Liked Posts")) {
                sortButtonsList.get(1).click();
            } else if (sortingMethod.equals("Most Commented Posts")) {
                sortButtonsList.get(2).click();
            }
        }
    }

    public void arePostsSortedByLikes() {
        List<Integer> likeCounts = new ArrayList<>();
        for (WebElement post : postElements) {
            String likesText = post.findElement(By.cssSelector(".likes-count")).getText();
            int likes = Integer.parseInt(likesText.replace(" Likes", ""));
            likeCounts.add(likes);
        }

        boolean isSorted = true;
        for (int i = 0; i < likeCounts.size() - 1; i++) {
            if (likeCounts.get(i) < likeCounts.get(i + 1)) {
                isSorted = false;
                break;
            }
        }
        Assert.assertTrue(isSorted);
    }

    public void arePostsSortedByComments() {
        List<WebElement> postElements = driver.findElements(By.cssSelector(".post-container"));
        List<Integer> commentCounts = new ArrayList<>();
        for (WebElement post : postElements) {
            String commentsText = post.findElement(By.cssSelector(".comments-count")).getText();
            int comments = Integer.parseInt(commentsText.replace(" Comments", ""));
            commentCounts.add(comments);
        }

        boolean isSortedByComments = true;
        for (int i = 0; i < commentCounts.size() - 1; i++) {
            if (commentCounts.get(i) < commentCounts.get(i + 1)) {
                isSortedByComments = false;
                break;
            }
        }
        Assert.assertTrue(isSortedByComments);
    }

    public void arePostsSortedByDate() {
        List<WebElement> postElements = driver.findElements(By.cssSelector(".post-container"));
        List<LocalDateTime> postDates = new ArrayList<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM d, yyyy h:mm a");

        for (WebElement post : postElements) {
            String dateText = post.findElement(By.cssSelector(".post-date")).getText();
            LocalDateTime postDate = LocalDateTime.parse(dateText, formatter);
            postDates.add(postDate);
        }

        boolean isSortedByRecent = true;
        for (int i = 0; i < postDates.size() - 1; i++) {
            if (postDates.get(i).isBefore(postDates.get(i + 1))) {
                isSortedByRecent = false;
                break;
            }
        }
        Assert.assertTrue(isSortedByRecent);
    }
}



