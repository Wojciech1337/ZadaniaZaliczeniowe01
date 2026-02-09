# Zadanie Zaliczeniowe nr 1 – Automatyzacja adresów w MyStore TestLab

## Co robi projekt

Ten projekt automatyzuje testy dodawania i usuwania adresów w sklepie MyStore TestLab. W testach wykorzystałem:

* Selenium WebDriver  – do sterowania przeglądarką

* Cucumber (BDD) – do opisu scenariuszy w języku naturalnym

* Page Object Model (POM) – dla lepszej organizacji kodu

Testy realizują następujący scenariusz:

1. na istniejące konto użytkownika.

2. Przejście do sekcji Addresses.

3. Dodanie nowego adresu (alias, adres, miasto, kod pocztowy, kraj, telefon).

4. Weryfikacja, że adres został poprawnie dodany.

5. Usunięcie wcześniej dodanego adresu.

6. Sprawdzenie, że adres został usunięty.


## Technologie

- Java 21

- Maven

- Selenium WebDriver 4.33.0

- Cucumber 7.23.0

- JUnit 4

- Page Object Model (POM)

Uwaga: w projekcie używam JUnit 4, bo jest stabilny i działa najlepiej z Cucumberem w tej konfiguracji.

## Struktura projektu

zadaniezaliczeniowe01/

├── src/

│ ├── test/

│ │ ├── java/

│ │ │ └── pl/coderslab/

│ │ │ ├── pages/

│ │ │ │ ├── AddressPage.java

│ │ │ │ ├── NewAddressPage.java

│ │ │ │ └── LoginPage.java

│ │ │ └── stepdefinitions/

│ │ │ ├── AddressSteps.java

│ │ │ ├── DeleteAddressSteps.java

│ │ │ └── LoginSteps.java

│ └── Cucumber/

│ └── features/

│ └── createanddeleteaddress.feature

├── pom.xml

└── README.md 

## Testowe konto

- Email: wojtek@wojtek.pl

- Hasło: Masakra!23

## Uruchamianie testów
1. Sklonuj repozytorium:

git clone https://github.com/Wojciech1337/ZadaniaZaliczeniowe01.git

cd ZadaniaZaliczeniowe01 

## Autor
Projekt wykonany w ramach kursu Automatyzacji Testów – CodersLab
Autor:  [Wojciech Basista](https://github.com/Wojciech1337)
