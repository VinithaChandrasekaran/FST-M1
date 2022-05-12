package jobactivities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class OBJ_Activity4 {
    WebDriver driver;
    @BeforeMethod
    public void browserLaunch(){
        driver = new FirefoxDriver();
        driver.get("https://alchemy.hguy.co/jobs/");
    }

    @Test
    public void validateSecondHeading(){
        String H2;
        H2 = driver.findElement(By.xpath("//h2[contains(text(),'Quia quis non')]")).getText();
        System.out.println("Second Heading is: " + H2);
        Assert.assertEquals("Quia quis non", H2);

    }
    @AfterMethod
    public void browserClose(){
        driver.close();
    }
}
