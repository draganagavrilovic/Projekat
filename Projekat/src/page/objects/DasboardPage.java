package page.objects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DasboardPage {
	public static final String DASHBOARDPAGE_URL = "http://localhost/izlet/dashboard.php";
	public static final String DASHBOARD_DUGME = "//a[contains(text(),'Make a post')]";
	// preko klase za dugme MY_FUNCTION, DELETE, EDIT, NADJI_POST
	public static final String MY_FUNCTION = "fa-ellipsis-v";
	public static final String DELETE = "fa-trash-alt";
	public static final String EDIT = "fa-edit";
	public static final String NADJI_POST = "posts";
	// editovanje posta
	private static final String EDIT_NAZIV = "//input[@id='title']";
	private static final String EDIT_LOKACIJA ="//input[@id='location']";
	private static final String EDIT_SLIKA = "edit-img";
	private static final String EDIT_IZBOR_PREVOZA ="//select[@id='transport']";
	private static final String EDIT_OPIS = "//textarea[@id='description']";
	public static final String POST_DUGME = "//div[@class='popupEdit']//input[@name='postSubmit']";
	public static final String LOGOUT="//a[contains(text(),'Logout')]";
			
	// pronadji post za brisanje
	public static WebElement getNadjiPost(WebDriver dr, int i) {
		List<WebElement> lst = dr.findElements(By.className(NADJI_POST));
		WebElement wb = lst.get(i);
		return wb;
	}

	public static void nadjiPost(WebDriver dr, int i) {
		getNadjiPost(dr, i).click();
	}

	// dugme MY FUNCTION
	public static WebElement getMyFunction(WebDriver dr, int i) {
		List<WebElement> lst = dr.findElements(By.className(MY_FUNCTION));
		WebElement wb = lst.get(i);
		return wb;
	}

	public static void clickMyFunction(WebDriver dr, int i) {
		getMyFunction(dr, i).click();
	}

	// pronadji post za edit
	public static WebElement getEdit(WebDriver dr, int i) {
		List<WebElement> lst = dr.findElements(By.className(EDIT));
		WebElement wb = lst.get(i);
		return wb;
	}

	public static void Edit(WebDriver dr, int i) {
		getEdit(dr, i).click();
	}

	// delete post
	public static WebElement getdeletePost(WebDriver dr, int i) {
		List<WebElement> lst = dr.findElements(By.className(DELETE));
		return lst.get(i);
	}
	public static void clicDelete(WebDriver dr, int i) {
		getdeletePost(dr, i).click();
	}
    //Dugme za postavljanje posta
	public static WebElement getPostDugme(WebDriver dr) {
	WebElement wb = dr.findElement(By.xpath(POST_DUGME));
	return wb;
	}
	public static void clickPostDugme(WebDriver dr) {
	getPostDugme(dr).click();
	}
	
	public static WebElement getLogout(WebDriver dr) {
	WebElement wb = dr.findElement(By.xpath(LOGOUT));
	return wb;
	}
	public static void clickLogout(WebDriver dr) {
	getLogout(dr).click();
	}

	public static WebElement getEditNaziv(WebDriver dr) {
		WebElement wb = dr.findElement(By.xpath(EDIT_NAZIV));
		return wb;
	}

	public static void clickEditNaziv(WebDriver dr) {
		getEditNaziv(dr).clear();
		getEditNaziv(dr).click();
	}
	public static void sendKeysNaziv(WebDriver dr, String str) {
		getEditNaziv(dr).sendKeys(str);
	}
	public static WebElement getEditLokacija(WebDriver dr) {
		WebElement wb = dr.findElement(By.xpath(EDIT_LOKACIJA));
		return wb;
	}

	public static void clickEditLokacija(WebDriver dr) {
		getEditLokacija(dr).clear();
		getEditLokacija(dr).click();
	
	}
	public static void sendKeysEditLokacija(WebDriver dr, String str) {
		getEditLokacija(dr).sendKeys(str);
	}
	public static WebElement getEditPrevoz(WebDriver dr) {
		WebElement wb = dr.findElement(By.xpath(EDIT_IZBOR_PREVOZA));
		return wb;
	}

	public static void clickEditPrevoz(WebDriver dr) {
		getEditPrevoz(dr).click();
	
	}
	public static void sendKeysEditPrevoz(WebDriver dr, String str) {
		getEditPrevoz(dr).sendKeys(str);
	}
	
	public static WebElement getEditOpis(WebDriver dr) {
		WebElement wb = dr.findElement(By.xpath(EDIT_OPIS));
		return wb;
	}
	public static void clickEditOpis(WebDriver dr) {
		getEditOpis(dr).clear();
		getEditOpis(dr).click();
		
		
	}
	public static void sendKeysEditOpis(WebDriver dr, String str) {
		getEditOpis(dr).sendKeys(str);
	}
}
