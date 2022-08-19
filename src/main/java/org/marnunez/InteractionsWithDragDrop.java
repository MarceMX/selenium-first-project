package org.marnunez;

import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import static org.marnunez.ExecutionUtils.waitSec;

/**
 * TODO: Complete class documentation
 *
 * @author <a href='mailto:marcela.nunez@gmail.com'>Marcela Nunez</a>
 * @since 2022-Aug-18
 */
@Slf4j
public class InteractionsWithDragDrop {
	
	/**
	 * Class Constructor. No Requirement Reference
	 *
	 * @author <a href='mailto:marcela.nunez@gmail.com'>Marcela Nunez</a>
	 * @since 2022-Aug-18
	 */
	public void dragAndDrop() {
		String logID = "#InteractionsWithDragDrop():";
		log.trace("{} Start", logID);
		//checkNotNull("Impossible to create the object. The parameter can't be null.",parameter);
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		try {
			driver.get("https://demoqa.com/");
			Actions act = new Actions(driver);
			log.debug("{}Navigation Menu",logID);
			driver.findElement(By.xpath("//h5[contains(text(),'Interactions')]")).click();
			driver.findElement(By.xpath("//span[contains(text(),'Droppable')]")).click();
			waitSec();
			log.debug("{}Get the text fro drop box before drag function",logID);
			String beforeTxt = driver.findElement(By.xpath("//div[@id='simpleDropContainer']//div[@id='droppable']")).getText();
			log.debug("{}Assign draggable and droppable elements",logID);
			WebElement itemDrag = driver.findElement(By.xpath("//div[@id='draggable']"));
			WebElement itemDrop = driver.findElement(By.id("droppable"));
			act.dragAndDrop(itemDrag,itemDrop).perform();
			waitSec();
			String afterTxt = driver.findElement(By.xpath("//div[@id='simpleDropContainer']//div[@id='droppable']")).getText();
			System.out.println("Before text: " + beforeTxt + " // After text: " + afterTxt);
			if (beforeTxt.equalsIgnoreCase(afterTxt)) System.out.println("Message was NOT changed after drag and drop function");
			if (afterTxt.equals("Dropped!")) System.out.println("Success in message");
			
			/*
			log.debug("{}Go to Accept tab",logID);
			driver.findElement(By.xpath("//a[@id='droppableExample-tab-accept']")).click();
			WebElement acceptItem = driver.findElement(By.id("acceptable"));
			WebElement notAcceptItem = driver.findElement(By.id("notAcceptable"));
			System.out.println("After assign items to drag");
			
			act.dragAndDrop(acceptItem,itemDrop).perform();
			waitSec();
			System.out.println("drop first");
			act.dragAndDrop(notAcceptItem,itemDrop).perform();
			waitSec();
			System.out.println("drop second");
			if (itemDrop.getText().equals("Dropped!")) System.out.println("Items were dropped in box correctly");
			*/
			driver.close();
			driver.quit();
			log.trace("{} Finish.", logID);
		} catch (Exception e) {
			driver.quit();
		}
	}
}