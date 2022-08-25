package org.marnunez;

import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.Map;

import static org.marnunez.ExecutionUtils.waitSec;

/**
 * TODO: Complete class documentation
 *
 * @author <a href='mailto:marcela.nunez@gmail.com'>Marcela Nunez</a>
 * @since 2022-Aug-22
 */
@Slf4j
public class RobotInteractions {
	
	/**
	 * Class Constructor. No Requirement Reference
	 *
	 * @author <a href='mailto:marcela.nunez@gmail.com'>Marcela Nunez</a>
	 * @since 2022-Aug-22
	 */
	public void downloadFile() {
		String logID = "#RobotInteractions():";
		log.trace("{} Start", logID);
		//checkNotNull("Impossible to create the object. The parameter can't be null.",parameter);
		Map<String, Object> prefs = new HashMap<>();
		prefs.put("profile.default_content_settings.popups", 0);
		prefs.put("safebrowsing.enabled", "true");
		
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("prefs", prefs);
		options.addArguments("start-maximized");
		options.addArguments("--safebrowsing-disable-download-protection");
		options.addArguments("--safebrowsing-disable-extension-blacklist");
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(options);
		try {
			
			driver.get("http://www.google.com");
			driver.findElement(By.xpath("//body/div[1]/div[3]/form[1]/div[1]/div[1]/div[1]/div[1]/div[2]/input[1]")).sendKeys("firefox download");
			driver.findElement(By.xpath("//body/div[1]/div[3]/form[1]/div[1]/div[1]/div[1]/div[1]/div[2]/input[1]")).sendKeys(Keys.ENTER);
			
			waitSec();
			driver.findElement(By.xpath("//*[@id=\"rso\"]/div[1]/div/div/div/div[1]/div/div/div[1]/div/a/h3")).click();
			waitSec();
			driver.findElement(By.xpath("//*[@id=\"download-button-thanks\"]/a")).click();
			
			log.debug("{}File has been downloaded into set folder Downloads",logID);
			waitSec();
			driver.close();
			driver.quit();
			
			log.trace("{} Finish.", logID);
		} catch (Exception e) {
			driver.quit();
		}
	}
	
	public void uploadFile(){
		String logID = "#RobotInteractions():";
		log.trace("{} Start", logID);
		//checkNotNull("Impossible to create the object. The parameter can't be null.",parameter);
		Map<String, Object> prefs = new HashMap<>();
//		prefs.put("download.default_directory", "C:\\Users\\Fedor\\Downloads");
//		prefs.put("download.prompt_for_download", false);
//		prefs.put("profile.default_content_settings.popups", 0);
		prefs.put("safebrowsing.enabled", "true");
		
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("prefs", prefs);
		options.addArguments("start-maximized");
		options.addArguments("--safebrowsing-disable-download-protection");
		options.addArguments("--safebrowsing-disable-extension-blacklist");
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(options);
		Actions actions = new Actions(driver);
		
		try {
			driver.get("https://demoqa.com/");
			driver.findElement(By.xpath("//h5[contains(text(),'Elements')]")).click();
			WebElement upSpan = driver.findElement(By.xpath("//span[contains(text(),'Upload and Download')]"));
			actions.moveToElement(upSpan).click().perform();
			WebElement upBtn = driver.findElement(By.xpath("//input[@id='uploadFile']"));
			actions.moveToElement(upBtn).click().perform();
			
			Robot r = new Robot();
			r.setAutoDelay(1000);
			StringSelection fl = new StringSelection("C:\\Users\\HP\\Desktop\\yes.png");
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(fl, null);
			
			r.keyPress(KeyEvent.VK_CONTROL);
			r.keyPress(KeyEvent.VK_V);
			
			r.keyRelease(KeyEvent.VK_CONTROL);
			r.keyRelease(KeyEvent.VK_V);
			
			r.keyPress(KeyEvent.VK_ENTER);
			r.keyRelease(KeyEvent.VK_ENTER);
			
			driver.close();
			driver.quit();
		} catch (Exception e) {
			System.out.println("Error in uploadFile: " + e);
			driver.quit();
		}
		
	}
}