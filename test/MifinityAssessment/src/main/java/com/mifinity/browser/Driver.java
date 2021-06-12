package com.mifinity.browser;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Driver {

	public static WebDriver driver = null;
	static String generatedString;

	private Driver() throws InterruptedException {

		try {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} catch (Exception e) {
			e.getMessage();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://hostux.ninja/");
		generatedString = RandomStringUtils.randomAlphanumeric(4).toLowerCase();
		Thread.sleep(3000);
		
		WebElement set=driver.findElement(By.xpath("//input[@id='mat-input-0']"));
		if(set != null) {
			set.sendKeys(generatedString);
			WebElement clk=driver.findElement(By.xpath("//span[normalize-space()='Submit']"));
			if(clk != null) {
				clk.click();
			}
		}
		((JavascriptExecutor)driver).executeScript("window.open()");
	    switchTab(1);
	    driver.get("https://demo.mifinity.com/auth/login");

		DriverManager.setWebDriver(driver);

	}
	
	public static void refreshPage() throws InterruptedException {
		Thread.sleep(2000);
		driver.navigate().refresh();
		Thread.sleep(2000);
		
		return;
	}
	
	public static void openMailBox() {
		WebElement click=driver.findElement(By.xpath("//p[normalize-space()='Welcome to MiFinity']"));
		if(click != null) {
			click.click();
			click=driver.findElement(By.xpath("//a[normalize-space()='ACTIVATE']"));
			if(click != null) {
				click.click();
				return;
			}
		}
	}

	public static void switchTab(int index) {
		 ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		    driver.switchTo().window(tabs.get(index));
		    return;
	}
	public static void initialize() {
		if (DriverManager.getDriver() == null)
			try {
				new Driver();
			} catch (Exception e) {

			}

	}
	
	public static void closetab() {
		driver.close();
		return;
	}
	
	public static String getGeneratedEmail() {
		return generatedString+"@hostux.ninja";
		
	}
	
	
	public static void openActivactionLink() throws InterruptedException {
		Driver.switchTab(0);
		Driver.refreshPage();
		Driver.openMailBox();
		Driver.switchTab(2);
		return;
		
	}
	
	public static void quit() throws InterruptedException {
		Thread.sleep(3500);
		 driver.quit();
		 return;
		
	}
	

}
