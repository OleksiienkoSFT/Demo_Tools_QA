package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.LoadState;

public class HomePagePlay {
    private final Page homePage;
    private final Locator tileBookStore;
    private final Locator tileAlerts;

    public HomePagePlay(Page homePage) {
        this.homePage = homePage;
        this.tileBookStore = homePage.locator("//*[text()='Book Store Application']/ancestor::div[@class='card mt-4 top-card']");
        this.tileAlerts = homePage.getByText("Alerts");
    }

    public void openUrl() {
        homePage.navigate("https://demoqa.com/");
    }
    public void clickTileBookStore() {
        homePage.waitForLoadState(LoadState.DOMCONTENTLOADED);
        assert homePage.title().contains("");
        tileBookStore.click();
    }

    public void clickAlertsTab() {
        homePage.waitForLoadState(LoadState.DOMCONTENTLOADED);
        tileAlerts.click();
    }
}
