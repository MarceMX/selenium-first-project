package com.xmartlabs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class InteractionsWithInputs {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "chromedriver");
        WebDriver driver = new ChromeDriver();

        driver.get("https://demoqa.com/");
        WebElement buttonElements = driver.findElement(By.xpath("//*[@id='app']/div/div/div[2]/div/div[1]/div/div[3]"));
        buttonElements.click();


        waiter(2000);
        //Llegamos a la pagina de "Elements"

        WebElement buttonTextBox = driver.findElement(By.xpath("(//*[@id='item-0'])[1]"));
        buttonTextBox.click();

        waiter(2000);


        /*
        Comenzamos la interacción con el formulario
         */

        String pFullName = "Una prueba de First Name";
        String pEmailAddress = "unemaildeprueba@test.com";
        String pAddress = "Una dirección de calle";
        String pPermanentAddress = "Una direccion permanente";

        WebElement inputFullName = driver.findElement(By.xpath("//*[@id='userName']"));
        inputFullName.sendKeys(pFullName);

        WebElement inputEmailAddress = driver.findElement(By.xpath("//*[@id='userEmail']"));
        inputEmailAddress.sendKeys(pEmailAddress);

        WebElement inputAddress = driver.findElement(By.xpath("//*[@id='currentAddress']"));
        inputAddress.sendKeys(pAddress);

        WebElement inputPermanentAddress = driver.findElement(By.xpath("//*[@id='permanentAddress']"));
        inputPermanentAddress.sendKeys(pPermanentAddress);

        waiter(5000);

        WebElement buttonSubmit = driver.findElement(By.xpath("//*[@id='submit']"));
        buttonSubmit.click();
        waiter(5000);

        /*
        Aca vamos a realizar las verificaciones
         */

        WebElement labelName = driver.findElement(By.xpath("//*[@id='name']"));
        if (labelName.getText().contains(pFullName)){
            System.out.println("El campo Name contiene el texto:" + pFullName);
        }else {
            System.out.println("El campo Name no contiene el texto deseado que es: " +pFullName);
        }

        WebElement labelEmail = driver.findElement(By.xpath("//*[@id='email']"));
        if (labelEmail.getText().contains(pEmailAddress)){
            System.out.println("El email address contiene el texto: "+ pEmailAddress);
        }else {
            System.out.println("El email es incorrecto");
        }

        WebElement labelCurrentAddress = driver.findElement(By.xpath("//p[@id='currentAddress']"));
        if (labelCurrentAddress.getText().contains(pAddress)){
            System.out.println("El campo address contiene el texto: "+ pAddress);
        }else {
            System.out.println("El campo address es incorrecto");
        }

        WebElement labelPermanentAddress = driver.findElement(By.xpath("//p[@id='permanentAddress']"));
        if (labelPermanentAddress.getText().contains(pPermanentAddress)){
            System.out.println("El campo permanent address contiene el texto: "+pPermanentAddress);
        }else{
            System.out.println("El campo permanent address es incorrecto.");
        }













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
