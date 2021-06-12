package com.mifinity.helper;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SignUpPage {

	public WebDriver driver;
	

	By signup = By.id("SignUp_text");
	
	By signupemail = By.cssSelector("[name='emailAddress']");
	
	By signuppassword=By.cssSelector("[name='password']");
	
	By repeatPassword=By.cssSelector("[name='repeatPassword']");
	
	By termsconditions=By.cssSelector("[class='dk-radio-check']");
	
	By createaccount=By.cssSelector("[id='CreateAccount_text']");
	
	By succesfulMsg = By.id("registrationAccepted");
	
	By activactionMsg = By.xpath("//h3");
	
	
	By email = By.name("username");
	
	By password = By.name("password");
	
	By loginbutton = By.id("LogIn_text");
	
	By travel = By.name("travel");
	
	
	
	
	
	
	
	public SignUpPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		
		this.driver=driver;
		
	}




	/*
	 * public LoginPage getLogin() { driver.findElement(signin).click(); LoginPage
	 * lp=new LoginPage(driver); return lp;
	 * 
	 * 
	 * 
	 * }
	 */

	public WebElement singup()
	{
		return driver.findElement(signup);
	}
	
	
	public WebElement signupemail()
	{
		return driver.findElement(signupemail);
	}
	
	public WebElement signuppassword()
	{
		return driver.findElement(signuppassword);
	}
	
	

	public WebElement repeatPassword()
	{
		return driver.findElement(repeatPassword);
	}
	
	public WebElement termsconditions()
	{
		return driver.findElement(termsconditions);
	}
	
	public WebElement createaccount()
	{
		return driver.findElement(createaccount);
	}
	

	public String getActualMessageAfterSignUp() {
		// TODO Auto-generated method stub
		return driver.findElement(succesfulMsg).getText();
	}
	
	
	public String getActualAccountActivatedMessage() {
		// TODO Auto-generated method stub
		return driver.findElement(activactionMsg).getText();
	}
	
	
	
	public WebElement email()
	{
		return driver.findElement(email);
	}
	
	
	public WebElement password()
	{
		return driver.findElement(password);
	}


	public WebElement loginbutton()
	{
		return driver.findElement(loginbutton);
	}
	
	
	
}
