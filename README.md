# Zadanie Zaliczeniowe nr 1 – Automatyzacja zarządzania adresami

## Opis projektu

Projekt realizuje scenariusz automatyzacji testów z wykorzystaniem frameworka Cucumber, biblioteki Selenium WebDriver oraz wzorca projektowego Page Object Model (POM).

Testowany scenariusz dotyczy sklepu internetowego MyStore TestLab, a jego celem jest:

- zalogowanie się na istniejące konto użytkownika,
- przejście do sekcji „Addresses”,
- dodanie nowego adresu z parametryzowanymi danymi (alias, adres, miasto, kod pocztowy, kraj, telefon),
- weryfikacja poprawności dodanego adresu,
- usunięcie wcześniej dodanego adresu,
- potwierdzenie, że adres został usunięty.

## Technologie

- Java
- Maven
- Selenium WebDriver
- Cucumber (BDD)
- Page Object Model
- JUnit Jupiter (JUnit 5)

## Struktura projektu

- `src/test/java/pl/coderslab/pages/` – klasy Page Object (np. `AddressPage`, `NewAddressPage`, `LoginPage`)
- `src/test/java/pl/coderslab/stepdefinitions/` – definicje kroków Cucumbera:
    - `AddressSteps.java` – logowanie, przejście do sekcji adresów, dodanie nowego adresu
    - `DeleteAddressSteps.java` – usunięcie adresu i weryfikacja usunięcia
    - `LoginSteps.java` – logowanie do sklepu
- `src/test/resources/features/` – plik `createanddeleteaddress.feature` z opisem scenariuszy testowych

## Dane logowania testowego

- Email: `wojtek@wojtek.pl`
- Hasło: `Masakra!23`


## Autor

Projekt wykonany w ramach kursu Automatyzacji Testów – CodersLab  
Autor: [Wojciech Basista](https://github.com/Wojciech1337/ZadaniaZaliczeniowe01.git)
