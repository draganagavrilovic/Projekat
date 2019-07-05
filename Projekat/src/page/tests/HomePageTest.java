package page.tests;

import org.openqa.selenium.WebDriver;

import page.objects.HomePage;
import page.objects.RegistrationPage;

public class HomePageTest {

	public static void goHomePage(WebDriver dr) {

		HomePage.openPage(dr);
		if (dr.getCurrentUrl().contains(RegistrationPage.PAGE_URL)) {
			System.out.println("Otvara zadati URL");
		}
	}
}