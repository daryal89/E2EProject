package com.E2EProject;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageobjects.ContactsPage;
import pageobjects.LandingPage;

public class ContactPageTest extends TestBase {
	public static Logger log = LogManager.getLogger(TestBase.class.getName());

	@BeforeTest
	public void initialize() throws IOException {
		driver = initializeDriver();
		log.info("Driver is initialized");
	}

	@Test
	public void createContact() throws IOException {
		// creating object to that class and invoke methods of it

		driver.get(prop.getProperty("url"));
		log.info("Navigated to landing page");
		
		LandingPage l = new LandingPage(driver);
		l.getContact().click();

		// Compare the text from the browser with actual text
		ContactsPage cp = new ContactsPage(driver);
		cp.getName().sendKeys(prop.getProperty("name"));
		cp.getNumber().sendKeys(prop.getProperty("mobile"));
		cp.getCountry().sendKeys(prop.getProperty("country"));
		cp.getEmail().sendKeys(prop.getProperty("emailaddress"));
		WebElement ele = cp.getSubject();
		Select sl = new Select(ele);
		sl.selectByIndex(2);
		cp.getDescription().sendKeys(prop.getProperty("description"));
		cp.getSubmit().click();
		System.out.println("Test is successful !!!");
	}

	@Test
	public void validateContact() {

		driver.get(prop.getProperty("url"));
		log.info("Navigated to landing page");

		LandingPage l = new LandingPage(driver);
		l.getContact().click();

		ContactsPage cp = new ContactsPage(driver);
		String text = cp.getContactForm().getText();
		System.out.println("text is: " + text);
		Assert.assertEquals(text, "CONTACT FORM");

	}

	@AfterTest
	public void tearDown() {
		driver.close();
		driver = null;
	}

}
