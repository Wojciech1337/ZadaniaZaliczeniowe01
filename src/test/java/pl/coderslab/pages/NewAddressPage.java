package pl.coderslab.pages;

import io.cucumber.datatable.DataTable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Map;

public class NewAddressPage {
    private WebDriver driver;

    public NewAddressPage(WebDriver driver) {
        this.driver = driver;
    }

    public void fillAddressForm(DataTable dataTable) {
        Map<String, String> data = dataTable.asMap(String.class, String.class);

        WebElement aliasField = driver.findElement(By.name("alias"));
        aliasField.clear();
        aliasField.sendKeys(data.get("alias"));

        WebElement addressField = driver.findElement(By.name("address1"));
        addressField.clear();
        addressField.sendKeys(data.get("address"));

        WebElement cityField = driver.findElement(By.name("city"));
        cityField.clear();
        cityField.sendKeys(data.get("city"));

        WebElement postalCodeField = driver.findElement(By.name("postcode"));
        postalCodeField.clear();
        postalCodeField.sendKeys(data.get("postalCode"));

        WebElement phoneField = driver.findElement(By.name("phone"));
        phoneField.clear();
        phoneField.sendKeys(data.get("phone"));

        WebElement countrySelect = driver.findElement(By.name("id_country"));
        countrySelect.click(); // Możesz dodać wybór konkretnego kraju przez Select, jeśli potrzebujesz

        WebElement saveButton = driver.findElement(By.xpath("//*[@id='content']/div/div/form/footer/button"));
        saveButton.click();
    }
}
