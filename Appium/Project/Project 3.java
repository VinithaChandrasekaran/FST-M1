package liveProject;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class Reminder_Activity3 {
    AndroidDriver<MobileElement> driver;
    WebDriverWait wait;
    @BeforeClass
    public void beforeClass() throws MalformedURLException {
        // Set the Desired Capabilities
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", "SG9S9PZTTWGYNBH");
        caps.setCapability("platformName", "Android");
        caps.setCapability("automationName", "UiAutomator2");
        caps.setCapability("appPackage", "com.google.android.keep");
        caps.setCapability("appActivity", ".activities.BrowseActivity");
        caps.setCapability("noReset", true);

        // Instantiate Appium Driver
        URL appServer = new URL("http://0.0.0.0:4723/wd/hub");
        driver = new AndroidDriver<>(appServer, caps);
        wait = new WebDriverWait(driver, 10);
    }
    @Test
    public void remainderGoogleTasks() {
        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.AccessibilityId("New text note")));

        driver.findElementByAccessibilityId("New text note").click();


        // Wait for fields to load
        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.id("editable_title")));

        // Find the add task button
        MobileElement title = driver.findElementById("editable_title");
        MobileElement note = driver.findElementById("edit_note_text");

        // Enter the text in the fields
        title.sendKeys("Activity3Title");
        note.sendKeys("Activity3notes");

        // Click on Reminder
        driver.findElementByAccessibilityId("Single-column view").click();

        //Wait for reminder to show
        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.xpath("//android.widget.TextView[@text='Later today']")));
        //Add Reminder
        MobileElement reminder = driver.findElementByXPath("//android.widget.TextView[@text='Later today']");
        reminder.click();

        // Save the task
        driver.findElementByAccessibilityId("Open navigation drawer").click();

        // Wait for task bar to appear
        wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.AndroidUIAutomator("resourceId(\"com.google.android.keep:id/open_search_bar_text_view\")")));

        //go to Reminder page
        MobileElement reminderpage = driver.findElementByXPath("//android.widget.TextView[@text='Search your notes']");
        reminderpage.click();

        //Click on Reminder
        MobileElement reminderpage1 = driver.findElementById("zero_search_circle");
        reminderpage1.click();

        // Wait for task bar to appear
        wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.AndroidUIAutomator("resourceId(\"com.google.android.keep:id/search_actionbar_query_text\")")));



        String noteadded = driver.findElement(MobileBy.xpath("//android.widget.TextView[@text='Activity3Title']")).getText();
        Assert.assertEquals(noteadded, "Activity3Title");
        }
        @AfterClass
            public void afterClass() {
                driver.quit();
        }


    }
