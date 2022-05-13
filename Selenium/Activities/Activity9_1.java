import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class Activity9_1 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new FirefoxDriver();

        //Open browser
        driver.get("https://training-support.net/selenium/selects");

        //Chosen option
        WebElement chosen = driver.findElement(By.id("single-value"));

        //Find dropdown
        Select dropdown = new Select(driver.findElement(By.id("single-select")));

        //Select second option by visible text
        dropdown.selectByVisibleText("Option 2");
        System.out.println(chosen.getText());
        Thread.sleep(1000);

        //Select third option by index
        dropdown.selectByIndex(3);
        System.out.println(chosen.getText());
        Thread.sleep(1000);

        //Select fourth option by value
        dropdown.selectByValue("4");
        System.out.println(chosen.getText());
        Thread.sleep(1000);

        //Get all options
        List<WebElement> options = dropdown.getOptions();
        //Print them
        System.out.println("Printing all the options of dropdown");
        for(WebElement option : options) {
            System.out.println("Option: " + option.getText());
        }

        //Close browser
        driver.close();
    }
}