package page.objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
public class PostPage {
	public static final String PAGE_URL = "http://localhost/izlet/izlet/dashboard.php";
	public static final String SLIKA_PATH = "C:Users\\Pc\\eclipse-workspace-dragana.projekat\\Projekat\006-Pobednik-na-Kalemegdanu-Beograd.jpg";
	private static final String MAKEPOST = "//a[contains(text(),'Make a post')]";
	private static final String NAZIV = "//input[@placeholder='Naziv']";
	private static final String LOKACIJA = "//input[@placeholder='Lokacija']";
	private static final String BROWSE = "image"; // id
	private static final String IZBOR_PREVOZA = "transport"; // class
	private static final String OPIS = "//textarea[@placeholder='Opis']";
	private static final String POST_DUGME = "//div[@class='popupPost']//input[@value='Post']";

	// Dugme napravi post
	public static WebElement getMakePost(WebDriver dr) {
		WebElement wb = dr.findElement(By.xpath(MAKEPOST));
		return wb;
	}

	public static void clickMakePost(WebDriver dr) {
		getMakePost(dr).click();
	}

	public static void sendKeysMakePost(WebDriver dr, String str) {
		getMakePost(dr).sendKeys(str);
	}

	// Naziv posta
	public static WebElement getNaziv(WebDriver dr) {
		WebElement wb = dr.findElement(By.xpath(NAZIV));
		return wb;
	}

	public static void clickNaziv(WebDriver dr) {
		getNaziv(dr).click();
	}

	public static void sendKeysNaziv(WebDriver dr, String str) {
		getNaziv(dr).sendKeys(str);
	}

	// popunjavanje forme posta - Lokacija
	public static WebElement getLokacija(WebDriver dr) {
		WebElement wb = dr.findElement(By.xpath(LOKACIJA));
		return wb;
	}

	public static void clickLokacija(WebDriver dr) {
		getLokacija(dr).click();
	}

	public static void sendKeysLokacija(WebDriver dr, String str) {
		getLokacija(dr).sendKeys(str);
	}

	// popunjavanje forme posta - Opis
	public static WebElement getOpis(WebDriver dr) {
		WebElement wb = dr.findElement(By.xpath(OPIS));
		return wb;
	}

	public static void clickOpis(WebDriver dr) {
		getOpis(dr).click();
	}

	public static void sendKeysOpis(WebDriver dr, String str) {
		getOpis(dr).sendKeys(str);
	}

	// postavljnje slike
	public static WebElement getBROWSE(WebDriver dr) throws InterruptedException {
		WebElement wb = dr.findElement(By.id(BROWSE));
		return wb;

	}

	public static void ucitajSliku(WebDriver dr) throws InterruptedException {
		getBROWSE(dr).sendKeys(
				"C:\\Users\\Pc\\eclipse-workspace-dragana.projekat\\Projekat\\006-Pobednik-na-Kalemegdanu-Beograd.jpg");
		Thread.sleep(1000);
	}

	// Izbor prevoznog sredstva
	public static WebElement getPrevoz(WebDriver dr) {
		WebElement wb = dr.findElement(By.className(IZBOR_PREVOZA));
		return wb;
	}

	public static void izborPrevoza(WebDriver dr, String str) throws InterruptedException {
		Select izbor_prevoza = new Select(getPrevoz(dr));
		izbor_prevoza.selectByVisibleText("Car");
		Thread.sleep(1000);
	}

	public static void clickgetPrevoz(WebDriver dr) throws InterruptedException {
		getPrevoz(dr).click();
		Thread.sleep(500);
	}

	// Dugme za postavljanje posta
	public static WebElement getPostDugme(WebDriver dr) {
		WebElement wb = dr.findElement(By.xpath(POST_DUGME));
		return wb;
	}

	public static void clickPostDugme(WebDriver dr) {
		getPostDugme(dr).click();

	}

	public static void navigateTo(WebDriver dr) {
		dr.navigate().to(PAGE_URL);
	}
}
