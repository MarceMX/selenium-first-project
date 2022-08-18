package org.marnunez;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.marnunez.ExecutionUtils.*;

public class InteractionsWithButtons {

    public void execute() {
//        System.setProperty("webdriver.chrome.driver", "chromedriver");
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.get("https://demoqa.com/");
        WebElement buttonElements = driver.findElement(By.xpath("//*[@id='app']/div/div/div[2]/div/div[1]/div/div[3]"));
        buttonElements.click();


        waitSec();
        //Llegamos a la pagina de "Elements"

        WebElement buttonRadioButton = driver.findElement(By.xpath("(//*[@id='item-2'])[1]"));
        buttonRadioButton.click();

        waitSec();

        //Comenzamos con la interacción con el radiobutton YES
        ////*[@id="app"]/div/div/div[2]/div[2]/div[2]/div[2]/label
        WebElement radioButtonYes = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[2]/div[2]/label"));
        if (radioButtonYes.isSelected() == false){
            System.out.println("El radio YES esta deseleccionado");
            radioButtonYes.click();
        }else{
            System.out.println("El radio YES esta seleccionad, lo cual esta MAL");
        }
        
        waitSec();

        // Ejecucion de lo que estamos realizando, instrucciones, y etc.
        driver.close();
        driver.quit();


    }

}
