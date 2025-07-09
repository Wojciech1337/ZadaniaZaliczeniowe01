package pl.coderslab.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountPage {

    private WebDriver driver;

    // ======= Lokatory =======
    @FindBy(css = "h1.page-title")
    private WebElement accountHeader;

    @FindBy(css = "a[data-link-action='addresses']")
    private WebElement addressesLink;

    // ======= Konstruktor =======
    public AccountPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // ======= Metody =======
    public boolean isOnAccountPage() {
        try {
            String headerText = accountHeader.getText().trim();
            return headerText.equalsIgnoreCase("Your account");
        } catch (Exception e) {
            return false;
        }
    }

    public void goToAddresses() {
        addressesLink.click();
    }
}
