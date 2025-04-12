package tests;

/*
METODI DI TEST: Annotati con @Test, contengono la logica che esegue il test.

e.g.
openSite()

LE ASSERZIONI: Verifica che i risultati siano corretti (titolo, contenuto, visibilità, ecc.).

Il setup e teardown: Operazioni che vanno fatte prima e dopo ogni test (ad esempio, avvio e chiusura del driver).

Interazione con la pagina: La logica di navigazione o interazione con la UI, ma sempre utilizzando i metodi della HomePage (o altre pagine), non direttamente nella classe di test
 */

import base.BaseTest;
import org.testng.annotations.Test;
import pages.HomePage;
import io.qameta.allure.Description;
import org.junit.jupiter.api.DisplayName;

public class HomePageTest extends BaseTest {

    @Test
    @DisplayName("Open site")
    @Description("This test verifies that the site title contains 'Automation'")
    public void verifySiteTitle() {
        executeTest(() -> {new HomePage(driver)
            .openSite()
            .isSiteTitleContainsAutomation();
        });
    }
}





