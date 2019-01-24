package dbconnectionpackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SalesForceLoginPage {
	public WebDriver driver;

	public static String url = "https://login.salesforce.com/";

	public SalesForceLoginPage(WebDriver driver) {
		this.driver = driver;
	}

	By logo = By.id("logo");
	
	By checkbox = By.cssSelector("input#rememberUn");
	
	By username = By.id("username");

	By password = By.id("password");

	By login = By.id("Login");

	public WebElement getlogo() {
		return driver.findElement(logo);
	}

	public WebElement getusername() {
		return driver.findElement(username);
	}

	public WebElement getpassword() {
		return driver.findElement(password);
	}

	public WebElement getcheckbox() {
		return driver.findElement(checkbox);
	}

	public WebElement getlogin() {
		return driver.findElement(login);
	}

}
