package com.E2EProject;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageobjects.LandingPage;

public class ValidateNavigationBar extends TestBase {
	public static Logger log = LogManager.getLogger(TestBase.class.getName()); 

	@BeforeTest
	public void initialize() throws IOException {
		driver = initializeDriver();
		driver.get(prop.getProperty("url"));
	}

	@Test
	public void validateNavigationBar() throws IOException {

		// creating object to that class and invoke methods of it

		LandingPage l = new LandingPage(driver);

		// Compare the text from the browser with actural text

		boolean b = l.getNavigationBar().isDisplayed();

		log.info("Navigation bar is dispalyed");
		Assert.assertTrue(b);
		// System.out.println("Isdisplayed: " + b);

	}

	@AfterTest
	public void tearDown() {
		driver.close();
		driver=null;
	}

}
