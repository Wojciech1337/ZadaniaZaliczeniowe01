package pl.coderslab.stepdefinitions;

import io.cucumber.java.en.*;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pl.coderslab.driver.DriverManager;

import java.time.Duration;
import java.util.List;

public class AddressDeleteSteps {

    private WebDriver driver = DriverManager.getDriver();
    private WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    private String deletedAlias;

    @Given("I am on the address page")
    public void iAmOnTheAddressBookPage() {
        WebElement addressBookLink = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Addresses")));
        addressBookLink.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("article.address")));
    }

    @And("The address {string} exists in the address list")
    public void theAddressExistsInTheAddressList(String alias) {
        boolean found = getAddressBoxes().stream()
                .anyMatch(box -> box.getText().contains(alias));
        Assertions.assertTrue(found, "Address with alias '" + alias + "' does not exist in the address list");
    }

    @When("I delete the address {string}")
    public void iDeleteTheAddress(String alias) {
        deletedAlias = alias;
        for (WebElement box : getAddressBoxes()) {
            if (box.getText().contains(alias)) {
                WebElement deleteButton = box.findElement(By.cssSelector("a[data-link-action='delete-address']"));
                deleteButton.click();

                WebElement successMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(
                        By.cssSelector(".alert.alert-success")));
                Assertions.assertTrue(successMessage.getText().contains("Address successfully deleted"));
                break;
            }
        }
    }

    @Then("The address should not be displayed in the address list")
    public void theAddressShouldNotBeDisplayedInTheAddressList() {
        boolean found = getAddressBoxes().stream()
                .anyMatch(box -> box.getText().contains(deletedAlias));
        Assertions.assertFalse(found, "Address with alias '" + deletedAlias + "' was found, but should be deleted");
    }

    private List<WebElement> getAddressBoxes() {
        return driver.findElements(By.cssSelector("article.address"));
    }
}
