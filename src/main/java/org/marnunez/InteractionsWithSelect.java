package org.marnunez;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import static org.marnunez.ExecutionUtils.*;

public class InteractionsWithSelect {

    public void execute() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/");

        driver.findElement(By.xpath("//*[@id='app']/div/div/div[2]/div[1]/div/div/div[2]/span/div")).click();
        waiter();
        driver.findElement(By.xpath("//*[@id='item-0']/span")).click();

        //Select in form
        WebElement stateDd = driver.findElement(By.xpath("//*[@id='state']/div/div[1]/div[1]"));
        Select opt1 = new Select(stateDd);

        opt1.selectByIndex(1);
        waiter();
        opt1.selectByValue("Haryana");
        waiter();
        opt1.selectByVisibleText("Rajasthan");
    }
}
