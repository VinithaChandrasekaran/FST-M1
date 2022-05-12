package jobactivities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class OBJ_Activity1 {
    WebDriver driver;
    @BeforeMethod
    public void browserLaunch(){
        //Create a new instance of the Firefox driver
        driver = new FirefoxDriver();

        //Open browser
        driver.get("https://alchemy.hguy.co/jobs/");
    }
    @Test
    public void ValidateTitle() {
        String title = driver.getTitle();
        System.out.println("Page title is: " + title);
        Assert.assertEquals("Alchemy Jobs – Job Board Application", title);
    }
    @AfterMethod
    public void browserClose() {
        driver.close();
    }

}
