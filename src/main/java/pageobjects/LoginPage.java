package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

	public WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	By email = By.id("user_email");

	By password = By.id("user_password");

	By login = By.cssSelector("input.btn.btn-primary.btn-md.login-button");
	
	By alert =By.cssSelector("div.alert.alert-danger");

	public WebElement getemail() {
		return driver.findElement(email);
	}

	public WebElement getpassword() {
		return driver.findElement(password);
	}

	public WebElement getLogin() {
		return driver.findElement(login);
	}

	public WebElement getAlert() {
		return driver.findElement(alert);
	}
}
