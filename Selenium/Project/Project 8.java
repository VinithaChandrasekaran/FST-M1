package jobactivities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class OBJ_Activity8 {
    WebDriver driver;


    @BeforeMethod
    public void browserLaunch(){
        driver = new FirefoxDriver();
        driver.get("https://alchemy.hguy.co/jobs/wp-admin");

    }

    @Test
    public void backEndLogin(){
        WebElement username = driver.findElement(By.id("user_login"));
        WebElement password = driver.findElement(By.id("user_pass"));

        username.sendKeys("root");
        password.sendKeys("pa$$w0rd");

        WebElement login = driver.findElement(By.id("wp-submit"));
        login.click();
        System.out.println("New page title is: " + driver.getTitle());

        Assert.assertEquals(driver.getTitle(), "Dashboard ‹ Alchemy Jobs — WordPress");

    }
    @AfterMethod
    public void afterMethod() {
        driver.quit();
    }
}
