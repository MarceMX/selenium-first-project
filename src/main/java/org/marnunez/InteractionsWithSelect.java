package com.xmartlabs;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class InteractionsWithSelect {

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/");

        driver.findElement(By.xpath("//*[@id='app']/div/div/div[2]/div[1]/div/div/div[2]/span/div")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id='item-0']/span")).click();

        //Select in form
        WebElement stateDd = driver.findElement(By.xpath("//*[@id='state']/div/div[1]/div[1]"));
        Select opt1 = new Select(stateDd);

        opt1.selectByIndex(1);
        Thread.sleep(3000);
        opt1.selectByValue("Haryana");
        Thread.sleep(3000);
        opt1.selectByVisibleText("Rajasthan");
    }
}
