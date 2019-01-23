package com.E2EProject;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageobjects.LandingPage;
import pageobjects.LoginPage;

public class HomePageTest extends TestBase {
	public static Logger log = LogManager.getLogger(TestBase.class.getName());

	@BeforeTest
	public void initialize() throws IOException {
		driver = initializeDriver();

	}

	@Test
	public void ValidateQAClickLogo() {
		driver.get(prop.getProperty("url"));
		LandingPage l = new LandingPage(driver);
		boolean b = l.checkLogo().isDisplayed();
		Assert.assertTrue(b);
		log.info("Assertion Passed !!!");
		System.out.println("Assertion passed : " + b);

	}

	@Test
	public void fbLogoDisplayed() {

		driver.get(prop.getProperty("url"));
		LandingPage l = new LandingPage(driver);
		boolean b = l.checkfblogo().isDisplayed();
		Assert.assertTrue(b);
		log.info("Assertion Passed !!!");
		System.out.println("Assertion passed : " + b);
	}

	@Test
	public void youtubeLogoDisplayed() {
		driver.get(prop.getProperty("url"));
		LandingPage l = new LandingPage(driver);
		boolean b = l.checkyoutube().isDisplayed();
		Assert.assertTrue(b);
		log.info("Assertion Passed !!!");
		System.out.println("Assertion passed : " + b);
	}

	@Test
	public void allCourseButtonDisplayed() {

		driver.get(prop.getProperty("url"));
		LandingPage l = new LandingPage(driver);
		boolean b = l.checkViewAllCourseButton().isDisplayed();
		Assert.assertTrue(b);
		log.info("Assertion Passed !!!");
		System.out.println("Assertion passed : " + b);
	}

	@Test(dataProvider = "getData")
	public void validateHomePage(String username, String password, String text) throws IOException {
		driver.get(prop.getProperty("url"));

		// printing the url in log file
		log.info("current url: " + driver.getCurrentUrl());

		// creating object to that class and invoke methods of it

		LandingPage l = new LandingPage(driver);
		l.getLogin().click();

		LoginPage lp = new LoginPage(driver);

		lp.getemail().sendKeys(username);
		lp.getpassword().sendKeys(password);

		log.info("text is: " + text);
		lp.getLogin().click();

		// printing alert message after login failure
		log.error(lp.getAlert().getText());
	}

	@DataProvider
	public Object[][] getData() {

		// Rows stands for how many different data types test should run
		// Column stands for how many values per each test
		Object[][] data = new Object[4][3];

		// 0th row
		data[0][0] = "nonrestircteduser@qa.com";
		data[0][1] = "123456";
		data[0][2] = "Restricted User";

		// 1st row
		data[1][0] = "restircteduser@qa.com";
		data[1][1] = "abc123";
		data[1][2] = "Non-Restricted User";

		// 2nd row
		data[2][0] = "Onetimeduser@qa.com";
		data[2][1] = "abcdefgh";
		data[2][2] = "Onetime User";

		// 3rd data set
		data[3][0] = "generaluser@qa.com";
		data[3][1] = "abc123";
		data[3][2] = "general User";
		return data;
	}

	@AfterTest
	public void tearDown() {
		driver.close();
		driver = null;
	}
}
