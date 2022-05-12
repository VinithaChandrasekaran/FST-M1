package jobactivities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class OBJ_Activity6 {
    WebDriver driver;
    WebDriverWait wait;
    @BeforeMethod
    public void browserLaunch(){
        driver = new FirefoxDriver();
        driver.get("https://alchemy.hguy.co/jobs/");
        wait = new WebDriverWait(driver,20);
    }

    @Test
    public void applyJob()  {
        driver.findElement(By.id("menu-item-24")).click();

        driver.findElement(By.id("search_keywords")).sendKeys("Banking");

        //clicking on Search Jobs button
        driver.findElement(By.className("search_submit")).click();
        //waiting until list of jobs are displayed
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class='job_listings']/li[1]")));
        //clicking on a job
        WebElement job = driver.findElement(By.xpath("//h3"));
        job.click();
        //applying for job
        WebElement apply = driver.findElement(By.xpath("//input[@value='Apply for job']"));
        apply.click();
        //printing email
        String email = driver.findElement(By.xpath("//a[contains(@class,'job_application_email')]")).getText();
        System.out.println("Email is: "+email);

    }
    @AfterMethod
    public void afterMethod() {
        driver.quit();
    }
}
