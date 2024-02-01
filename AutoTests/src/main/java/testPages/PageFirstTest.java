package testPages;

import base.BasePageForTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class PageFirstTest extends BasePageForTest {

    public PageFirstTest(WebDriver driver) {
        super(driver);
    }
    // Пошук елемента
    WebElement comboBox = driver.findElement(By.id("table-select"));
    WebElement nextButton = driver.findElement(By.className("-next"));
    WebElement previousButton = driver.findElement(By.className("-previous"));

    public void clickOnComboBoxFive(){
        waitForVisible(comboBox);
        // Створення об'єкту класу Select для роботи з комбінованим списком
        Select select = new Select(comboBox);
        // Вибір значення "5" у комбінованому списку
        select.selectByValue("5");
    }

    public void clickOnNextbutton(){
        waitForVisible(nextButton);
        nextButton.click();
    }
     public void clickOnPrevious(){
        waitForVisible(previousButton);
        previousButton.click();
     }

    public void clickOnComboBoxTen(){
        waitForVisible(comboBox);
        // Створення об'єкту класу Select для роботи з комбінованим списком
        Select select = new Select(comboBox);
        // Вибір значення "5" у комбінованому списку
        select.selectByValue("10");
    }

}
