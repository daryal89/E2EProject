package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {

	public WebDriver driver;

	public LandingPage(WebDriver driver) {
		this.driver = driver;
	}

	By title = By.cssSelector("div.text-center");

	By header = By.cssSelector("ul.nav.navbar-nav.navbar-right");

	By register = By.cssSelector("a[href*='sign_up']");
	
	By signin = By.cssSelector("a[href*='sign_in']");
	
	By logo = By.cssSelector("img.img-responsive.logo");
	
	By youtubelogo = By.cssSelector("i.fa.fa-youtube.fa-lg");
	
	By fblogo = By.cssSelector("i.fa.fa-facebook.fa-lg");
	
	By allcourse = By.cssSelector("a.btn.btn-primary");
	
	By contact = By.xpath("//a[@href='contact.php']");
	
	
	public WebElement getContact() {
		return driver.findElement(contact);
	}
	
	public WebElement checkViewAllCourseButton() {
		return driver.findElement(allcourse);
	}
	
	public WebElement checkyoutube() {
		return driver.findElement(youtubelogo);
	}
	
	public WebElement checkfblogo() {
		return driver.findElement(fblogo);
	}
	
	public WebElement checkLogo() {
		return driver.findElement(logo);
	}
	
	public WebElement getLogin() {
		return driver.findElement(signin);
	}

	public WebElement getTitle() {
		return driver.findElement(title);
	}

	public WebElement getNavigationBar() {
		return driver.findElement(header);
	}

	public WebElement getRegister() {
		return driver.findElement(register);
	}
}
