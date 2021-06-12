package com.mifinity.helper;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PersonalDetails {

	public WebDriver driver;
	

	By name = By.name("firstName");
	
	By lastname = By.name("lastName");
	
	By dob = By.name("dob");
	
	By nationality = By.xpath("//input[@formcontrolname='nationality']");
	
	By mobile = By.name("phone");
	
	By address1 = By.name("addressLine1");
	
	By address2 = By.name("addressLine2");
	
	By city = By.name("city");
	
	By zip = By.name("postalCode");
	
	
	By submit = By.xpath("//div[@class='message']");
	
	
	
	
	
	public PersonalDetails(WebDriver driver) {
		
		this.driver=driver;
		
	}


	public WebElement name(){
		return driver.findElement(name);
	}
	
	public WebElement lastname() {
		return driver.findElement(lastname);
	}
	
	public WebElement submit() {
		return driver.findElement(submit);
	}
	
	public WebElement dob(){
		return driver.findElement(dob);
	}
	
	public WebElement nationality() {
		return driver.findElement(nationality);
	}
	
	public WebElement mobile(){
		return driver.findElement(mobile);
	}
	
	public WebElement address1() {
		return driver.findElement(address1);
	}
	
	public WebElement address2() {
		return driver.findElement(address2);
	}
	
	public WebElement city() {
		return driver.findElement(city);
	}
	public WebElement zip() {
		return driver.findElement(zip);
	}
	
	public  void selectNationality(String sugg, String sel) throws InterruptedException {
		
		WebElement ele=driver.findElement(nationality);
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
