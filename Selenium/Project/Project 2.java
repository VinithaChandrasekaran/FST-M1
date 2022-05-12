package jobactivities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class OBJ_Activity2 {
    WebDriver driver;
    @BeforeMethod
    public void browserLaunch(){
        //Create a new instance of the Firefox driver
        driver = new FirefoxDriver();

        //Open browser
        driver.get("https://alchemy.hguy.co/jobs/");
    }
    @Test
    public void validateHeading(){
        String heading;
        heading = driver.findElement(By.xpath("//h1[@class='entry-title']")).getText();
        System.out.println(heading);
        Assert.assertEquals("Welcome to Alchemy Jobs",heading);

    }
    @AfterMethod
    public void browserClose(){
        driver.close();
    }

}
