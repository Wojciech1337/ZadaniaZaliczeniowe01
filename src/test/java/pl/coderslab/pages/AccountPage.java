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

    @FindBy(css = "h1.page-title")
    private WebElement accountHeader;

    public AccountPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public boolean isOnAccountPage() {
        try {
            wait.until(ExpectedConditions.visibilityOf(accountHeader));
            String headerText = accountHeader.getText().trim();
            return headerText.equalsIgnoreCase("Your account");
        } catch (Exception e) {
            return false;
        }
    }
}
