package org.marnunezt;

import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * TODO: Complete class documentation
 *
 * @author <a href='mailto:marcela.nunez@gmail.com'>Marcela Nunez</a>
 * @since 2022-Aug-23
 */
@Slf4j
public class SecondTest {
	
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
	public void enterAmz() {
		String logID = "#EnterAmazon():";
		log.trace("{} Start", logID);
		//checkNotNull("Impossible to create the object. The parameter can't be null.",parameter);
		try {
			driver.get("https://www.amazon.com");
            System.out.println("Access Amazon page");
			Assert.assertEquals(driver.getTitle(),"Amazon.com. Spend less. Smile more.");
			
			log.trace("{} Finish.", logID);
		} catch (Exception e) {
			throw new RuntimeException("Error while accessing Amazon.", e);
		}
	}
	@Test (priority = 1)
	public void enterCoca(){
		String logID = "#EnterCoca():";
		log.trace("{} Start", logID);
		//checkNotNull("Impossible to create the object. The parameter can't be null.",parameter);
		try {
			driver.get("https://www.coca-cola.com.mx/");
			System.out.println("Access Coca-Cola page");
			Assert.assertEquals(driver.getTitle(),"Coca-Cola Mexico | Sitio oficial");
			
			log.trace("{} Finish.", logID);
		} catch (Exception e) {
			throw new RuntimeException("Error while accessing Coca-Cola.", e);
		}
	}
	
	@AfterMethod
	public void close(){
		driver.close();
		driver.quit();
	}
}