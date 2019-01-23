package fbtestcases;

import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.E2EProject.TestBase;

import fbobjects.FbLandingPage;

public class FbLandingPageTest extends TestBase {

	public static Logger log = LogManager.getLogger(TestBase.class.getName());

	@BeforeTest
	public void initialize() throws IOException {
		driver = initializeDriver();
		log.info("Driver is initialized !!!");
	}

	@Test
	public void validateFBLogo() {
		driver.get(prop.getProperty("fburl"));

		FbLandingPage fb = new FbLandingPage(driver);
		boolean b = fb.getlogo().isDisplayed();
		Assert.assertEquals(b, true);
	}

	// @Test
	public void fblogin() {
		driver.get(prop.getProperty("fburl"));
		log.info("Driver is initialized!!!");

		FbLandingPage fb = new FbLandingPage(driver);
		fb.getemail().sendKeys(prop.getProperty("femail"));
		fb.getpassword().sendKeys(prop.getProperty("fpass"));
		fb.getlogin().click();
		log.info("successfully logged in!");

	}

	// @Test
	public void fbRegistration() {
		driver.get(prop.getProperty("fburl"));
		log.info("Driver is initialized!!!");

		FbLandingPage fb = new FbLandingPage(driver);
		fb.getfirstname().sendKeys(prop.getProperty("firstname"));
		fb.getlastname().sendKeys(prop.getProperty("lastname"));
		fb.getenteremail().sendKeys(prop.getProperty("femail"));
		fb.getconemail().sendKeys(prop.getProperty("femail"));
		fb.getregpassword().sendKeys(prop.getProperty("fpass"));

		WebElement month = fb.getmonth();
		Select slc = new Select(month);
		slc.selectByIndex(10);

		WebElement day = fb.getday();
		Select slc1 = new Select(day);
		slc1.selectByValue("16");

		WebElement year = fb.getyear();
		Select slc2 = new Select(year);
		slc2.selectByVisibleText("1989");

		fb.getfemale().click();

		fb.getSignup().click();
		System.out.println("Signed up successfully!!!");
	}

	@Test
	public void loginPage() {
		driver.get(prop.getProperty("fburl"));

		FbLandingPage fb = new FbLandingPage(driver);
		fb.createPage().click();

	}

	@AfterTest
	public void tearDown() {
		driver.close();
		driver = null;
	}

}
