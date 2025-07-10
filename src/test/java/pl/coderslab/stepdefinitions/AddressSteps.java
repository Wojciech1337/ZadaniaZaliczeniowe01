package pl.coderslab.stepdefinitions;

import io.cucumber.java.en.*;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import pl.coderslab.pages.AddressPage;
import pl.coderslab.pages.NewAddressPage;
import pl.coderslab.pages.LoginPage;

public class AddressSteps {

    // 🚀 Pobieramy WebDriver z LoginSteps - współdzielimy sesję
    private WebDriver driver = LoginSteps.driver;

    // 🖥️ Inicjalizacja obiektów stron
    private LoginPage loginPage = new LoginPage(driver);
    private AddressPage addressesPage = new AddressPage(driver);
    private NewAddressPage newAddressPage = new NewAddressPage(driver);

    // 🔐 Krok logowania użytkownika
    @Given("I am logged in as {string} with password {string}")
    public void iAmLoggedInAsWithPassword(String email, String password) {
        System.out.println("🔑 Logowanie użytkownika: " + email);
        loginPage.open();
        loginPage.login(email, password);
        System.out.println("✅ Użytkownik zalogowany");
    }

    // 🏠 Krok przejścia do sekcji adresów
    @When("the user navigates to the Addresses section")
    public void iGoToTheAddressesSection() {
        addressesPage.goToAddressesSection();
    }

    // 🆕 Krok kliknięcia "Create new address"
    @Then("the user clicks on {string}")
    public void iClickCreateNewAddress(String buttonText) {
        if ("Create new address".equalsIgnoreCase(buttonText)) {
            addressesPage.clickCreateNewAddress();
            System.out.println("✅ Kliknięto 'Create new address'");
        } else {
            throw new IllegalArgumentException("❌ Nieobsługiwany przycisk: " + buttonText);
        }
    }

    // 📝 Krok wypełniania formularza nowego adresu
    @And("the user fills in the new address form with alias {string}, address {string}, city {string}, postalCode {string}, country {string}, phone {string}")
    public void theUserFillsInTheNewAddressForm(String alias, String address, String city, String postalCode, String country, String phone) {
        newAddressPage.fillAddressForm(alias, address, city, postalCode, country, phone);
        System.out.println("✅ Formularz adresu wypełniony");
    }

    // 💾 Krok kliknięcia zapisu
    @And("the user clicks the Save button")
    public void theUserClicksTheSaveButton() {

        newAddressPage.clickSave();
        System.out.println("💾 Kliknięto 'Save'");
    }

    // ✔️ Weryfikacja, czy adres się pojawił na liście
    @Then("the new address {string} should be displayed in the address list")
    public void theNewAddressIsDisplayedInTheAddressList(String alias) {
        Assertions.assertTrue(addressesPage.isAddressDisplayed(alias), "❌ Adres nie znaleziony: " + alias);
        System.out.println("✅ Adres '" + alias + "' jest widoczny na liście");
    }
}
