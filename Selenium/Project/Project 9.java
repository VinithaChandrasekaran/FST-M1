package jobactivities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class OBJ_Activity9 {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeMethod
    public void beforeMethod() {
        driver = new FirefoxDriver();
        driver.get("https://alchemy.hguy.co/jobs/wp-admin");
        wait = new WebDriverWait(driver, 10);
    }

    @Test
    public void jobListBackEnd() {
        WebElement username = driver.findElement(By.id("user_login"));
        WebElement password = driver.findElement(By.id("user_pass"));

        username.sendKeys("root");
        password.sendKeys("pa$$w0rd");

        WebElement login = driver.findElement(By.id("wp-submit"));
        login.click();
        WebElement joblist = driver.findElement(By.xpath("//*[@id=\"menu-posts-job_listing\"]/a/div[3]"));
        joblist.click();

        WebElement addnew = driver.findElement(By.xpath("//*[@id=\"wpbody-content\"]/div[4]/a"));
        addnew.click();

        //need to input position
        String position = "Performance Tester";
        WebElement pos = driver.findElement(By.id("post-title-0"));
        pos.sendKeys(position);

        WebElement publish = driver.findElement(By.xpath("//button[@class='components-button editor-post-publish-panel__toggle editor-post-publish-button__button is-primary']"));
        publish.click();

        WebElement publish2 = driver.findElement(By.xpath("//button[@class='components-button editor-post-publish-button editor-post-publish-button__button is-primary']"));
        publish2.click();

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class='components-button is-secondary']")));
       WebElement viewJob = driver.findElement(By.xpath("//*[@class='components-button is-secondary']"));
        viewJob.click();

        String role = driver.findElement(By.xpath("//h1[contains(@class,'entry-title')]")).getText();
        Assert.assertEquals(role, position);
    }
    @AfterMethod
    public void afterMethod() {
        driver.quit();
    }


}