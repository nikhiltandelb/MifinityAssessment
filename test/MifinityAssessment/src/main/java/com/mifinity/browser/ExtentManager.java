package com.mifinity.browser;

import com.relevantcodes.extentreports.ExtentTest;

public class ExtentManager {

	public static ThreadLocal<ExtentTest> exTest = new ThreadLocal<ExtentTest>();

	public static ExtentTest getExtTest() {
		return exTest.get();
	}

	public static void setExtentTest(ExtentTest test) {
		exTest.set(test);
	}

}
