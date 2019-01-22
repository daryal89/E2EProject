package com.E2EProject;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import com.google.common.io.Files;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;
	public static FileInputStream fis;

	public WebDriver initializeDriver() throws IOException {
		prop = new Properties();
		fis = new FileInputStream(System.getProperty("user.dir") + "\\resources\\config.properties");
		prop.load(fis);

		String browserName = prop.getProperty("browser");
		System.out.println(browserName);

		if (browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "\\drivers\\chromedriver.exe");
			driver = new ChromeDriver();

		} else if (browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "\\drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
			// } else {
			// System.setProperty("webdriver.IE.driver", System.getProperty("user.dir") +
			// "\\drivers\\IEdriver.exe");
			// driver = new InternetExplorerDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(45, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		return driver;
	}

	public void getScrenshot(String result) throws IOException {

		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File(System.getProperty("user.dir") + "\\target\\" + result + "screenshot.png"));
	}

}
