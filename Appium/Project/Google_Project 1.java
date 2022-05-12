package liveProject;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class GoogleTask_Activity1 {
    AndroidDriver<MobileElement> driver;
    WebDriverWait wait;

    @BeforeClass
    public void beforeClass() throws MalformedURLException {
        // Set the Desired Capabilities
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", "SG9S9PZTTWGYNBH");
        caps.setCapability("platformName", "Android");
        caps.setCapability("automationName", "UiAutomator2");
        caps.setCapability("appPackage", "com.google.android.apps.tasks");
        caps.setCapability("appActivity", ".ui.TaskListsActivity");
        caps.setCapability("noReset", true);

        // Instantiate Appium Driver
        URL appServer = new URL("http://0.0.0.0:4723/wd/hub");
        driver = new AndroidDriver<>(appServer, caps);
        wait = new WebDriverWait(driver, 10);
    }

    @Test
    public void googleTaskActivities(){
        //click on create new task button
        driver.findElementByAccessibilityId("Create new task").click();


        // Wait for fields to load
        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.id("add_task_title")));
        WebElement task = driver.findElementById("add_task_title");
        task.sendKeys("Complete Activity with Google Tasks");

        WebElement save= driver.findElementById("add_task_done");
        save.click();

        // Wait for task bar to appear
        wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.id("action_bar_root")));

        //clicking on "create new task" button for task2
        driver.findElementByAccessibilityId("Create new task").click();

        // Wait for fields to load
        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.id("add_task_title")));
         driver.findElementById("add_task_title").sendKeys("Complete Activity with Google Keep");
        driver.findElementById("add_task_done").click();

        // Wait for task bar to appear
        wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.id("action_bar_root")));

        //clicking on "create new task" button for task3
        driver.findElementByAccessibilityId("Create new task").click();

        // Wait for fields to load
        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.id("add_task_title")));

        driver.findElementById("add_task_title").sendKeys("Complete the second Activity Google Keep");
        driver.findElementById("add_task_done").click();



        String task1 = driver.findElementByAccessibilityId("Complete Activity with Google Tasks").getText();
        Assert.assertEquals(task1, "Complete Activity with Google tasks");

        String task2 = driver.findElementByAccessibilityId("Complete Activity with Google Keep").getText();
        Assert.assertEquals(task2, "Complete Activity with Google Keep");

        String task3 = driver.findElementByAccessibilityId("Complete the second Activity Google Keep").getText();
        Assert.assertEquals(task3, "Complete the second Activity Google Keep");

    }
    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
