package start;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import page.objects.HomePage;
import page.tests.DashboardPageTest;
import page.tests.HomePageTest;
import page.tests.LoginPageTest;
import page.tests.PostPageTest;
import page.tests.RegistrationPageTest;

public class GlavniProgram {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		try {
			HomePage.openPage(driver);

			HomePageTest.goHomePage(driver);

			// Prko skenera registruje korisnika, loguje ga, postavlja komentar i edituje
			// post
			RegistrationPageTest.fillFormUser(driver);
			LoginPageTest.testWithOneData(driver);
			PostPageTest.testPostUser(driver);
			DashboardPageTest.editPostUser(driver, 1);

			// Za jedan podatak iz excela registruje korisnika, loguje ga, postavlja
			// komentar i edituje post zadatog korisnika
			RegistrationPageTest.fillFormExcel(driver, 1);
			LoginPageTest.fillForm(driver, 1);
			PostPageTest.fillForm(driver, 1);
			DashboardPageTest.editPostUser(driver, 1);

			// sve podatke iz excela registruje korisnika, loguje ga, postavlja komentare za
			// sve korisnike
			RegistrationPageTest.testExcelAllData(driver);
			LoginPageTest.testExcelAllDataLog(driver);
			PostPageTest.testExcelAllDataPost(driver);

			// brise post prvog korisnika-2 puta pisem jer treba da izbrise 2 posta
			LoginPageTest.fillForm(driver, 1);
			PostPageTest.fillForm(driver, 1);
			DashboardPageTest.deletePost(driver, 0);
			DashboardPageTest.deletePost(driver, 0);

			// Izloguje se
			DashboardPageTest.LogOut(driver);

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			driver.quit();
		}

	}

}