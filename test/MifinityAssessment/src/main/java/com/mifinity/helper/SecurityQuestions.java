package com.mifinity.helper;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SecurityQuestions {

	public WebDriver driver;
	

	By input1Ans = By.name("answerOne");
	
	By input2Ans = By.name("answerTwo");
	
	By dob = By.name("dob");
	
	By securityQ1 = By.xpath("//pc-select[@formcontrolname='securityQuestionOne']");
	
	By securityQ2 = By.xpath("//pc-select[@formcontrolname='securityQuestionTwo']");
	
	
	By submit = By.xpath("//div[@class='message']");
	
	
	
	public SecurityQuestions(WebDriver driver) {
		
		this.driver=driver;
		
	}


	public WebElement securityQ1(){
		return driver.findElement(securityQ1);
	}
	
	public WebElement input1Ans() {
		return driver.findElement(input1Ans);
	}
	
	public WebElement submit() {
		return driver.findElement(submit);
	}
	
	public WebElement securityQ2(){
		return driver.findElement(securityQ2);
	}
	
	public WebElement input2Ans() {
		return driver.findElement(input2Ans);
	}
	
	
	public  void selectSecurityQ1(String sel) throws InterruptedException {
		
		WebElement ele=driver.findElement(securityQ1);
		if(ele != null) {
			ele.click();
			Thread.sleep(1500);
			ele=driver.findElement(By.xpath("//div[@id='"+sel+"']"));//What was the name of your first pet?1
			if(ele != null) {
				ele.click();
				return;
			}
			
		}
	}
	
	public  void selectSecurityQ2(String sel) throws InterruptedException {
		
		WebElement ele=driver.findElement(securityQ2);
		if(ele != null) {
			ele.click();
			Thread.sleep(1500);
			ele=driver.findElement(By.xpath("//div[@id='"+sel+"']"));//What was your childhood nickname?2
			if(ele != null) {
				ele.click();
				return;
			}
			
		}
	}
	
	
}
