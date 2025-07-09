package pl.coderslab.stepdefinitions;

import io.cucumber.java.en.*;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import pl.coderslab.pages.AddressPage;
import pl.coderslab.pages.NewAddressPage;
import pl.coderslab.pages.LoginPage;

public class AddressSteps {

    // Pobieramy WebDriver z klasy LoginSteps, aby współdzielić sesję przeglądarki
    private WebDriver driver = LoginSteps.driver;

    // Inicjalizacja obiektów reprezentujących strony
    private LoginPage loginPage = new LoginPage(driver);
    private AddressPage addressesPage = new AddressPage(driver);
    private NewAddressPage newAddressPage = new NewAddressPage(driver);

    // Krok logowania użytkownika
    @Given("I am logged in as {string} with password {string}")
    public void iAmLoggedInAsWithPassword(String email, String password) {
        loginPage.open();           // Otwieramy stronę logowania
        loginPage.login(email, password);  // Wykonujemy logowanie
    }

    // Krok przejścia do sekcji adresów
    @When("the user navigates to the Addresses section")
    public void iGoToTheAddressesSection() {
        addressesPage.goToAddressesSection();
    }

    // Krok kliknięcia przycisku "Create new address"
    @Then("the user clicks on {string}")
    public void iClickCreateNewAddress(String buttonText) {
        if ("Create new address".equalsIgnoreCase(buttonText)) {
            addressesPage.clickCreateNewAddress();
        } else {
            // Wyrzucamy wyjątek, gdy pojawi się nieobsługiwany tekst przycisku
            throw new IllegalArgumentException("Button text not supported: " + buttonText);
        }
    }

    // Krok wypełnienia formularza nowego adresu parametrami z pliku feature
    @And("the user fills in the new address form with alias {string}, address {string}, city {string}, postalCode {string}, country {string}, phone {string}")
    public void theUserFillsInTheNewAddressForm(String alias, String address, String city, String postalCode, String country, String phone) {
        newAddressPage.fillAddressForm(alias, address, city, postalCode, country, phone);
    }

    // Krok kliknięcia przycisku zapisu nowego adresu
    @And("the user clicks the Save button")
    public void theUserClicksTheSaveButton() {
        newAddressPage.clickSave();
    }

    // Weryfikacja, że nowy adres został poprawnie dodany do listy adresów
    @Then("the new address {string} should be displayed in the address list")
    public void theNewAddressIsDisplayedInTheAddressList(String alias) {
        Assertions.assertTrue(addressesPage.isAddressDisplayed(alias), "Address not found: " + alias);
    }
}
