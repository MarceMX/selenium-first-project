package org.marnunez;

import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
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
public class InteractWithKeys {
	
	/**
	 * Class Constructor. No Requirement Reference
	 *
	 * @author <a href='mailto:marcela.nunez@gmail.com'>Marcela Nunez</a>
	 * @since 2022-Aug-18
	 */
	public void filloutForm() {
		String logID = "#InteractWithKeys():";
		log.trace("{} Start", logID);
		//checkNotNull("Impossible to create the object. The parameter can't be null.",parameter);
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		try {
			driver.get("https://demoqa.com/");
			log.debug("{}Navigation Menu",logID);
			driver.findElement(By.xpath("//h5[contains(text(),'Forms')]")).click();
			driver.findElement(By.xpath("//span[contains(text(),'Practice Form')]")).click();
			waitSec();
			
			Actions act = new Actions(driver);
			log.debug("{}Enter Information in form",logID);
			driver.findElement(By.id("firstName")).sendKeys("Marcela");
			act.click(driver.findElement(By.id("firstName")))
					.keyDown(Keys.CONTROL)
					.sendKeys("a")
					.sendKeys("c")
					.keyUp(Keys.CONTROL)
					.click(driver.findElement(By.id("lastName")))
					.keyDown(Keys.CONTROL)
					.sendKeys("v")
					.keyUp(Keys.CONTROL).build().perform();
			log.trace("{} Finish.", logID);
		} catch (Exception e) {
			driver.quit();
		}
	}
}