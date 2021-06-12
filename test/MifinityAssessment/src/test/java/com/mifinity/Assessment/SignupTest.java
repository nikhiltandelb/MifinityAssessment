package com.mifinity.Assessment;

import java.io.IOException;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.mifinity.browser.BaseTest;
import com.mifinity.browser.Driver;
import com.mifinity.browser.DriverManager;
import com.mifinity.helper.CreateEWalletPage;
import com.mifinity.helper.PersonalDetails;
import com.mifinity.helper.SecurityQuestions;
import com.mifinity.helper.SignUpPage;
import com.mifinity.helper.VerficationCode;


@Listeners(com.mifinity.browser.Listeners.class)

public class SignupTest extends BaseTest {
	SoftAssert softAssert = new SoftAssert();

	//Create an automated frontend script performing a user signup, a successful sign up ends on the eWallet details page. Assert all the success messages.
	@Test
	public void signup() throws IOException, InterruptedException {

		// creating object to that class and invoke methods of it
		System.out.println(Driver.getGeneratedEmail());
		SignUpPage sign = new SignUpPage(DriverManager.getDriver());
		CreateEWalletPage createWallet = new CreateEWalletPage(DriverManager.getDriver());
		PersonalDetails personalDetails = new PersonalDetails(DriverManager.getDriver());
		SecurityQuestions securityQ = new SecurityQuestions(DriverManager.getDriver());
		VerficationCode code=new VerficationCode(DriverManager.getDriver());
		
		sign.singup().click();
		sign.signupemail().sendKeys(Driver.getGeneratedEmail());
		sign.signuppassword().sendKeys("Mifinity@123");
		sign.repeatPassword().sendKeys("Mifinity@123");
		sign.termsconditions().click();
		sign.createaccount().click();
		
		String expectedMessage = "Registration accepted";
		String actualMessage = sign.getActualMessageAfterSignUp();
		softAssert.assertEquals(expectedMessage, actualMessage, "Both Messages are not matching");
		
		Driver.openActivactionLink();
		String expectedMsg = "Your account is now fully activated. Please log in.";
		String actualMsg = sign.getActualAccountActivatedMessage();
		softAssert.assertEquals(expectedMsg, actualMsg, "Both Messages are not matching");
		
		sign.email().sendKeys(Driver.getGeneratedEmail());
		sign.password().sendKeys("Mifinity@123");
		sign.loginbutton().click();
		
		createWallet.selectCountryofResidence("Ire","ireland");
		createWallet.selectCountryCode("Ca","cad");
		createWallet.clickCreateWallet().click();
		
		personalDetails.name().sendKeys("Nikhil");
		personalDetails.lastname().sendKeys("Test");
		personalDetails.dob().sendKeys("15101999");
		personalDetails.selectNationality("fi", "filipino");
		personalDetails.mobile().sendKeys("9635588954");
		personalDetails.address1().sendKeys("address 1 here");
		personalDetails.address2().sendKeys("address 2 here");
		personalDetails.city().sendKeys("Mumbai");
		personalDetails.zip().sendKeys("256258");
		personalDetails.submit().click();
		
		securityQ.selectSecurityQ1("What was the name of your first pet?1");
		securityQ.input1Ans().sendKeys("cat");
		securityQ.selectSecurityQ2("What was your childhood nickname?2");
		securityQ.input2Ans().sendKeys("nik");
		securityQ.submit().click();
		
		code.verificationCode().sendKeys("123456");
		code.proceed().click();
		
		String expected = "eWallets";
		String actual = code.getActualLabel();
		softAssert.assertEquals(expected, actual, "Both Messages are not matching");
		
		softAssert.assertAll();
		Driver.quit();
		System.out.println("Completed");
		
		
		
	}

	

}
