package pl.coderslab.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
    private static final String LOGIN_URL = "https://mystore-testlab.coderslab.pl/index.php?controller=authentication&back=my-account";

    private WebDriver driver;
    private WebDriverWait wait;

    // ======= Lokatory =======
    @FindBy(name = "email")
    private WebElement emailInput;

    @FindBy(name = "password")
    private WebElement passwordInput;

    @FindBy(id = "submit-login")
    private WebElement loginButton;

    @FindBy(css = ".alert-danger")
    private WebElement errorMessage;

    // ======= Konstruktor =======
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // ======= Metody działania =======

    // 🌐 Otwiera stronę logowania
    public void open() {
        System.out.println("🌐 Otwieram stronę logowania: " + LOGIN_URL);
        driver.get(LOGIN_URL);
        wait.until(ExpectedConditions.visibilityOf(loginButton));
        System.out.println("✅ Strona logowania załadowana");
    }

    // 🔑 Loguje użytkownika podanym emailem i hasłem
    public void login(String email, String password) {
        wait.until(ExpectedConditions.visibilityOf(emailInput));

        emailInput.clear();
        emailInput.sendKeys(email);

        passwordInput.clear();
        passwordInput.sendKeys(password);

        loginButton.click();

    }

    // 👁️ Sprawdza, czy jesteśmy na stronie logowania
    public boolean isAt() {
        System.out.println("👁️ Sprawdzam, czy jesteśmy na stronie logowania...");
        try {
            boolean displayed = loginButton.isDisplayed();
            System.out.println("👁️ Wynik sprawdzenia: " + displayed);
            return displayed;
        } catch (Exception e) {
            System.out.println("❌ Nie jesteśmy na stronie logowania");
            return false;
        }
    }
}
