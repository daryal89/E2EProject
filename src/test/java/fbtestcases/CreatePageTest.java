package fbtestcases;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.E2EProject.TestBase;

import fbobjects.CreatePage;
import fbobjects.FbLandingPage;

public class CreatePageTest extends TestBase {

	public static Logger log = LogManager.getLogger(TestBase.class.getName());

	@BeforeTest
	public void initilize() throws IOException {
		driver = initializeDriver();
		log.info("Driver initialized !!");
	}

	@Test
	public void validateCreatePagelogo() {
		driver.get(prop.getProperty("fburl"));
		FbLandingPage fb = new FbLandingPage(driver);
		fb.createPage().click();

		CreatePage cp = new CreatePage(driver);
		boolean b = cp.fbLogo().isDisplayed();
		Assert.assertEquals(b, true);
		log.info("Assertion passed!!!");
	}

	@Test
	public void checkfbJoinlink() {
		driver.get(prop.getProperty("fburl"));
		FbLandingPage fb = new FbLandingPage(driver);
		fb.createPage().click();

		CreatePage cp = new CreatePage(driver);
		boolean b = cp.joinorLoginFacebook().isDisplayed();
		Assert.assertEquals(b, true);
		log.info("validation passed!!!");
	}

	@AfterTest
	public void tearDown() {
		driver.close();
		driver = null;
	}
}
