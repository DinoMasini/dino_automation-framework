package pages;

/*
COSA INSERIRE NELLE PAGES OLTRE AGLI XPATH
- METODI DI INTERAZIONE: clic, scrittura, selezione.
e.g.
public void clickLoginButton() {
    driver.findElement(loginButton).click();
}

public void enterSearchQuery(String query) {
    driver.findElement(searchBox).sendKeys(query);
}

public void selectCategory(String category) {
    WebElement dropdown = driver.findElement(categoryDropdown);
    Select select = new Select(dropdown);
    select.selectByVisibleText(category);
}

METODI DI RECUPERO: titolo della pagina, testo di un elemento.

public String getTitle() {
    return driver.getTitle();
}

public String getHeaderText() {
    return driver.findElement(headerText).getText();
}

public boolean isElementVisible() {
    return driver.findElement(someElement).isDisplayed();
}

METODI DI VALIDAZIONE: verifiche sulla visibilità, sul testo.

public boolean isElementTextCorrect(String expectedText) {
    return driver.findElement(someElement).getText().contains(expectedText);
}

METODI DI NAVIGAZIONE: passaggi da una pagina all'altra.

public void navigateToAnotherPage() {
    driver.findElement(anotherPageLink).click();
}
 */
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import utils.ConfigReader;
import utils.Log;
import io.qameta.allure.Step;

public class HomePage {
    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        Log.info("HomePage instantiated.");
    }

    @Step("Opening the site")
    public HomePage openSite() {
        driver.get(ConfigReader.get("ui.baseUrl"));
        Log.info("The site is opened correctly!");
        return this;
    }

    @Step("Verifying that the site title contains 'Automation'")
    public HomePage isSiteTitleContainsAutomation() {
        // Non richiama driver.get() di nuovo se il sito è già aperto
        Assert.assertTrue(getTitle().contains("Automation"), "Title does not contain 'Automation'");
        Log.info("The site title contains Automation!");
        return this;
    }

    public String getTitle() {
        return driver.getTitle();
    }
}

