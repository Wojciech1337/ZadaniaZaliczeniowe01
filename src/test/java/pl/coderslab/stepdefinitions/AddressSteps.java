package pl.coderslab.stepdefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import pl.coderslab.driver.DriverManager;
import pl.coderslab.pages.AddressPage;
import pl.coderslab.pages.LoginPage;
import pl.coderslab.pages.NewAddressPage;
public class AddressSteps {

    private WebDriver driver;
    private LoginPage loginPage;
    private AddressPage addressesPage;
    private NewAddressPage newAddressPage;

    public AddressSteps() {
        this.driver = DriverManager.getDriver();
        this.loginPage = new LoginPage(driver);
        this.addressesPage = new AddressPage(driver);
        this.newAddressPage = new NewAddressPage(driver);
    }

    @Given("I am logged in as {string} with password {string}")
    public void iLogInWithEmailAndPassword(String email, String password) {
        loginPage.open();
        loginPage.login(email, password);
    }

    @When("I go to the Addresses section")
    public void iGoToTheAddressesSection() {
        addressesPage.goToAddressesSection();
    }

    @Then("I click Create new address")
    public void iClickCreateNewAddress() {
        addressesPage.clickCreateNewAddress();
    }

    @And("I fill in new address form with:")
    public void iFillInNewAddressFormWith(DataTable dataTable) {
        newAddressPage.fillAddressForm(dataTable);
    }

    @Then("The new address {string} is displayed in the address list")
    public void theNewAddressIsDisplayedInTheAddressList(String alias) {
        Assertions.assertTrue(addressesPage.isAddressDisplayed(alias), "Address not found");
    }
}
