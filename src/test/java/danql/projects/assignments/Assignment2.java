package danql.projects.assignments;

import danql.locators.Assignment2Locator;
import danql.utils.helpers.WebUI;
import danql.utils.helpers.todoist.Project.ProjectColor;
import danql.utils.helpers.todoist.*;
import danql.utils.logs.Log;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Random;

import static io.restassured.RestAssured.*;
public class Assignment2 {
    private WebDriver driver;
    private WebUI webUI;

    private String apiToken = "202fd70d09b59268a9d6498344fb7c176f60257c";
    private String baseApiUrl = "https://api.todoist.com/rest/v2";
    private static final HashMap<String, String> locator = Assignment2Locator.getLocators();
    private By homepageLoginButton = By.xpath(locator.get("login button"));
    private By usernameTextbox = By.xpath(locator.get("email"));
    private By passwordTextbox = By.xpath(locator.get("password"));
    private By loginButton = By.xpath(locator.get("submit"));


    public Assignment2(WebDriver driver) {
        this.driver = driver;
        webUI = new WebUI(driver);
    }

    public void createProject(String projectName, String projectParentID, ProjectColor projectColor, Boolean isFavorite) {
        String requestUrl = baseApiUrl + "/projects";
        Project proj = new Project();
        proj.setName(projectName);
        if (projectParentID != null) proj.setParentID(projectParentID);
        if (projectColor != null) proj.setColor(projectColor);
        if (isFavorite != null) proj.setFavorite(isFavorite);
        Response resp = given()
                .headers(
                        "Authorization",
                        "Bearer " + apiToken)
                .contentType(ContentType.JSON)
                .when()
                .body(proj)
                .post(requestUrl);
        //A successful response has 200 OK status and application/json Content-Type.
        Assert.assertEquals(resp.getStatusCode(), 200);
        Assert.assertEquals(resp.getContentType(), "application/json");
    }

    public void deleteProject(String projectID) {
        String requestUrl = baseApiUrl + "/projects/" + projectID;
        Project proj = new Project();
        Response resp = given()
                .headers(
                        "Authorization",
                        "Bearer " + apiToken)
                .contentType(ContentType.JSON)
                .when()
                .body(proj)
                .delete(requestUrl);
        //A successful response has 204 No Content status and an empty body.
        Assert.assertEquals(resp.getStatusCode(), 204);
    }

    public void getProjectByID(String projectID) {
        String requestUrl = baseApiUrl + "/projects/" + projectID;
        Response resp = given()
                .headers(
                        "Authorization",
                        "Bearer " + apiToken)
                .contentType(ContentType.JSON)
                .when()
                .get(requestUrl);
        //A successful response has 200 OK status and application/json Content-Type.
        Assert.assertEquals(resp.getStatusCode(), 200);
        Assert.assertEquals(resp.getContentType(), "application/json");
    }

    public void updateProject(String projectID, String projectName, ProjectColor projectColor, Boolean isFavorite) {
        String requestUrl = baseApiUrl + "/projects/" + projectID;
        Project proj = new Project();
        if (projectID == null) {
            Assert.fail("Project ID must not be null!");
        }
        if (projectName != null) proj.setName(projectName);
        if (projectColor != null) proj.setColor(projectColor);
        if (isFavorite != null) proj.setFavorite(isFavorite);
        Response resp = given()
                .headers(
                        "Authorization",
                        "Bearer " + apiToken)
                .contentType(ContentType.JSON)
                .when()
                .body(proj)
                .post(requestUrl);
        //A successful response has 200 OK status and application/json Content-Type.
        Assert.assertEquals(resp.getStatusCode(), 200);
        Assert.assertEquals(resp.getContentType(), "application/json");
    }

    public void getAllProjects() {
        String requestUrl = baseApiUrl + "/projects";
        Response resp = given()
                .headers(
                        "Authorization",
                        "Bearer " + apiToken)
                .contentType(ContentType.JSON)
                .when()
                .get(requestUrl);
    }

    public void reopenTask(String taskID) {
        String requestUrl = baseApiUrl + "/tasks/" + taskID + "/reopen";
        Response resp = given()
                .headers(
                        "Authorization",
                        "Bearer " + apiToken)
                .contentType(ContentType.JSON)
                .when()
                .post(requestUrl);
        //A successful response has 204 No Content status and an empty body
        Assert.assertEquals(resp.getStatusCode(), 204);
    }

    public void createTaskCloseTaskAndReopenUsingAPI() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd_HHmmss");
        Date date = new Date();
        String name = "Test " + formatter.format(date);
        int colorId = new Random().nextInt(20) + 30;

        String requestUrl = baseApiUrl + "/projects";
        Project proj = new Project();
        proj.setName(name);
        proj.setColor(ProjectColor.fromInt(colorId));
        Response resp =
                given()
                    .headers(
                            "Authorization",
                            "Bearer " + apiToken)
                    .contentType(ContentType.JSON)
                .when()
                    .body(proj)
                    .post(requestUrl);
        Log.info(resp.asPrettyString());
        JsonPath jsonPathEvaluator = resp.jsonPath();
        String createdProjectId = jsonPathEvaluator.get("id");
        Log.info(createdProjectId);
        requestUrl = baseApiUrl + "/tasks";
        Task task = new Task();
        task.setContent("New task created at " + formatter.format(date));
        task.setProjectId(createdProjectId);
        task.setPriority(4);
        resp =
                given()
                    .headers(
                            "Authorization",
                            "Bearer " + apiToken)
                    .contentType(ContentType.JSON)
                .when()
                    .body(task)
                    .post(requestUrl);
        Log.info(resp.asPrettyString());
        driver.findElement(homepageLoginButton).click();
        WebDriverWait wait = new WebDriverWait(driver, 30);
        WebElement username = wait.until(ExpectedConditions.visibilityOfElementLocated(usernameTextbox));
        username.click();
        username.sendKeys("danql@vmodev.com");
        WebElement password = driver.findElement(passwordTextbox);
        password.click();
        password.sendKeys("thisisapassword");
        driver.findElement(loginButton).click();
        driver.findElement(By.xpath("//a[@href='/app/project/"+ createdProjectId +"']")).click();

    }

}
