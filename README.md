# Zadania Zaliczeniowe 01 – Address Management Tests

Projekt automatyzacji testów end-to-end dla funkcjonalności zarządzania adresami w sklepie internetowym MyStore.  
Zrealizowany w Javie z użyciem Selenium WebDriver, Cucumber (BDD), Page Object Model i JUnit 5.


🔹 Zakres testów

Testy obejmują następujące scenariusze:

1. Logowanie użytkownika do konta  
2. Przejście do sekcji „Addresses”  
3. Dodanie nowego adresu z parametryzowanymi danymi  
4. Weryfikację poprawności dodanego adresu  
5. Usunięcie wcześniej dodanego adresu  
6. Potwierdzenie usunięcia (adres nie istnieje)  

Scenariusze w formacie BDD znajdują się w folderze `src/Cucumber/features`.


▶️ Jak uruchomić projekt

Wymagania

- JDK 11 lub nowsze  
- Maven  
- Google Chrome + ChromeDriver w PATH lub skonfigurowany w projekcie (`webdriver.chrome.driver`)  

Kroki uruchomienia

1. Sklonuj repozytorium:

git clone https://github.com/Wojciech1337/ZadaniaZaliczeniowe01.git
cd ZadaniaZaliczeniowe01
