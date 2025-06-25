package pl.coderslab.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AccountPage {
    private WebDriver driver;

    private By addressesLink = By.xpath("//a[@title='Addresses']");

    public AccountPage(WebDriver driver) {
        this.driver = driver;
    }

    public void goToAddresses() {
        WebElement addressesElement = driver.findElement(addressesLink);
        // Dla linku nie ma sensu clear(), więc od razu klikamy
        addressesElement.click();
    }

    // Przykład metody z polem tekstowym i czyszczeniem
    private By exampleInput = By.id("example-input");

    public void fillExampleInput(String text) {
        WebElement input = driver.findElement(exampleInput);
        input.clear();          // czyścimy pole
        input.sendKeys(text);   // wpisujemy tekst
    }
}