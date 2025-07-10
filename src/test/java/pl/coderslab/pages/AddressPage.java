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

    // ======= Lokatory elementów na stronie =======

    // Link prowadzący do sekcji "Addresses" w koncie użytkownika
    @FindBy(xpath = "//a[@title='Addresses']")
    private WebElement addressesSectionLink;

    // Przycisk "Create new address"
    @FindBy(css = "a[data-link-action='add-address']")
    private WebElement createNewAddressButton;

    // Komunikat sukcesu po dodaniu/usunięciu adresu
    @FindBy(css = "article.alert.alert-success")
    private WebElement successAlert;

    // ======= Konstruktor =======

    // Inicjalizuje WebDriver, WebDriverWait oraz inicjuje elementy przy pomocy PageFactory
    public AddressPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    // ======= Metody działania =======

    // 🔹 Przejście do sekcji adresów z poziomu konta użytkownika
    // Wymagane przed dodaniem lub usunięciem adresu
    public void goToAddressesSection() {
        addressesSectionLink.click();
    }

    // 🔹 Kliknięcie w przycisk "Create new address"
    // Otwiera formularz do dodania nowego adresu
    public void clickCreateNewAddress() {
        createNewAddressButton.click();
    }

    // 🔹 Sprawdza, czy adres o podanym aliasie jest wyświetlany na stronie
    // Używane do weryfikacji poprawności dodania adresu
    public boolean isAddressDisplayed(String alias) {
        try {
            WebElement aliasHeader = driver.findElement(By.xpath(
                    "//article[contains(@class,'address')]//h4[text()='" + alias + "']"));
            return aliasHeader.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    // 🔹 Usuwa adres na podstawie aliasu (nazwa adresu widoczna jako nagłówek)
    // Wyszukuje odpowiedni blok adresu i klika w przycisk usuwania
    public void deleteAddress(String alias) {
        try {
            WebElement addressBlock = driver.findElement(By.xpath(
                    "//article[contains(@class,'address')][.//h4[text()='" + alias + "']]"));
            WebElement deleteButton = addressBlock.findElement(By.cssSelector("a[data-link-action='delete-address']"));
            deleteButton.click();
            wait.until(ExpectedConditions.visibilityOf(successAlert));
        } catch (Exception e) {
            System.err.println("Błąd podczas usuwania adresu: " + e.getMessage());
            throw new RuntimeException("Nie udało się usunąć adresu o aliasie: " + alias, e);
        }

}

    // 🔹 Sprawdzenie, czy pojawił się komunikat sukcesu z określonym tekstem
    // Może być używane po dodaniu lub usunięciu adresu
    public boolean isSuccessMessageDisplayed(String expectedText) {
        try {
            return successAlert.isDisplayed() && successAlert.getText().contains(expectedText);
        } catch (Exception e) {
            return false;
        }
    }
}
