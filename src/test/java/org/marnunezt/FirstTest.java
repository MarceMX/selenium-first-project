package org.marnunezt;

import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

/**
 * TODO: Complete class documentation
 *
 * @author <a href='mailto:marcela.nunez@gmail.com'>Marcela Nunez</a>
 * @since 2022-Aug-23
 */
@Slf4j
public class FirstTest {
	
	/**
	 * Class Constructor. No Requirement Reference
	 *
	 * @author <a href='mailto:marcela.nunez@gmail.com'>Marcela Nunez</a>
	 * @since 2022-Aug-23
	 */
	WebDriver driver = null;
	
	@BeforeMethod
	public void initializeDriver(){
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}
    @Test (priority = 2)
	public void enterFb() {
		String logID = "#EnterFacebook():";
		log.trace("{} Start", logID);
		//checkNotNull("Impossible to create the object. The parameter can't be null.",parameter);
		try {
//			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//			driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
//			WebDriverWait w = new WebDriverWait(driver,20);
//			FluentWait w = new FluentWait(driver).pollingEvery(3, TimeUnit.SECONDS);
			driver.get("https://www.facebook.com");
			
            System.out.println("Access Facebook page");
//			w.until(ExpectedConditions.titleIs("Facebook - log in or sign up"));
			Assert.assertEquals(driver.getTitle(),"Facebook - log in or sign up");
			
			log.trace("{} Finish.", logID);
		} catch (Exception e) {
			throw new RuntimeException("Error while accessing Facebook.", e);
		}
	}
	@Test (priority = 1)
	public void enterGg(){
		String logID = "#EnterGoogle():";
		log.trace("{} Start", logID);
		//checkNotNull("Impossible to create the object. The parameter can't be null.",parameter);
		try {
			driver.get("https://www.google.com");
			System.out.println("Access Google page");
			Assert.assertEquals(driver.getTitle(),"Google");
			
			log.trace("{} Finish.", logID);
		} catch (Exception e) {
			throw new RuntimeException("Error while accessing Google.", e);
		}
	}
	
	@AfterMethod
	public void close(){
		driver.close();
		driver.quit();
	}
}