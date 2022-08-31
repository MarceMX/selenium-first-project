package org.marnunez.sikuli;

import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.testng.annotations.Test;
import static org.marnunez.ExecutionUtils.*;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * TODO: Complete class documentation
 *
 * @author <a href='mailto:marcela.nunez@gmail.com'>Marcela Nunez</a>
 * @since 2022-Aug-31
 */
@Slf4j
public class SikuliExample {
	WebDriver driver;
	/**
	 * Class Constructor. No Requirement Reference
	 *
	 * @author <a href='mailto:marcela.nunez@gmail.com'>Marcela Nunez</a>
	 * @since 2022-Aug-31
	 */
	@Test
	public void sikuliTest() {
		String logID = "#SikuliExample():";
		log.trace("{} Start", logID);
		//checkNotNull("Impossible to create the object. The parameter can't be null.",parameter);
		WebDriverManager.chromedriver().setup();
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		try {
			driver.get("https://demoqa.com/automation-practice-form");
			Screen s1 = new Screen();
			Pattern p1 = new Pattern("C:\\Users\\HP\\Documents\\GitHub\\selenium-first-project\\src\\test\\java\\org\\marnunez\\resources\\firstname.png");
			Pattern p2 = new Pattern("C:\\Users\\HP\\Documents\\GitHub\\selenium-first-project\\src\\test\\java\\org\\marnunez\\resources\\email.png");
			Pattern p3 = new Pattern("C:\\Users\\HP\\Documents\\GitHub\\selenium-first-project\\src\\test\\java\\org\\marnunez\\resources\\female.png");
			Pattern p4 = new Pattern("C:\\Users\\HP\\Documents\\GitHub\\selenium-first-project\\src\\test\\java\\org\\marnunez\\resources\\music.png");
			Thread.sleep(2000);
			
			s1.type(p1,"Marcela");
			s1.type(p2,"test@test.com");
			s1.click(p3);
			s1.click(p4);
			
			log.trace("{} Finish.", logID);
		} catch (Exception e) {
			driver.quit();
			throw new RuntimeException("Error in class SikuliExample.", e);
		}
	}
}