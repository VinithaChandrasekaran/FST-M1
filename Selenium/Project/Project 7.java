package jobactivities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class OBJ_Activity7 {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeMethod
    public void browserLaunch(){
        driver = new FirefoxDriver();
        driver.get("https://alchemy.hguy.co/jobs/");
        wait = new WebDriverWait(driver, 20);
    }

    @Test
    public void postJob() throws InterruptedException {
        WebElement postJob = driver.findElement(By.linkText("Post a Job"));
        postJob.click();

        WebElement yourEmail = driver.findElement(By.id("create_account_email"));
        yourEmail.sendKeys("alex14@gmai.com");

        String roleOfEmployee = "Test-Specialist";

        WebElement jobTitle = driver.findElement(By.id("job_title"));
        jobTitle.sendKeys(roleOfEmployee);

        Thread.sleep(2000);
        WebElement location = driver.findElement(By.tagName("select"));
        Select sel = new Select(location);
        sel.selectByVisibleText("Internship");

        Thread.sleep(2000);

        WebElement desc = driver.findElement(By.id("job_description_ifr"));
        desc.sendKeys(" Testing");

        WebElement applEmail = driver.findElement(By.id("application"));
        applEmail.sendKeys("app@gmail.com");

        WebElement companyName = driver.findElement(By.id("company_name"));
        companyName.sendKeys("IBM");

        WebElement preview = driver.findElement(By.xpath("//input[@value='Preview']"));
        preview.click();

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@value='Submit Listing']")));

        WebElement submitListing = driver.findElement(By.xpath("//input[@value='Submit Listing']"));
        submitListing.click();

        driver.findElement(By.xpath("//a[text()='click here']")).click();
        //Navigating to Jobs page to check posted job
        driver.findElement(By.id("menu-item-24")).click();

        driver.findElement(By.id("search_keywords")).sendKeys(roleOfEmployee);
        //clicking on Search Jobs button
        driver.findElement(By.className("search_submit")).click();
        //waiting until list of jobs are displayed
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class='job_listings']/li[1]")));
        //checking job with role is posted
        String checkRole = driver.findElement(By.xpath("//h3")).getText();
        Assert.assertEquals(checkRole, roleOfEmployee);
        Thread.sleep(2000);

    }
    @AfterMethod
    public void afterMethod() {
        driver.quit();
    }

    }
