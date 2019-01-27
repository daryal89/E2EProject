package seleniumgridTest;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class GridTest {

	public static Logger log = LogManager.getLogger(GridTest.class.getName());

	public WebDriver driver;
	String url = "https://www.facebook.com/";

	@BeforeTest
	public WebDriver initialize() throws MalformedURLException {
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setBrowserName("chrome");
		dc.setPlatform(Platform.WIN10);
		// ChromeOptions options = new ChromeOptions();
		// options.merge(dc);

		String nodeurl = "http://192.168.28.1:4445/wd/hub";
		driver = new RemoteWebDriver(new URL(nodeurl), dc);

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(45, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();

		return driver;
	}

	By forgotacc = By.linkText("Forgot account?");

	@Test
	public void fbRegistration() {
		driver.get(url);
		log.info("Driver is initialized!!!");

		driver.findElement(By.name("firstname")).sendKeys("Ramesh");
		driver.findElement(By.name("lastname")).sendKeys("Sharma");
		driver.findElement(By.name("reg_email__")).sendKeys("Ramesh123@gmail.com");
		driver.findElement(By.name("reg_email_confirmation__")).sendKeys("Ramesh123@gmail.com");
		driver.findElement(By.name("reg_passwd__")).sendKeys("abc123");

		WebElement month = driver.findElement(By.id("month"));
		Select slc = new Select(month);
		slc.selectByIndex(10);

		WebElement day = driver.findElement(By.id("day"));
		Select slc1 = new Select(day);
		slc1.selectByValue("16");

		WebElement year = driver.findElement(By.id("year"));
		Select slc2 = new Select(year);
		slc2.selectByVisibleText("1989");

		driver.findElement(By.cssSelector("[name='sex'][value='1']")).click();

		driver.findElement(By.name("websubmit")).click();

		System.out.println("Signed up successfully!!!");
	}

	@Test
	public void validateFBLogo() throws MalformedURLException {
		driver.get(url);
		boolean b = driver.findElement(By.id("email")).isDisplayed();
		Assert.assertEquals(b, true);
	}

	@Test
	public void fblogin() {
		driver.get(url);
		log.info("Driver is initialized!!!");

		driver.findElement(By.id("email")).sendKeys("Ramesh123@gmail.com");
		driver.findElement(By.id("pass")).sendKeys("Ramesh123@gmail.com");
		driver.findElement(By.cssSelector("#loginbutton")).click();
		log.info("successfully logged in!");
	}

	@Test
	public void loginPage() {
		driver.get(url);
		driver.findElement(By.linkText("Create a Page")).click();

		System.out.println("Logged in successfully");
	}

	@Test
	public void validateCreatePagelogo() throws MalformedURLException {
		driver.get(url);
		driver.findElement(By.linkText("Create a Page")).click();
		boolean b = driver.findElement(By.xpath("//a[@title='Go to Facebook Home']")).isDisplayed();
		Assert.assertEquals(b, true);
		log.info("Validated createpagelogo successfully");
	}

	@Test
	public void checkfbJoinlink() {
		driver.get(url);
		driver.findElement(By.linkText("Create a Page")).click();
		boolean b = driver.findElement(By.cssSelector("div._yl4.rfloat._ohf")).isDisplayed();
		Assert.assertEquals(b, true);
		log.info("joinlink validation passed!!!");
	}

	@AfterTest
	public void tearDown() {
		driver.close();
		driver = null;
	}

}
