package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ContactsPage {

	public WebDriver driver;

	public ContactsPage(WebDriver driver) {
		this.driver = driver;
	}

	By name = By.id("contact-input-name");

	By number = By.id("contact-input-mobile");

	By country = By.id("contact-input-name");

	By email = By.id("contact-input-email");

	By subject = By.id("contact-input-subject");

	By description = By.id("contact-input-message");

	By submit = By.cssSelector("button.btn.btn-primary");

	By contactform = By.cssSelector("h1");

	public WebElement getName() {
		return driver.findElement(name);
	}

	public WebElement getNumber() {
		return driver.findElement(number);
	}

	public WebElement getCountry() {
		return driver.findElement(country);
	}

	public WebElement getEmail() {
		return driver.findElement(email);
	}

	public WebElement getSubject() {
		return driver.findElement(subject);
	}

	public WebElement getDescription() {
		return driver.findElement(description);
	}

	public WebElement getSubmit() {
		return driver.findElement(submit);
	}

	public WebElement getContactForm() {
		return driver.findElement(contactform);
	}
}
