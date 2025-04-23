# Dino Automation Framework 🚀

Un progetto completo di **Test Automation** per UI e API Testing, sviluppato in **Java**, con l'uso di **Selenium WebDriver**, **RestAssured**, **TestNG**, **Jackson**, **Lombok** e **WebDriverManager**.

## 📁 Struttura del progetto

```
src/test/java/
├── base/             # Interfacce e classi base condivise
│   └── IRequest.java, BaseTest.java, TestExecutor.java
├── facade/           # Logica per invio richieste API
│   └── GetProducts.java
├── models/           # POJO per il parsing JSON
│   ├── ProductResponse.java
│   ├── Product.java
│   ├── Category.java
│   └── Usertype.java
├── pages/            # Page Object per UI Testing
│   └── HomePage.java
├── tests/
│   ├── api/          # Test API (TestNG)
│   │   └── ProductTest.java
│   └── ui/           # Test UI (TestNG)
│       └── HomePageTest.java
├── utils/            # Classi di utilità
│   └── DriverManager.java, ConfigReader.java, DataUtils.java, Log.java
└── resources/
    └── config.properties
```

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

## 🧪 Flussi Implementati

### ✅ API Testing: e.g. `GET /productsList`
- Endpoint: `https://automationexercise.com/api/productsList`
- Output: JSON contenuto all'interno del tag `<body>`
- Soluzione: Estrazione con regex e parsing via **Jackson**

```java
String htmlBody = response.getBody().asString();
String json = htmlBody.replaceAll("(?s).*<body>(\\\{.*?})</body>.*", "$1");
```

### 📄 Modelli JSON (esempi)
```json
{
  "responseCode": 200,
  "products": [
    {
      "id": 1,
      "name": "Blue Top",
      "price": "Rs. 500",
      "brand": "Polo",
      "category": {
        "usertype": { "usertype": "Women" },
        "category": "Tops"
      }
    }
  ]
}
```

### 🧑‍💼 Interfaccia comune `IRequest<T>`
Permette di estendere facilmente nuove chiamate API con lo stesso schema.

### 🧪 Test API
Eseguiti tramite **TestNG**, con validazioni su response code e contenuto.

### 🧪 Test UI
Basati su Page Object e Selenium WebDriver.

## 🛠️ Tecnologie utilizzate

| Tool             | Scopo                                |
|------------------|---------------------------------------|
| Java 17+         | Linguaggio principale                 |
| Selenium WebDriver | UI Test Automation                 |
| RestAssured      | API Testing                           |
| TestNG           | Framework di test                     |
| WebDriverManager | Gestione automatica dei driver        |
| Maven            | Build & Dependency Management         |
| Jackson          | JSON ↔️ Java Mapping                   |
| Lombok           | Riduzione boilerplate (getter/setter) |
| Allure           | (In arrivo) Reportistica test         |



## 💡 In futuro...

- ✅ Report Allure HTML
- ✅ Performance Testing
- ✅ CI/CD con GitHub Actions
- ✅ Test cross-browser
- ✅ Dashboard centrale per metriche QA

---

> Made with ❤️ for learning, practicing and growth in QA Automation.

