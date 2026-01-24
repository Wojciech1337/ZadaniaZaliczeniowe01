# Automatyzacja Zarządzania Adresami – Test Automation Framework

**Opis projektu**  
Automatyzacja testów end-to-end dla funkcjonalności zarządzania adresami w sklepie internetowym *MyStore TestLab* wykorzystując:
- Java
- Maven
- Selenium WebDriver
- Cucumber (BDD)
- Page Object Model
- JUnit 5

**Testowane scenariusze**
Testy pokrywają:
1. Logowanie użytkownika do konta.
2. Przejście do sekcji **„Addresses”**.
3. Dodanie nowego adresu z parametryzowanymi danymi.
4. Weryfikację poprawności dodanego adresu.
5. Usunięcie wcześniej dodanego adresu.
6. Potwierdzenie usunięcia (brak adresu).  
*(Scenariusze BDD w pliku `.feature`)*

---

## 🚀 Jak uruchomić projekt

### 📌 Wymagania
- JDK 11 lub nowsze
- Maven
- ChromeDriver w PATH lub podany w konfiguracji

### 🧩 Kroki uruchomienia
1. Sklonuj repo:
   ```bash
   git clone https://github.com/Wojciech1337/ZadaniaZaliczeniowe01.git
   ```
2. Przejdź do katalogu:
   ```bash
   cd ZadaniaZaliczeniowe01
   ```
3. Uruchom testy:
   ```bash
   mvn clean test
   ```

> 💡 ChromeDriver powinien być w PATH lub skonfigurowany w `webdriver.chrome.driver`.

---

## 🛠️ Struktura projektu

| Folder | Opis |
|--------|------|
| `src/test/java/pl/coderslab/pages` | Page Object Model |
| `src/test/java/pl/coderslab/stepdefinitions` | Definicje kroków Cucumber |
| `src/Cucumber/features` | Scenariusze BDD |

---

## 📦 Technologie
- **Java**
- **Selenium WebDriver**
- **Cucumber (BDD)**
- **JUnit 5**
- **Maven**

---

## 📌 Wskazówki rekrutacyjne
Projekt demonstruje:
✔️ umiejętność analizy i automatyzacji testów UI  
✔️ stosowanie Page Object Model  
✔️ tworzenie scenariuszy BDD  
✔️ integrację narzędzi testowych w jednym projekcie  
✔️ zdolność do pracy z frameworkami popularnymi w branży QA

---

## ✏️ Autor
Wojciech Basista – Junior QA Automation Tester  
📧 wbasista4@gmail.com  
GitHub: https://github.com/Wojciech1337
