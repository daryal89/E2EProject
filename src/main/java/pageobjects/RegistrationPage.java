package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegistrationPage {

	public WebDriver driver;

	public RegistrationPage(WebDriver driver) {
		this.driver = driver;
	}

	
	By fullname = By.id("user_name");

	By email = By.id("user_email");

	By password = By.id("user_password");

	By rpassword = By.id("user_password_confirmation");

	By chbox1 = By.id("user_unsubscribe_from_marketing_emails");

	By chbox2 = By.id("user_agreed_to_terms");

	
	By submit = By.cssSelector("input.btn.btn-primary.btn-md.signup-button");
	
	
	public WebElement getFullname() {
		return driver.findElement(fullname);
	}

	public WebElement getEmail() {
		return driver.findElement(email);
	}

	public WebElement getPassword() {
		return driver.findElement(password);
	}

	public WebElement confirmPassword() {
		return driver.findElement(rpassword);
	}

	public WebElement getMarketing() {
		return driver.findElement(chbox1);
	}

	public WebElement getTerms() {
		return driver.findElement(chbox2);
	}

	
	public WebElement signUp() {
		return driver.findElement(submit);
	}
}
