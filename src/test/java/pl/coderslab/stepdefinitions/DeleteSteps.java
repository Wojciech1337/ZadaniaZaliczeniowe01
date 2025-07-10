package pl.coderslab.stepdefinitions;

import io.cucumber.java.en.*;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import pl.coderslab.pages.AddressPage;

public class DeleteSteps {

    private WebDriver driver = LoginSteps.driver; // 🔧 Wspólny WebDriver

    private AddressPage addressPage = new AddressPage(driver);

    @When("the user deletes the address {string}")
    public void theUserDeletesTheAddress(String alias) {
        System.out.println("🗑️ Usuwam adres o aliasie: " + alias);
        addressPage.deleteAddress(alias);
    }

    @Then("the address {string} should no longer be displayed in the address list")
    public void theAddressShouldBeDeleted(String alias) {

        // Opcjonalnie: sprawdź, czy adres faktycznie zniknął z listy
        boolean isAddressGone = !addressPage.isAddressDisplayed(alias);
        Assertions.assertTrue(isAddressGone, "❌ Adres nadal widoczny na liście po usunięciu: " + alias);

        System.out.println("✅ Adres został pomyślnie usunięty i nie jest już na liście");
    }
}
