package org.marnunez.pomodel;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

/**
 * TODO: Complete class documentation
 *
 * @author <a href='mailto:marcela.nunez@gmail.com'>Marcela Nunez</a>
 * @since 2022-Aug-29
 */
@Slf4j
public class TextboxPage {
	WebDriver driver;
	
	public TextboxPage(WebDriver driver1) {
		driver = driver1;
	}
	By fullName = By.id("userName");
	By email = By.id("userEmail");
	By currentAddress = By.id("currentAddress");
	By permanentAddress = By.id("permanentAddress");
	By submitBtn = By.xpath("//button[@id='submit']");
	
	public void enterData(String name,String formEmail,String cAddress,String pAddress){
		driver.findElement(fullName).sendKeys(name);
		driver.findElement(email).sendKeys(formEmail);
		driver.findElement(currentAddress).sendKeys(cAddress);
		driver.findElement(permanentAddress).sendKeys(pAddress);
		driver.findElement(submitBtn).click();
	}
}