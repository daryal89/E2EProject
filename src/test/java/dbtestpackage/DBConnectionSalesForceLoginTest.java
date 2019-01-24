package dbtestpackage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.E2EProject.TestBase;

import dbconnectionpackage.SalesForceLoginPage;

public class DBConnectionSalesForceLoginTest extends TestBase {
	public static Logger log = LogManager.getLogger(TestBase.class.getName());

	public static String url = "https://login.salesforce.com/";
	public static String host = "localhost";
	public static String port = "3306";
	public static String connectionurl = "jdbc:mysql://" + host + ":" + port + "/selenium";

	@BeforeTest
	public void initialize() throws IOException {
		driver = initializeDriver();
		log.info("driver is initialized ");
	}

	@Test
	public void checklogoisEnabled() {
		driver.get(url);
		SalesForceLoginPage sf = new SalesForceLoginPage(driver);
		boolean b = sf.getlogo().isEnabled();
		Assert.assertEquals(b, true);
	}

	@Test
	public void checklogoisDisplayed() {
		driver.get(url);
		SalesForceLoginPage sf = new SalesForceLoginPage(driver);
		boolean b = sf.getlogo().isDisplayed();
		Assert.assertEquals(b, true);
	}

	@Test
	public void checkboxisSelected() {
		driver.get(url);
		SalesForceLoginPage sf = new SalesForceLoginPage(driver);
		boolean b = sf.getlogo().isSelected();
		Assert.assertFalse(b );
	}

	@Test
	public void salesForceLogin() throws SQLException {
		driver.get(url);
		SalesForceLoginPage sf = new SalesForceLoginPage(driver);

		// 1. Create Connection
		Connection connection = DriverManager.getConnection(connectionurl, "root", "root");

		// 2. Create Statement
		Statement st = connection.createStatement();
		String query = "select * from banking where costumer_id=101;";

		// 3.Execute ResultSet

		ResultSet rs = st.executeQuery(query);
		while (rs.next()) {

			// getting the data from database and passing it to the testcase
			sf.getusername().sendKeys(rs.getString("username"));
			sf.getpassword().sendKeys(rs.getString("password"));
			sf.getlogin().click();

			System.out.println(rs.getString("password"));

			// 4. Close connection
			// connection.close();
		}

	}

	@AfterTest
	public void tearDown() {
		driver.close();
		driver = null;
	}
}
