package page.objects;
import org.openqa.selenium.*;

public class HomePage {
	public static final String PAGE_URL="http://localhost/izlet/";

	public static void openPage(WebDriver dr) {
		dr.get(PAGE_URL);
	}
	public static void navigateTo(WebDriver dr) {
		dr.navigate().to(PAGE_URL);
	}
}
