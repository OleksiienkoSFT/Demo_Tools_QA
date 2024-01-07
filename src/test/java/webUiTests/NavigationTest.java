package webUiTests;

import base.BaseTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import pages.myPages.HomePage;
@TestInstance(TestInstance.Lifecycle.PER_CLASS)

public class NavigationTest extends BaseTest {
    HomePage homePage = new HomePage(driver);
    @Test
    public void firstClickTest(){
        homePage.clickOnBookStore();
    }
}
