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
import pageobjects.RegistrationPage;

public class RegistrationPageTest extends TestBase {
	public static Logger log = LogManager.getLogger(TestBase.class.getName());

	@BeforeTest
	public void initialize() throws IOException {
		driver = initializeDriver();
		log.info("Driver is initialized");
	}

	@Test
	public void getRegister() throws IOException {
		// creating object to that class and invoke methods of it
		driver.get(prop.getProperty("url"));
		log.info("Navigated to landing page");
		
		LandingPage l = new LandingPage(driver);
		l.getRegister().click();

		RegistrationPage r = new RegistrationPage(driver);
		r.getFullname().sendKeys(prop.getProperty("fullname"));
		r.getEmail().sendKeys(prop.getProperty("email"));
		r.getPassword().sendKeys(prop.getProperty("pass"));
		r.confirmPassword().sendKeys(prop.getProperty("pass"));
		r.getMarketing().click();
		r.getTerms().click();
		r.signUp().click();

		log.info("Successfully validated text message");
	}

	@Test
	public void validateSignUpButtonDisplayed() {
		
		driver.get(prop.getProperty("url"));
		log.info("Navigated to landing page");
		
		LandingPage l = new LandingPage(driver);
		l.getRegister().click();

		RegistrationPage r = new RegistrationPage(driver);
		boolean b = r.signUp().isDisplayed();
		Assert.assertTrue(b);
		log.info("Assertion passed !!!");

	}

	@AfterTest
	public void tearDown() {
		driver.close();
		driver = null;
	}

}
