package pl.coderslab.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AddressPage {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(xpath = "//a[@title='Addresses']")
    private WebElement addressesSectionLink;

    @FindBy(css = "a[data-link-action='add-address']")
    private WebElement createNewAddressButton;

    @FindBy(css = "article.alert.alert-success")
    private WebElement successAlert;

    public AddressPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    // 🔹 Przejście do sekcji Addresses
    public void goToAddressesSection() {
        System.out.println("📬 Przechodzę do sekcji 'Addresses'");
        addressesSectionLink.click();
    }

    // 🔹 Kliknięcie "Create new address"
    public void clickCreateNewAddress() {
        System.out.println("📝 Klikam 'Create new address'");
        createNewAddressButton.click();
    }

    // 🔹 Sprawdzenie, czy adres o aliasie istnieje
    public boolean isAddressDisplayed(String alias) {
        try {
            WebElement aliasHeader = driver.findElement(By.xpath(
                    "//article[contains(@class,'address')]//h4[text()='" + alias + "']"));
            boolean visible = aliasHeader.isDisplayed();
            System.out.println("🔍 Sprawdzam czy adres '" + alias + "' jest widoczny: " + visible);
            return visible;
        } catch (Exception e) {
            System.out.println("⚠️ Alias '" + alias + "' nie został znaleziony.");
            return false;
        }
    }

    // 🔹 Usunięcie adresu po aliasie (bez obsługi alertu JS i bez dodatkowych logów)
    public void deleteAddress(String alias) {
        try {
            WebElement addressBlock = driver.findElement(By.xpath(
                    "//article[contains(@class,'address')][.//h4[text()='" + alias + "']]"));
            WebElement deleteButton = addressBlock.findElement(By.cssSelector("a[data-link-action='delete-address']"));
            deleteButton.click();

            // Czekamy na pojawienie się komunikatu sukcesu
            wait.until(ExpectedConditions.visibilityOf(successAlert));
            System.out.println("✅ Adres '" + alias + "' został usunięty.");
        } catch (Exception e) {
            System.out.println("❌ Nie udało się usunąć adresu '" + alias + "'");
            e.printStackTrace();
        }
    }

    // 🔹 Sprawdzenie komunikatu sukcesu
    public boolean isSuccessMessageDisplayed(String expectedText) {
        try {
            boolean visible = successAlert.isDisplayed() && successAlert.getText().contains(expectedText);
            System.out.println("📢 Sprawdzam komunikat sukcesu: " + visible);
            return visible;
        } catch (Exception e) {
            System.out.println("❌ Komunikat sukcesu nie został znaleziony.");
            return false;
        }
    }
}
