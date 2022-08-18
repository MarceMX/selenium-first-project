package org.marnunez;

import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import static org.marnunez.ExecutionUtils.*;
@Slf4j
public class InteractionsWithSelect {

    public void execute() {
        String logID="::execute([]): ";
        log.trace("{}Start ",logID);
    
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        try {
            driver.get("https://demoqa.com/");
    
            try {
                log.debug("{}Navigate to Forms", logID);
                driver.findElement(By.xpath("//*[@id='app']/div/div/div[2]/div/div[2]/div/div[3]")).click();
            } catch (Exception exception) {
            
            }
//            driver.findElement(By.xpath("//*[@id='app']/div/div/div[2]/div[1]/div/div/div[2]/span/div")).click();
            waitSec();
            driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[1]/div/div/div[2]/div/ul/li/span")).click();
    
            //Select in form
            log.debug("{}Select value from list", logID);
            WebElement stateDd = driver.findElement(By.xpath("//*[@id='state']/div/div[1]/div[1]"));
            Select opt1 = new Select(stateDd);
    
            opt1.selectByIndex(1);
            waitSec();
            opt1.selectByValue("Haryana");
            waitSec();
            opt1.selectByVisibleText("Rajasthan");
        }catch(Exception e){
            driver.quit();
        }
    }
    
    public void dropDownSelect(){
        String logID="::dropDownSelect([]): ";
        log.trace("{}Start ",logID);
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        try {
    
            driver.get("http://www.facebook.com");
            log.debug("{}Create a new account", logID);
            driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/div/div/div/div[2]/div/div[1]/form/div[5]/a")).click();
            waitSec();
            log.debug("{}Select each birthday month", logID);
            WebElement monthDd = driver.findElement(By.name("birthday_month"));
            Select monthId = new Select(monthDd);
            monthId.selectByIndex(1);
            waitSec();
            monthId.selectByValue("Jun");
            waitSec();
            monthId.selectByVisibleText("Feb");
        }catch (Exception e){
            driver.quit();
        }
    }
}
