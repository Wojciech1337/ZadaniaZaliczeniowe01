# Zadania Zaliczeniowe 01 – Testy zarządzania adresami

Projekt automatyzacji testów end‑to‑end dla funkcjonalności zarządzania adresami
w sklepie internetowym **MyStore TestLab**.  
Testy są realizowane w języku Java z użyciem Selenium WebDriver, Cucumber (BDD),
Page Object Model oraz JUnit 4.

---

## Zakres testów
Testy obejmują następujące scenariusze:

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
- JUnit 4

---

## Struktura projektu
ZadaniaZaliczeniowe01/

├── src/

│ ├── test/

│ │ ├── java/

│ │ │ ├── pl/coderslab/pages/

│ │ │ └── pl/coderslab/stepdefinitions/

│ └── Cucumber/features/

├── pom.xml

└── README.md

---


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

## Dane logowania testowego

-Email: wojtek@wojtek.pl

-Hasło: Masakra!23

---

## Autor

Projekt wykonany w ramach kursu Automatyzacji Testów – CodersLab  
Autor: **Wojciech Basista** – [@Wojciech1337](https://github.com/Wojciech1337)




