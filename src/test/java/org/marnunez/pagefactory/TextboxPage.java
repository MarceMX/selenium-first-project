package org.marnunez.pagefactory;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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
	@FindBy(id = "userName") WebElement fullName;
	@FindBy(id = "userEmail") WebElement email;
	@FindBy(id = "currentAddress") WebElement currentAddress;
	@FindBy(id = "permanentAddress") WebElement permanentAddress;
	@FindBy(xpath = "//button[@id='submit']") WebElement submitBtn;
	
	
	public void enterData(String name,String formEmail,String cAddress,String pAddress){
		fullName.sendKeys(name);
		email.sendKeys(formEmail);
		currentAddress.sendKeys(cAddress);
		permanentAddress.sendKeys(pAddress);
		submitBtn.click();
	}
}