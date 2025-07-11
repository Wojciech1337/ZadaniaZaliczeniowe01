package pl.coderslab.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AccountPage {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(css = "a[href*='mylogout']")
    private WebElement signOutLink;

    public AccountPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public boolean isSignOutVisible() {
        try {
            wait.until(ExpectedConditions.visibilityOf(signOutLink));
            return signOutLink.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    }

