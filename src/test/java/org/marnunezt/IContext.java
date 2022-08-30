package org.marnunezt;

import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * TODO: Complete class documentation
 *
 * @author <a href='mailto:marcela.nunez@gmail.com'>Marcela Nunez</a>
 * @since 2022-Aug-29
 */
@Slf4j
public class IContext {
	WebDriver driver;
	/**
	 * Class Constructor. No Requirement Reference
	 *
	 * @author <a href='mailto:marcela.nunez@gmail.com'>Marcela Nunez</a>
	 * @since 2022-Aug-29
	 */
	@BeforeMethod
	public void Launch(ITestContext data){
		String userName = "mnunez";
		String password = "pwdtest";
		
		data.setAttribute("user", userName);
		data.setAttribute("pass", password);
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}
	@Test
	public void facebook(ITestContext data) {
		try {
			driver.get("https://www.facebook.com");
			driver.findElement(By.id("email")).sendKeys((String) data.getAttribute("user"));
			driver.findElement(By.id("pass")).sendKeys((String) data.getAttribute("pass"));
			driver.findElement(By.name("login")).click();
		}catch (Exception e){
			System.out.println("Error Facebook: " + e);
			driver.close();
		}
	}
	@Test
	public void demoQA(ITestContext data) {
		try {
			driver.get("https://demoqa.com/text-box");
			driver.findElement(By.id("userName")).sendKeys((String) data.getAttribute("user"));
			driver.findElement(By.id("currentAddress")).sendKeys((String) data.getAttribute("pass"));
			driver.findElement(By.id("submit")).click();
		}catch (Exception e){
			System.out.println("Error DemoQA: " + e);
			driver.close();
		}
	}
}