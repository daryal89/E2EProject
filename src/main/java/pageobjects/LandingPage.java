package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {

	public WebDriver driver;

	public LandingPage(WebDriver driver) {
		this.driver = driver;

	}

	By login = By.cssSelector("a[href*='sign_in']");

	By title = By.cssSelector("div.text-center");

	By navbar = By.cssSelector("ul.nav.navbar-nav.navbar-right");
	

	public WebElement getNavigationBar() {
		return driver.findElement(navbar);
	}

	public WebElement getLogin() {
		return driver.findElement(login);
	}

	public WebElement getTitle() {
		return driver.findElement(title);
	}
}
