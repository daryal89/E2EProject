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

public class ValidateTitle extends TestBase {
	public static Logger log = LogManager.getLogger(TestBase.class.getName());

	@BeforeTest
	public void initialize() throws IOException {
		driver = initializeDriver();
		log.info("Driver is initialized");

		driver.get(prop.getProperty("url"));
		log.info("Navigated to landing page");
	}

	@Test
	public void validateAppTitle() throws IOException {
		// creating object to that class and invoke methods of it

		LandingPage l = new LandingPage(driver);

		// Compare the text from the browser with actual text

		System.out.println(l.getTitle().getText());

		Assert.assertEquals(l.getTitle().getText(), "FEATURED COURSES");
		log.info("Successfully validated text message");
	}

	@AfterTest
	public void tearDown() {
		driver.close();
		driver=null;
	}

}
