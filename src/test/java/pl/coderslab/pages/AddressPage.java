package pl.coderslab.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Map;

public class AddressPage {
    private WebDriver driver;

    private By addressesSectionLink = By.xpath("//a[@title='Addresses']");
    private By createNewAddressButton = By.cssSelector("#content > div.addresses-footer > a > span");
    private By aliasInput = By.name("alias");
    private By addressInput = By.name("address1");
    private By cityInput = By.name("city");
    private By postalCodeInput = By.name("postcode");
    private By countrySelect = By.name("id_country");
    private By phoneInput = By.name("phone");
    private By saveButton = By.xpath("//*[@id='content']/div/div/form/footer/button");
    private By addressBoxes = By.cssSelector("article.address");

    public AddressPage(WebDriver driver) {
        this.driver = driver;
    }

    public void goToAddressesSection() {
        driver.findElement(addressesSectionLink).click();
    }

    public void clickCreateNewAddress() {
        driver.findElement(createNewAddressButton).click();
    }

    public void fillNewAddressForm(Map<String, String> data) {
        WebElement aliasField = driver.findElement(aliasInput);
        aliasField.clear();
        aliasField.sendKeys(data.get("alias"));

        WebElement addressField = driver.findElement(addressInput);
        addressField.clear();
        addressField.sendKeys(data.get("address"));

        WebElement cityField = driver.findElement(cityInput);
        cityField.clear();
        cityField.sendKeys(data.get("city"));

        WebElement postalCodeField = driver.findElement(postalCodeInput);
        postalCodeField.clear();
        postalCodeField.sendKeys(data.get("postalCode"));

        WebElement phoneField = driver.findElement(phoneInput);
        phoneField.clear();
        phoneField.sendKeys(data.get("phone"));

        WebElement countryDropdown = driver.findElement(countrySelect);
        Select selectCountry = new Select(countryDropdown);
        selectCountry.selectByVisibleText(data.get("country"));

        driver.findElement(saveButton).click();
    }

    public boolean isAddressDisplayed(String alias) {
        List<WebElement> boxes = driver.findElements(addressBoxes);
        return boxes.stream().anyMatch(box -> box.getText().contains(alias));
    }

    public void deleteAddress(String alias) {
        List<WebElement> boxes = driver.findElements(addressBoxes);
        for (WebElement box : boxes) {
            if (box.getText().contains(alias)) {
                box.findElement(By.cssSelector("a[data-link-action='delete-address']")).click();
                break;
            }
        }
    }
}
