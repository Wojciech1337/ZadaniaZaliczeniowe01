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

    // Link do sekcji adresów
    @FindBy(xpath = "//a[@title='Addresses']")
    private WebElement addressesSectionLink;

    // Przycisk dodawania nowego adresu
    @FindBy(css = "a[data-link-action='add-address']")
    private WebElement createNewAddressButton;


    @FindBy(css = "article.alert.alert-success")
    private WebElement successAlert;

    // Konstruktor klasy - inicjalizuje PageFactory oraz WebDriverWait
    public AddressPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public void goToAddressesSection() {
        addressesSectionLink.click();
    }


    public void clickCreateNewAddress() {
        createNewAddressButton.click();
    }

    // Sprawdzenie, czy adres o podanym aliasie istnieje na stronie
    public boolean isAddressDisplayed(String alias) {
        try {
            WebElement aliasHeader = driver.findElement(By.xpath(
                    "//article[contains(@class,'address')]//h4[text()='" + alias + "']"));
            return aliasHeader.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    // Usuwanie adresu o podanym aliasie
    public void deleteAddress(String alias) {
        try {
            // Znajduje cały blok adresu dla danego aliasu
            WebElement addressBlock = driver.findElement(By.xpath(
                    "//article[contains(@class,'address')][.//h4[text()='" + alias + "']]"));

            // Wyszukuje przycisk usunięcia w tym bloku
            WebElement deleteButton = addressBlock.findElement(By.cssSelector("a[data-link-action='delete-address']"));

            deleteButton.click();

            // Czeka na pojawienie się komunikatu sukcesu
            wait.until(ExpectedConditions.visibilityOf(successAlert));
        } catch (Exception e) {
            System.err.println("Błąd podczas usuwania adresu: " + e.getMessage());
            throw new RuntimeException("Nie udało się usunąć adresu o aliasie: " + alias, e);
        }
    }

    // Sprawdzenie, czy pojawił się komunikat sukcesu z oczekiwanym tekstem
    public boolean isSuccessMessageDisplayed(String expectedText) {
        try {
            return successAlert.isDisplayed() && successAlert.getText().contains(expectedText);
        } catch (Exception e) {
            return false;
        }
    }

    // Weryfikacja poprawności danych adresu na podstawie aliasu i podanych wartości
    public boolean isAddressDataCorrect(String alias, String address, String city, String postalCode, String country, String phone) {
        try {
            // Znajduje blok adresu pasujący do aliasu
            WebElement addressBlock = driver.findElement(By.xpath(
                    "//article[contains(@class,'address')][.//h4[text()='" + alias + "']]"));

            // Pobiera cały tekst z bloku adresowego
            String fullText = addressBlock.getText();

            // Sprawdza, czy wszystkie podane dane znajdują się w tekście
            boolean correct =
                    fullText.contains(address) &&
                            fullText.contains(city) &&
                            fullText.contains(postalCode) &&
                            fullText.contains(country) &&
                            fullText.contains(phone);

            return correct;

        } catch (Exception e) {
            System.out.println("❌ Nie znaleziono bloku adresu dla aliasu: " + alias);
            return false;
        }
    }
}
