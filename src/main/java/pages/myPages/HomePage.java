package pages.myPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.base.BasePage;

public class HomePage extends BasePage {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "/html/body/div[2]/div/div/div[2]/div/div[1]")
    WebElement elements;
    @FindBy(xpath = "/html/body/div[2]/div/div/div[2]/div/div[6]")
    WebElement bookStore;


    public void clickOnElements(){
        waitForVisible(elements);
        elements.click();
    }
    public void clickOnBookStore(){
        waitForVisible(elements);
        bookStore.click();
    }
}
