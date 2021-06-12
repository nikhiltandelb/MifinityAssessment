package com.mifinity.browser;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Base64;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class TestUtils {

	/*
	 * Captures screenshot and returns the screenshot path
	 */
	public static String pullScreenshotPath() {

		String destination = null;

		File scrFile = ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.FILE);
		try {
			destination = System.getProperty("user.dir") + "\\Screenshots" + "\\" + Listeners.getTestcaseName() + "\\"
					+ System.currentTimeMillis() + ".png";
			FileUtils.copyFile(scrFile, new File(destination));
		} catch (Exception e) {
			e.printStackTrace();
		}

		return destination;

	}

	/*
	 * Gives a base64 image which is used to append the screenshots in the extent
	 * report. Converting to base64 format avoids screenshots broken image if sent
	 * the exent report through email.
	 */
	public static String getBase64Image(String screenshotpath) {
		String base64 = null;
		try {
			InputStream is = new FileInputStream(screenshotpath);
			byte[] imageBytes = IOUtils.toByteArray(is);
			base64 = Base64.getEncoder().encodeToString(imageBytes);
		} catch (Exception e) {

		}
		return base64;

	}

}
