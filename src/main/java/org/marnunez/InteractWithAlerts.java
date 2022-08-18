package org.marnunez;

import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.marnunez.ExecutionUtils.waitSec;

/**
 * TODO: Complete class documentation
 *
 * @author <a href='mailto:marcela.nunez@gmail.com'>Marcela Nunez</a>
 * @since 2022-Aug-18
 */
@Slf4j
public class InteractWithAlerts {
	
	/**
	 * Class Constructor. No Requirement Reference
	 *
	 * @author <a href='mailto:marcela.nunez@gmail.com'>Marcela Nunez</a>
	 * @since 2022-Aug-18
	 */
	public void clickAlerts() {
		String logID = "#InteractWithAlerts():";
		log.trace("{} Start", logID);
		//checkNotNull("Impossible to create the object. The parameter can't be null.",parameter);
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		try {
			driver.get("https://demoqa.com/");
			log.debug("{}Go to Alerts section",logID);
//			driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div/div[3]/div/div[3]/h5")).click();
			driver.findElement(By.xpath("//h5[contains(text(),'Alerts, Frame & Windows')]")).click();
			waitSec();
//			driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[1]/div/div/div[3]/div/ul/li[2]/span")).click();
			driver.findElement(By.xpath("//body/div[@id='app']/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[3]/div[1]/ul[1]/li[2]")).click();
			waitSec();
			log.debug("{}Click first Alert button",logID);
//			driver.findElement((By.xpath("//*[@id=\"alertButton\"]"))).click();
			driver.findElement(By.xpath("//button[@id='alertButton']")).click();
			waitSec();
			log.debug("{}Close alert",logID);
			System.out.println("Alert 1: " + driver.switchTo().alert().getText());
			driver.switchTo().alert().accept();
			
			log.debug("{}Click second Alert button",logID);
//			driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[2]/div[2]/div[2]/button")).click();
			driver.findElement(By.xpath("//button[@id='timerAlertButton']")).click();
			waitSec();
			waitSec();
			System.out.println("Alert 2: " + driver.switchTo().alert().getText());
			driver.switchTo().alert().accept();
			log.debug("{}Click third Alert button",logID);
			for (int i = 0; i <= 1; i++) {
				driver.findElement(By.xpath("//*[@id=\"confirmButton\"]")).click();
				waitSec();
				System.out.println("Alert 3: " + driver.switchTo().alert().getText());
				if (i == 0) driver.switchTo().alert().dismiss();
				if (i == 1) driver.switchTo().alert().accept();
			}
			log.debug("{}Click fourth Alert button",logID);
			for (int i = 0; i <= 1; i++) {
				driver.findElement(By.xpath("//*[@id=\"promtButton\"]")).click();
				waitSec();
				System.out.println("Alert 4: " + driver.switchTo().alert().getText());
				driver.switchTo().alert().sendKeys("Enter text in an alert box " + i);
				waitSec();
				if (i == 0) driver.switchTo().alert().accept();
				if (i == 1) driver.switchTo().alert().dismiss();
			}
			log.trace("{} Finish.", logID);
			driver.close();
			driver.quit();
		} catch (Exception e) {
			driver.quit();
		}
	}
}