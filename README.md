# Zadania Zaliczeniowe 01 – Testy zarządzania adresami

Projekt automatyzacji testów end-to-end dla funkcjonalności zarządzania adresami w sklepie internetowym **MyStore TestLab**.  
Zrealizowany w **Java**, z użyciem **Selenium WebDriver**, **Cucumber (BDD)**, **Page Object Model** i **JUnit 5**.

---

## Zakres testów

Testy obejmują następujące scenariusze:

1. Logowanie użytkownika do konta
2. Przejście do sekcji **Addresses**
3. Dodanie nowego adresu z parametryzowanymi danymi
4. Weryfikację poprawności dodanego adresu
5. Usunięcie wcześniej dodanego adresu
6. Potwierdzenie usunięcia (adres nie istnieje)

Scenariusze w formacie BDD znajdują się w folderze `src/Cucumber/features`.

---

## Struktura projektu

- `src/test/java/pl/coderslab/pages/` – klasy **Page Object**, np. `LoginPage`, `AddressPage`, `NewAddressPage`
- `src/test/java/pl/coderslab/stepdefinitions/` – definicje kroków Cucumbera:
  - `LoginSteps.java` – logowanie do sklepu
  - `AddressSteps.java` – dodawanie nowego adresu
  - `DeleteAddressSteps.java` – usuwanie adresu
- `src/Cucumber/features/` – pliki `.feature` z opisem scenariuszy testowych

---

## Wymagania

- JDK 11 lub nowsze
- Maven
- Google Chrome + ChromeDriver w PATH lub skonfigurowany w projekcie (`webdriver.chrome.driver`)

---

## Uruchomienie projektu

1. Sklonuj repozytorium:

```bash
git clone https://github.com/Wojciech1337/ZadaniaZaliczeniowe01.git
cd ZadaniaZaliczeniowe01


## Autor
Projekt wykonany w ramach kursu Automatyzacji Testów – CodersLab
Autor:  [Wojciech Basista](https://github.com/Wojciech1337)
