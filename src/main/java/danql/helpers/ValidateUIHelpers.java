package danql.helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;

public class ValidateUIHelpers {

    private WebDriver driver;
    private WebDriverWait wait;
    private final int timeoutWaitForPageLoaded = 30;

    public ValidateUIHelpers(WebDriver _driver) {
        driver = _driver;
        wait = new WebDriverWait(driver, 10);
    }

    public void clearText(By element) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
        driver.findElement(element).clear();
    }

    public void setText(By element, String value) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
        driver.findElement(element).sendKeys(value);
    }

    public void clickElement(By element) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
        driver.findElement(element).click();
    }

    public boolean verifyUrl(String url) {
        System.out.println(driver.getCurrentUrl());
        System.out.println(url);

        return driver.getCurrentUrl().contains(url); //True/False
    }

    public boolean verifyElementText(By element, String textValue) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
        return driver.findElement(element).getText().equals(textValue); //True/False
    }

    public boolean verifyElementExist(By element) {
        List<WebElement> listElement = driver.findElements(element);

        int total = listElement.size();

        return (total > 0);
    }

    public boolean verifyPageLoaded(String pageLoadedText) {
        waitForPageLoaded();
        List<WebElement> elementList = driver.findElements(By.xpath("//*[contains(text(),'" + pageLoadedText + "')]"));
        boolean res = elementList.size() > 0;
        System.out.println("Page loaded (" + res + "): " + pageLoadedText);
        return res;
    }

    // Wait

    public void waitForPageLoaded() {
        // wait for jQuery to loaded
        ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                try {
                    return ((Long) ((JavascriptExecutor) driver).executeScript("return jQuery.active") == 0);
                } catch (Exception e) {
                    return true;
                }
            }
        };

        // wait for Javascript to loaded
        ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                return ((JavascriptExecutor) driver).executeScript("return document.readyState")
                        .toString().equals("complete");
            }
        };

        try {
            wait = new WebDriverWait(driver, timeoutWaitForPageLoaded);
            wait.until(jQueryLoad);
            wait.until(jsLoad);
        } catch (Throwable error) {
            Assert.fail("Wait timeout...");
        }

    }

}