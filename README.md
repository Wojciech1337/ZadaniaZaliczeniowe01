# Zadanie Zaliczniowe nr 1 – Automatyzacja zarządzania adresami

## Opis projektu

Projekt realizuje scenariusz automatyzacji testów z wykorzystaniem frameworka Cucumber, biblioteki Selenium WebDriver oraz wzorca Page Object Model (POM).

Testowany scenariusz dotyczy sklepu internetowego MyStore TestLab, a celem jest:

- zalogowanie się na istniejące konto użytkownika,
- przejście do sekcji „Addresses”,
- dodanie nowego adresu z parametryzowanymi danymi (alias, adres, miasto, kod pocztowy, kraj, telefon),
- weryfikacja poprawności dodanego adresu,
- usunięcie wcześniej dodanego adresu,
- weryfikacja, czy adres został usunięty.

## Technologie

- Java
- Maven
- Selenium WebDriver
- Cucumber (BDD)
- Page Object Model
- JUnit Jupiter (JUnit 5)
- WebDriverManager

## Struktura projektu

- `src/test/java/pl/coderslab/pages/` – klasy Page Object (np. AddressPage, NewAddressPage, LoginPage)
- `src/test/java/pl/coderslab/stepdefinitions/` – definicje kroków Cucumbera, m.in.:
- `AddressSteps.java` – logowanie i nawigacja do adresów, dodawanie adresu
- `DeleteAddressSteps.java` – usuwanie adresu i weryfikacja usunięcia
- `LoginSteps.java` – logowanie do sklepu
- `src/test/resources/features/` – createanddeleteaddress.feature z opisem scenariuszy testowych

## Dane logowania testowego

- Email: `wojtek@wojtek.pl`
- Hasło: `Masakra!23`

## Autor

Projekt wykonany w ramach kursu Automatyzacji Testów – CodersLab  
Autor: [Wojciech Basista]
