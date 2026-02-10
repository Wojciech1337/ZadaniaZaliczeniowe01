# Zadania Zaliczeniowe 01 – Testy zarządzania adresami

Projekt automatyzacji testów end‑to‑end dla funkcjonalności zarządzania adresami
w sklepie internetowym **MyStore TestLab**.  
Testy są realizowane w języku Java z użyciem Selenium WebDriver, Cucumber (BDD),
Page Object Model oraz JUnit 4.

---

## Zakres testów
Testy obejmują następujące scenariusze:
<<<<<<< HEAD
1. Logowanie użytkownika do konta
2. Przejście do sekcji **Addresses**
3. Dodanie nowego adresu z parametryzowanymi danymi
4. Weryfikację poprawności dodanego adresu
5. Usunięcie wcześniej dodanego adresu
6. Potwierdzenie jego usunięcia

---

## Technologie
- Java 21
- Maven
- Selenium WebDriver
- Cucumber (BDD)
- Page Object Model
=======
1. Logowanie użytkownika do konta  
2. Przejście do sekcji **Addresses**  
3. Dodanie nowego adresu z parametryzowanymi danymi  
4. Weryfikację poprawności dodanego adresu  
5. Usunięcie wcześniej dodanego adresu  
6. Potwierdzenie jego usunięcia
   
---

## Technologie
- Java 21  
- Maven  
- Selenium WebDriver  
- Cucumber (BDD)  
- Page Object Model  
>>>>>>> 71edb0d3021c6e7420ad950306aed0c934ed1cc8
- JUnit 4

---

## Wymagania

- Java 21+
- Maven 3.9+
- Chrome / Firefox
- System: Windows / macOS / Linux
- Git

---

## Struktura projektu

```text
ZadaniaZaliczeniowe01/
├── src/
│   ├── test/java/pl/coderslab/
│   │   ├── pages/
│   │   │   ├── AccountPage.java
│   │   │   ├── AddressPage.java
│   │   │   ├── LoginPage.java
│   │   │   └── NewAddressPage.java
│   │   │
│   │   └── stepdefinitions/
│   │       ├── LoginSteps.java
│   │       ├── AddressSteps.java
│   │       └── DeleteSteps.java
│   │
│   └── Cucumber/features/
│       └── createanddeleteaddress.feature
│
├── pom.xml
└── README.md

Projekt wykorzystuje wzorzec Page Object Model, gdzie każda strona aplikacji posiada własną klasę Page Object, a logika scenariuszy znajduje się w klasach Step Definitions.
```
---

## Jak uruchomić testy
1. Sklonuj repozytorium:

```bash
git clone https://github.com/Wojciech1337/ZadaniaZaliczeniowe01.git
cd ZadaniaZaliczeniowe01
```
---
2. Uruchom testy

 ```bash
  mvn clean test
```
---

## Dane logowania testowego (konto demo)

-Email: wojtek@wojtek.pl

-Hasło: Masakra!23

---

## Autor

Projekt wykonany w ramach kursu Automatyzacji Testów – CodersLab  
Autor: **Wojciech Basista** – [@Wojciech1337](https://github.com/Wojciech1337)




