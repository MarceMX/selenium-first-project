package org.marnunez.pagefactory;

import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * TODO: Complete class documentation
 *
 * @author <a href='mailto:marcela.nunez@gmail.com'>Marcela Nunez</a>
 * @since 2022-Aug-29
 */
@Slf4j
public class VerifyTextboxPage {
	WebDriver driver;
	TextboxPage T1;
	/**
	 * Class Constructor. No Requirement Reference
	 *
	 * @author <a href='mailto:marcela.nunez@gmail.com'>Marcela Nunez</a>
	 * @since 2022-Aug-29
	 */
	@BeforeMethod
	public void launch(){
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/text-box");
	}
	@Test
	public void vLogin() {
		String logID = "#VerifyTextboxPage():";
		log.trace("{} Start", logID);
		//checkNotNull("Impossible to create the object. The parameter can't be null.",parameter);
		try {
			T1 = PageFactory.initElements(driver, TextboxPage.class);
			T1.enterData("Marcela Nunez","mn@test.com","Mexico","World");
			
			log.trace("{} Finish.", logID);
		} catch (Exception e) {
			throw new RuntimeException("Impossible instantiate class VerifyTextboxPage due to an internal error.", e);
		}
	}
	@AfterMethod
	public void end(){
		driver.close();
	}
}