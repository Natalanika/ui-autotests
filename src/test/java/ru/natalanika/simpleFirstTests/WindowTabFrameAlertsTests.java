package ru.natalanika.simpleFirstTests;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class WindowTabFrameAlertsTests extends BaseTests {
    @Test
    void windowTest() {
        webDriver.get("https://demoqa.com/browser-windows");
        webDriver.findElement(By.id("tabButton")).click();
        String secondWindow = (String) webDriver.getWindowHandles().toArray()[1];
        webDriver.switchTo().window(secondWindow);
        webDriverWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//*[text()='This is a sample page']")));
    }

    @Test
    void frameTest() {
        webDriver.get("https://demoqa.com/frames");
        webDriver.switchTo().frame("frame1");
        webDriverWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//*[text()='This is a sample page']")));
        webDriver.switchTo().window(webDriver.getWindowHandle());
        webDriver.switchTo().frame("frame2");
        webDriverWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//*[text()='This is a sample page']")));
    }

    @Test
    void alertsTest() {
        webDriver.get("https://demoqa.com/alerts");
        webDriver.findElement(By.id("alertButton")).click();
        webDriver.switchTo().alert().accept();
    }
}
