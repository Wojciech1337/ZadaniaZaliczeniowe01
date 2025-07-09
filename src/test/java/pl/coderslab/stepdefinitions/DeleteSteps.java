package pl.coderslab.stepdefinitions;

import io.cucumber.java.en.*;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import pl.coderslab.pages.AddressPage;

public class DeleteSteps {

    private WebDriver driver = LoginSteps.driver; // Wspólny driver

    private AddressPage addressPage = new AddressPage(driver);

    @When("the user deletes the address {string}")
    public void theUserDeletesTheAddress(String alias) {
        addressPage.deleteAddress(alias);
    }

    @Then("the address {string} should no longer be displayed in the address list")
    public void theAddressShouldBeDeleted(String alias) {
        Assertions.assertTrue(addressPage.isSuccessMessageDisplayed("Address successfully deleted"),
                "Success message not displayed after deleting address: " + alias);
    }
}