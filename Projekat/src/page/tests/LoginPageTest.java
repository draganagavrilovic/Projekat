package page.tests;
import java.util.Scanner;
import org.openqa.selenium.WebDriver;
import page.objects.LoginPage;
import utility.Constant;
import utility.ExcelUtils;

public class LoginPageTest {

	// test sa jednim podatkom koji unosimo sami
	public static void testWithOneData(WebDriver dr) throws Exception {

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Username");
		String username = sc.nextLine();
		LoginPage.sendKeysUsernameLog(dr, username);

		System.out.println("Enter Password");
		String password = sc.nextLine();
		LoginPage.sendKeysPasswordLog(dr, password);

		LoginPage.clickLogin(dr);
	}

	// popunjavanje iz Excela(redovi i kolone)
	public static void fillForm(WebDriver dr, int i) throws Exception {
		String data;
		ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData, Constant.SHEET_NAME);
		LoginPage.clickUsernameLog(dr);
		data = ExcelUtils.getCellData(i, 2);
		LoginPage.sendKeysUsernameLog(dr, data);

		LoginPage.clickPasswordLog(dr);
		data = ExcelUtils.getCellData(i, 4);
		LoginPage.sendKeysPasswordLog(dr, data);

		LoginPage.clickLogin(dr);
	}

		// test sa svim podacima iz tabele
		public static void testExcelAllDataLog(WebDriver dr) throws Exception {
		ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData, Constant.SHEET_NAME);
		for (int i = 0; i < ExcelUtils.getWorkSheet().getLastRowNum() + 1; i++) {
			fillForm(dr, i);
			LoginPage.navigateTo(dr);

		}
	}

}