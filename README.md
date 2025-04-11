# UI Automation Framework 🚀

Un progetto base di **Test Automation** per test UI automatizzati, realizzato in **Java**, con **Selenium WebDriver**, **TestNG** e **WebDriverManager**.

## 📁 Struttura del progetto

src
└── test
    ├── java
    │   ├── tests            ←UITest 
    │   ├── pages          ← HomePage 
    │   ├── utils             ← DriverManager, ConfigReader 
    │   └── base            ← BaseTest
    └── resources
        └── config.properties

## 🛠️ Tecnologie utilizzate

- Java 17+
- Selenium WebDriver
- TestNG
- WebDriverManager
- Maven

## ⚙️ Setup del progetto

1. Clona il repository:
   git clone https://github.com/tuo-username/nome-repo.git
   
3. Importa il progetto in IntelliJ IDEA o altro IDE compatibile con Maven

4. Esegui i test:
   - Da terminale:
          mvn test
   - Oppure direttamente dall'IDE

## 📦 In futuro...

- Report con Allure
- CI/CD con GitHub Actions
- Test cross-browser
- Estensioni per API e Performance Testing
