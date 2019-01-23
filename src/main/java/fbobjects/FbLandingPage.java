package fbobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FbLandingPage {

	WebDriver driver;

	public FbLandingPage(WebDriver driver) {
		this.driver = driver;
	}

	By logo = By.id("email");

	By email = By.id("email");

	By password = By.id("pass");

	By login = By.cssSelector("#loginbutton");

	By forgotacc = By.linkText("Forgot account?");

	By firstname = By.name("firstname");

	By lastname = By.name("lastname");

	By enteremail = By.name("reg_email__");

	By conemail = By.name("reg_email_confirmation__");

	By newpass = By.name("reg_passwd__");

	By month = By.id("month");

	By day = By.id("day");

	By year = By.id("year");

	By female = By.cssSelector("[name='sex'][value='1']");

	By male = By.cssSelector("[name='sex'][value='2']");

	By signup = By.name("websubmit");
	
	By createpage = By.linkText("Create a Page");
	
	
	public WebElement getlogo() {
		return driver.findElement(logo);
	}
	
	public WebElement getemail() {
		return driver.findElement(email);
	}
	
	public WebElement getpassword() {
		return driver.findElement(password);
	}
	
	public WebElement getlogin() {
		return driver.findElement(login);
	}
	
	public WebElement forgotAccount() {
		return driver.findElement(forgotacc);
	}
	
	public WebElement getfirstname() {
		return driver.findElement(firstname);
	}
	
	public WebElement getlastname() {
		return driver.findElement(lastname);
	}
	
	public WebElement getenteremail() {
		return driver.findElement(enteremail);
	}
	
	public WebElement getconemail() {
		return driver.findElement(conemail);
	}
	
	public WebElement getregpassword() {
		return driver.findElement(newpass);
	}
	
	public WebElement getmonth() {
		return driver.findElement(month);
	}
	
	public WebElement getday() {
		return driver.findElement(day);
	}
	
	public WebElement getyear() {
		return driver.findElement(year);
	}
	
	public WebElement getfemale() {
		return driver.findElement(female);
	}
	
	public WebElement getmale() {
		return driver.findElement(male);
	}

	
	public WebElement getSignup() {
		return driver.findElement(signup);
	}
	
	public WebElement createPage() {
		return driver.findElement(createpage);
	}
}
