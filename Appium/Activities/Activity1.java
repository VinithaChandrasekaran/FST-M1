package activities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class Activity1 {
    // Declare Android driver
    AndroidDriver<MobileElement> driver;
    @BeforeClass
    public void setup() throws MalformedURLException {
        //Desired capabilities
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceId", "NSM3Y18413034990");
        caps.setCapability("platformName", "android");
        caps.setCapability("automationName", "UiAutomator2");
        caps.setCapability("appPackage", "com.android.calculator2");
        caps.setCapability("appActivity", ".Calculator");
        caps.setCapability("noReset", true);

        //Server URL
        URL appServer = new URL("http://localhost:4723/wd/hub");
        driver = new AndroidDriver<>(appServer, caps);

        //Driver Initialization
        driver = new AndroidDriver<>(appServer, caps);
    }
    @Test
    public void add(){
        // Using resource-id finding digit 2
        driver.findElementById("digit_2").click();
        //Using Accessibility ID  finding * symbol
        driver.findElementByAccessibilityId("times").click();
        // Using resource-id finding digit 6
        driver.findElementById("digit_6").click();

        // Perform Calculation
        driver.findElementById("eq").click();

        String result = driver.findElementById("formula").getText();
        System.out.println(result);

        // Assertion
        Assert.assertEquals(result, "12");

    }
    @AfterClass
    public void tearDown() {
        // Close app
        driver.quit();
    }
}
