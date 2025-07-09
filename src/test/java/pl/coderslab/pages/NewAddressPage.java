package pl.coderslab.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class NewAddressPage {

    private WebDriver driver;

    @FindBy(name = "alias")
    private WebElement aliasField;

    @FindBy(name = "address1")
    private WebElement addressField;

    @FindBy(name = "city")
    private WebElement cityField;

    @FindBy(name = "postcode")
    private WebElement postalCodeField;

    @FindBy(name = "id_country")
    private WebElement countrySelect;

    @FindBy(name = "phone")
    private WebElement phoneField;

    @FindBy(xpath = "//*[@id='content']/div/div/form/footer/button")
    private WebElement saveButton;

    public NewAddressPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Wypełnianie formularza przekazując wartości osobno
    public void fillAddressForm(String alias, String address, String city, String postalCode, String country, String phone) {
        aliasField.clear();
        aliasField.sendKeys(alias);

        addressField.clear();
        addressField.sendKeys(address);

        cityField.clear();
        cityField.sendKeys(city);

        postalCodeField.clear();
        postalCodeField.sendKeys(postalCode);

        Select selectCountry = new Select(countrySelect);
        selectCountry.selectByVisibleText(country);

        phoneField.clear();
        phoneField.sendKeys(phone);
    }

    public void clickSave() {
        saveButton.click();
    }
}
