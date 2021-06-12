package com.mifinity.helper;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CreateEWalletPage {

	public WebDriver driver;
	

	By countryofResidence = By.xpath("//input[@formcontrolname='countryCode']");
	
	By currency = By.xpath("//input[@formcontrolname='currency']");
	
	By createWallet = By.id("CreateEwallet");
	
	
	
	public CreateEWalletPage(WebDriver driver) {
		
		this.driver=driver;
		
	}


	public WebElement countryofResidence(){
		return driver.findElement(countryofResidence);
	}
	
	public WebElement clickCreateWallet() {
		return driver.findElement(createWallet);
	}
	
	public  void selectCountryofResidence(String sugg, String sel) throws InterruptedException {
		
		WebElement ele=driver.findElement(countryofResidence);
		if(ele != null) {
			ele.sendKeys(sugg);
			Thread.sleep(1500);
			ele=driver.findElement(By.xpath("//div[@id='"+sel+"']"));
			if(ele != null) {
				ele.click();
				return;
			}
			
		}
	}
	
	public  void selectCountryCode(String sugg, String sel) throws InterruptedException {
		
		WebElement ele=driver.findElement(currency);
		if(ele != null) {
			ele.sendKeys(sugg);
			Thread.sleep(1500);
			ele=driver.findElement(By.xpath("//div[@id='"+sel+"']"));
			if(ele != null) {
				ele.click();
				return;
			}
			
		}
	}
	
}
