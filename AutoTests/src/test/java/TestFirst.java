import baseTest.BaseTest;
import org.junit.jupiter.api.Test;
import testPages.PageFirstTest;

public class TestFirst extends BaseTest {
    PageFirstTest pageFirstTest = new PageFirstTest(driver);

    @Test
    public void testFirst(){
        pageFirstTest.clickOnComboBoxFive();
        pageFirstTest.clickOnNextbutton();
        pageFirstTest.clickOnPrevious();
        pageFirstTest.clickOnComboBoxTen();
    }

}
