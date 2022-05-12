package jobactivities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class OBJ_Activity3 {
    WebDriver driver;
    @BeforeMethod
    public void browserLaunch(){
        //Create a new instance of the Firefox driver
        driver = new FirefoxDriver();

        //Open browser
        driver.get("https://alchemy.hguy.co/jobs/");
    }
    @Test
    public void validateImageURL(){
        WebElement headerimg = driver.findElement(By.xpath("//*[@id=\"post-16\"]/header/div/img"));
        System.out.println("The image source is : "+headerimg.getAttribute("src"));
    }
    @AfterMethod
    public void browserClose(){
        driver.close();
    }
}
