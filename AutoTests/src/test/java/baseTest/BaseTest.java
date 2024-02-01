package baseTest;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)

public class BaseTest {
    public WebDriver driver = new ChromeDriver();
    @BeforeAll
    public void setup(){
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
    }
    @BeforeEach
    public void start() {
        driver.get("https://demoqa.com/profile");
    }

    @AfterEach
    public void clear() {
        driver.manage().deleteAllCookies();
    }

    @AfterAll
    public void tearDown() {
        driver.quit();
    }
}
