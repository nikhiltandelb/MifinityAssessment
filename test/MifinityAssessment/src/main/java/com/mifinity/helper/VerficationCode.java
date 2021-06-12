package com.mifinity.helper;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class VerficationCode {

	public WebDriver driver;
	

	By code = By.name("verificationCodeSfa");
	
	
	By proceed = By.xpath("//div[@class='message']");
	
	
	
	public VerficationCode(WebDriver driver) {
		
		this.driver=driver;
		
	}

	public String getActualLabel() {
		
		WebElement ele=driver.findElement(By.xpath("/html/body/pg-root/div/pg-private-layout/pc-main-layout/div/div/section/div/layout-container/pg-ewallets/pc-master-view/div/div[1]/list/pc-master-view-list/div/div[1]/div"));
		return ele.getText();
	}

	public WebElement verificationCode(){
		return driver.findElement(code);
	}
	
	public WebElement proceed() throws InterruptedException {
		Thread.sleep(3500);
		return driver.findElement(proceed);
	}
	
	
}
