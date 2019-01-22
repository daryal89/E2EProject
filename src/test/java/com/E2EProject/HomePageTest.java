package com.E2EProject;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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
		Object[][] data = new Object[2][3];

		// 0th row
		data[0][0] = "nonrestircteduser@qa.com";
		data[0][1] = "123456";
		data[0][2] = "Restricted User";

		// 1st row
		data[1][0] = "restircteduser@qa.com";
		data[1][1] = "123456";
		data[0][2] = "Non-Restricted User";

		return data;
	}

	@AfterTest
	public void tearDown() {
		driver.close();
		driver = null;
	}
}
