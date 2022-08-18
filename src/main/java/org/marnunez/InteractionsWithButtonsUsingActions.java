package com.xmartlabs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class InteractionsWithButtonsUsingActions {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "chromedriver");
        WebDriver driver = new ChromeDriver();

        driver.get("https://demoqa.com/");
        WebElement buttonElements = driver.findElement(By.xpath("//*[@id='app']/div/div/div[2]/div/div[1]/div/div[3]"));
        buttonElements.click();


        waiter(2000);
        //Llegamos a la pagina de "Elements"

        WebElement buttonButtons = driver.findElement(By.xpath("(//*[@id='item-4'])[1]"));
        buttonButtons.click();

        waiter(5000);

    //Comenzamos a trabajar con el boton de double click
        WebElement buttonDoubleClick = driver.findElement(By.xpath("//*[@id='doubleClickBtn']"));
        Actions action = new Actions(driver);
        action.doubleClick(buttonDoubleClick).build().perform();
        waiter(5000);

        WebElement buttonRightClick = driver.findElement(By.xpath("//*[@id='rightClickBtn']"));
        action.contextClick(buttonRightClick).build().perform();
        waiter(5000);














        // Ejecucion de lo que estamos realizando, instrucciones, y etc.
        driver.close();
        driver.quit();


    }




    public static void waiter(int pSeconds) {
        try {
            Thread.sleep(pSeconds);
        } catch (Exception e) {
            System.out.println("Algo ocurrió");
        }
    }
}
