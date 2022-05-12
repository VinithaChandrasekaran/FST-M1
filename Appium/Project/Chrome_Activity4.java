package liveProject;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class Chrome_Activity4 {
    AndroidDriver<MobileElement> driver;
    WebDriverWait wait;

    @BeforeClass
    public void beforeClass() throws MalformedURLException {
        // Set the Desired Capabilities
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", "SG9S9PZTTWGYNBH");
        caps.setCapability("platformName", "Android");
        caps.setCapability("automationName", "UiAutomator2");
        caps.setCapability("appPackage", "com.android.chrome");
        caps.setCapability("appActivity", "com.google.android.apps.chrome.Main");
        caps.setCapability("noReset", true);

        // Instantiate Appium Driver
        URL appServer = new URL("http://0.0.0.0:4723/wd/hub");
        driver = new AndroidDriver<>(appServer, caps);
        wait = new WebDriverWait(driver, 20);
    }
    @Test
    public void toDoList(){
        // Open page in browser
        driver.get("https://www.training-support.net/selenium");
        String UiScrollable = "UiScrollable(UiSelector().scrollable(true))";

        // wait for page to load
        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.xpath("//android.widget.Button[@text='Get Started!']")));


        /// Scroll to To do list
        driver.findElement(MobileBy.AndroidUIAutomator(UiScrollable + ".scrollForward(5).scrollIntoView(text(\"To-Do List\"))")).click();


        //Wait for new page to load
        wait.until(ExpectedConditions.presenceOfElementLocated(
                MobileBy.xpath("//android.widget.TextView[@text='To-Do List']")
        ));


        WebElement task = driver.findElementById("taskInput");
        task.sendKeys("Add tasks to list");
        driver.findElementByXPath("//android.widget.Button[@text='Add Task']").click();

        //Add task2
        MobileElement task2 = driver.findElementById("taskInput");
        task2.sendKeys("Get number of tasks");
        driver.findElementByXPath("//android.widget.Button[@text='Add Task']").click();

        //Add task3
        MobileElement task3 = driver.findElementById("taskInput");
        task3.sendKeys("Clear the list");
        driver.findElementByXPath("//android.widget.Button[@text='Add Task']").click();

        //strike
        MobileElement striketask1 = driver.findElementByXPath("//android.widget.TextView[@text='Add tasks to list']");
        striketask1.click();

        MobileElement striketask2 = driver.findElementByXPath("//android.widget.TextView[@text='Get number of tasks']");
        striketask2.click();

        MobileElement striketask3 = driver.findElementByXPath("//android.widget.TextView[@text='Clear the list']");
        striketask3.click();

        //Clearlist
        MobileElement clearlist = driver.findElementByXPath("//android.widget.TextView[@text='Clear List']");
        clearlist.click();

        // Assertions
        Assert.assertNotEquals(striketask1,"Add tasks to list");
        System.out.println("AssertNotEquals Test Passed\n");

    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }


}
