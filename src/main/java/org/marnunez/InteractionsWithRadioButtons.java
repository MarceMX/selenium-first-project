package com.xmartlabs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class InteractionsWithRadioButtons {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "chromedriver");
        WebDriver driver = new ChromeDriver();

        driver.get("https://demoqa.com/");
        WebElement buttonElements = driver.findElement(By.xpath("//*[@id='app']/div/div/div[2]/div/div[1]/div/div[3]"));
        buttonElements.click();


        waiter(2000);
        //Llegamos a la pagina de "Elements"

        WebElement buttonRadioButton = driver.findElement(By.xpath("(//*[@id='item-2'])[1]"));
        buttonRadioButton.click();

        waiter(5000);


        //Comenzamos con la interacción con el radiobutton YES
        WebElement radioButtonYes = driver.findElement(By.xpath("//*[@id='app']/div/div/div[2]/div[2]/div[1]/div[2]/label"));
        if (radioButtonYes.isSelected() == false){
            System.out.println("El radio YES esta deseleccionado");
            radioButtonYes.click();
        }else{
            System.out.println("El radio YES esta seleccionad, lo cual esta MAL");
        }
        
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
