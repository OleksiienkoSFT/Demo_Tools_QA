package base;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePageForTest {
    protected WebDriver driver;
    public BasePageForTest(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void waitForVisible(WebElement webElement) {
        WebDriverWait waiter = new WebDriverWait(driver, Duration.ofSeconds(5));
        waiter.until(ExpectedConditions.visibilityOf(webElement));
    }

    public void waitForASomeTime(WebElement webElement, int duration) {
        WebDriverWait waiter = new WebDriverWait(driver, Duration.ofSeconds(duration));
        waiter.until(ExpectedConditions.visibilityOf(webElement));
    }

    public Alert waitForAlert() {
        WebDriverWait waiter = new WebDriverWait(driver, Duration.ofSeconds(5));
        return waiter.until(ExpectedConditions.alertIsPresent());
    }
}
