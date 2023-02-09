package danql.projects.testcases;

import danql.browsers.BaseSetup;
import danql.projects.assignments.Assignment1A;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Assignment1A_Test {

    private WebDriver driver;
    private Assignment1A assignment1A;

    @BeforeClass
    public void setupBrowser() {
        driver = new BaseSetup().setupDriver("chrome");
    }

    @Test
    public void assignment1A() throws Exception {
        assignment1A = new Assignment1A(driver);
        driver.get("https://www.bursamalaysia.com/");
        assignment1A.getDailyTopTenByVolumeAndSortByChange();
        Thread.sleep(2000);
    }

    @AfterClass
    public void closeBrowser() {
        driver.close();
    }

}
