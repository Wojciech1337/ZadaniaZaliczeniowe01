package pl.coderslab.stepdefinitions;

import io.cucumber.java.en.*;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import pl.coderslab.pages.AddressPage;
import pl.coderslab.pages.NewAddressPage;
import pl.coderslab.pages.LoginPage;

public class AddressSteps {

    // 🔄 WebDriver pobierany z klasy LoginSteps
    private WebDriver driver = LoginSteps.driver;

    //  Inicjalizacja klas Page Object
    private LoginPage loginPage = new LoginPage(driver);
    private AddressPage addressesPage = new AddressPage(driver);
    private NewAddressPage newAddressPage = new NewAddressPage(driver);

    //  Otwiera stronę logowania i loguje użytkownika
    @Given("I am logged in as {string} with password {string}")
    public void iAmLoggedInAsWithPassword(String email, String password) {
        System.out.println("🔑 Logowanie użytkownika: " + email);
        loginPage.open();                    // otwarcie strony logowania
        loginPage.login(email, password);   // wykonanie logowania

    }

    //  Krok przejścia do sekcji adresów
    @When("the user navigates to the Addresses section")
    public void iGoToTheAddressesSection() {
        addressesPage.goToAddressesSection();
    }

    //  Krok kliknięcia "Create new address"
    @Then("the user clicks on {string}")
    public void iClickCreateNewAddress(String buttonText) {
        if ("Create new address".equalsIgnoreCase(buttonText)) {
            addressesPage.clickCreateNewAddress(); // kliknięcie przycisku dodawania adresu
            System.out.println("➕ Kliknięto 'Create new address'");
        } else {
            throw new IllegalArgumentException("❌ Nieobsługiwany przycisk: " + buttonText);
        }
    }

    //  Krok wypełniania formularza adresu
    @And("the user fills in the new address form with alias {string}, address {string}, city {string}, postalCode {string}, country {string}, phone {string}")
    public void theUserFillsInTheNewAddressForm(String alias, String address, String city, String postalCode, String country, String phone) {
        newAddressPage.fillAddressForm(alias, address, city, postalCode, country, phone);  // metoda Page Object
        System.out.println("📝 Formularz adresu wypełniony");
    }

    //  Krok kliknięcia zapisu
    @And("the user clicks the Save button")
    public void theUserClicksTheSaveButton() {
        newAddressPage.clickSave(); // zapisanie nowego adresu
        System.out.println("💾 Kliknięto 'Save'");
    }

    // ✅ Krok walidacji danych adresu
    @Then("the new address with alias {string}, should have correct data  address {string}, city {string}, postalCode {string}, country {string}, phone {string}")
    public void theNewAddressShouldHaveCorrectData(String alias, String address, String city, String postalCode, String country, String phone) {
        // sprawdzamy czy dane są zgodne z tym, co wpisaliśmy
        boolean isCorrect = addressesPage.isAddressDataCorrect(alias, address, city, postalCode, country, phone);

        // użycie asercji JUnit – test nie przejdzie, jeśli adres jest błędny
        Assertions.assertTrue(isCorrect, "❌ Dane adresu są niepoprawne dla aliasu: " + alias);

        // pomocniczy log na konsolę
        System.out.println("✅ Dane adresu dla aliasu '" + alias + "' są poprawne.");
    }
}
