package jobactivities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class OBJ_Activity5 {
    WebDriver driver;
    @BeforeMethod
    public void browserLaunch(){
        driver = new FirefoxDriver();
        driver.get("https://alchemy.hguy.co/jobs/");
    }

    @Test
    public void validateJobPageTitle(){
        driver.findElement(By.id("menu-item-24")).click();
        String jobPageTitle = driver.getTitle();
        System.out.println("Jobs page title is: "+jobPageTitle);
        Assert.assertEquals("Jobs – Alchemy Jobs", jobPageTitle);

    }
    @AfterMethod
    public void browserClose(){
        driver.close();
    }
}
