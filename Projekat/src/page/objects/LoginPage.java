package page.objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	public static final String PAGE_URL = "http://localhost/izlet/index.php";
	private static final String USERNAME_LOG = "//input[@placeholder='username']";
	private static final String PASSWORD_LOG = "//input[@placeholder='password']";
	private static final String LOGIN = "//input[@name='login']";

	// Dodato pored username log-logovanje
	public static WebElement getUsernameLog(WebDriver dr) {
		WebElement wb = dr.findElement(By.xpath(USERNAME_LOG));
		return wb;
	}

	public static void clickUsernameLog(WebDriver dr) {
		getUsernameLog(dr).click();
	}

	public static void sendKeysUsernameLog(WebDriver dr, String str) {
		getUsernameLog(dr).sendKeys(str);
	}

	// password log
	public static WebElement getPasswordLog(WebDriver dr) {
		WebElement wb = dr.findElement(By.xpath(PASSWORD_LOG));
		return wb;
	}

	public static void clickPasswordLog(WebDriver dr) {
		getPasswordLog(dr).click();
	}

	public static void sendKeysPasswordLog(WebDriver dr, String str) {
		getPasswordLog(dr).sendKeys(str);
	}

	// Dugme Login
	public static WebElement getLogin(WebDriver dr) {
		WebElement wb = dr.findElement(By.xpath(LOGIN));
		return wb;
	}

	public static void clickLogin(WebDriver dr) throws InterruptedException {
		getLogin(dr).click();
		Thread.sleep(1000);
	}

	public static void navigateTo(WebDriver dr) {
		dr.navigate().to(PAGE_URL);
	}
}
