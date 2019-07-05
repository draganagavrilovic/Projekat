package page.tests;
import java.util.Scanner;
import org.openqa.selenium.WebDriver;
import page.objects.PostPage;
import utility.Constant;
import utility.ExcelUtils;
public class PostPageTest {
private static String str;

		// test sa jednim podatkom koji unosimo sami
		public static void testPostUser(WebDriver dr) throws InterruptedException {
		Scanner sc = new Scanner(System.in);
		PostPage.clickMakePost(dr);
		// naziv posta
		System.out.println("Unesi Naziv");
		String Naziv = sc.nextLine();
		PostPage.sendKeysNaziv(dr, Naziv);

		// lokacija
		System.out.println("Unesi Lokacija");
		String Lokacija = sc.nextLine();
		PostPage.sendKeysLokacija(dr, Lokacija);
		
		//slika
		//PostPage.sendKeysBROWSE(dr, str);
		
		//izbor prevoza
		//PostPage.clickgetPrevoz(dr);
		System.out.println("Izaberi prevozno sredstvo");
		String prevoz = sc.nextLine();
		PostPage.sendKeysLokacija(dr, prevoz);

		// opis posta
		System.out.println("Unesi Opis");
		String Opis = sc.nextLine();
		PostPage.sendKeysOpis(dr, Opis);

		PostPage.clickPostDugme(dr);
	}

	// popunjavanje iz Excela(redovi i kolone)
	public static void fillForm(WebDriver dr, int i) throws Exception {
		PostPage.clickMakePost(dr);
		String data;
		ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData, Constant.SHEET_NAME1);

		PostPage.clickNaziv(dr);
		data = ExcelUtils.getCellData(i, 1);
		PostPage.sendKeysNaziv(dr, data);
		
		PostPage.clickLokacija(dr);
		data = ExcelUtils.getCellData(i, 2);
		PostPage.sendKeysLokacija(dr, data);

		PostPage.ucitajSliku(dr);
		
		PostPage.izborPrevoza(dr, str);
		
		PostPage.clickOpis(dr);
		data = ExcelUtils.getCellData(i, 0);
		PostPage.sendKeysOpis(dr, data);

		PostPage.clickPostDugme(dr);
	}

	// test sa svim podacima iz tabele
	public static void testExcelAllDataPost(WebDriver dr) throws Exception {
		ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData, Constant.SHEET_NAME1);
		for (int i=1; i < ExcelUtils.getWorkSheet().getLastRowNum() + 1; i++) {
		    fillForm(dr, i);
			PostPage.navigateTo(dr);
		}
	}

	/*public static void prevoz(WebDriver dr, int j) {
		switch (j) {
		case 1:
			System.out.println("Walk");
			break;
		case 2:
			System.out.println("Car");
			break;
		case 3:
			System.out.println("Motorbike");
			break;
		case 4:
			System.out.println("Bycicle");
			break;
		case 5:
			System.out.println("Bus");
			break;
		default:
			System.out.println("Izaberi prevozno sredstvo! ");
		}
	}
	*/
}