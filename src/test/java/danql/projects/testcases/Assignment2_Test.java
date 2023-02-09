package danql.projects.testcases;

//import danql.utils.helpers.todoist.Project.ProjectColor;

import danql.browsers.BaseSetup;
import danql.projects.assignments.Assignment2;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class Assignment2_Test {

    private WebDriver driver;
    private Assignment2 assignment2A;

    @BeforeClass
    public void setupBrowser() {
        driver = new BaseSetup().setupDriver("chrome");
    }

    @Test
    public void assignment2() throws Exception {
        assignment2A = new Assignment2(driver);
        driver.get("https://todoist.com/");
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd_HHmmss");
        Date date = new Date();
        String name = "Test " + formatter.format(date);
        int colorId = new Random().nextInt(20) + 30;

//        assignment2A.updateProject("2307657204", name, ProjectColor.fromInt(colorId), false);
//        assignment2A.createProject(name, null, ProjectColor.fromInt(colorId), true);
//        assignment2A.getAllProjects();
//        assignment2A.getProjectByID("2307657204");
//        assignment2A.reopenTask("6602186751");
        assignment2A.createTaskCloseTaskAndReopenUsingAPI();
        Thread.sleep(2000);
    }

    @AfterClass
    public void closeBrowser() {
//        driver.close();
    }

}
