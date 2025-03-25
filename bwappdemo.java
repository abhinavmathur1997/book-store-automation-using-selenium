package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.concurrent.TimeoutException;

public class bwappdemo {
    public static void main(String[] args) throws InterruptedException, TimeoutException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Dell\\git\\SeleniumJavaFramework1\\SeleniumJavaFramework\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://bookcart.azurewebsites.net/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));

       
        WebElement slider = driver.findElement(By.cssSelector("input[type='range']")); 

      
        int offset = 27; 

       
        Actions actions = new Actions(driver);
        actions.clickAndHold(slider)
               .moveByOffset(offset, 0)
               .release()
               .perform();

     
   
        
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'Fiction')]"))).click();
        WebElement bookLink = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Harry Potter and the Goblet of Fire")));




        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button.mdc-button.mdc-button--raised.mat-mdc-raised-button.mat-primary.mat-mdc-button-base")));
    
        WebElement button = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button.mdc-button.mdc-button--raised.mat-mdc-raised-button.mat-primary.mat-mdc-button-base")));

 
        if (button.isDisplayed() && button.isEnabled()) {
            button.click();
        } else {
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", button);
        }



        
        
    }
}
