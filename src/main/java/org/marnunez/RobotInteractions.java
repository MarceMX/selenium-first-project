package org.marnunez;

import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.awt.*;
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
//		prefs.put("profile.default_content_settings.popups", 0);
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
		} catch (Exception e) {
			driver.quit();
		}
		
	}
}