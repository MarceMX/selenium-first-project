package org.marnunezt;

import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

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
			driver.get("https://www.facebook.com");
            System.out.println("Access Facebook page");
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