package fbobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CreatePage {

	public WebDriver driver;

	public CreatePage(WebDriver driver) {
		this.driver = driver;
	}

	By join = By.cssSelector("div._yl4.rfloat._ohf");

	By logo = By.cssSelector("i.fb_logo.img.sp_9BdNWkW8OEw_1_5x.sx_cf6856");

	public WebElement joinorLoginFacebook() {
		return driver.findElement(join);
	}

	public WebElement fbLogo() {
		return driver.findElement(logo);
	}
}
