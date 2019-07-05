package page.tests;

import java.util.Scanner;

import org.openqa.selenium.WebDriver;

import page.objects.RegistrationPage;
import utility.Constant;
import utility.ExcelUtils;
public class RegistrationPageTest {

	    // registracija korisnika preko skenera
	    public static void fillFormUser(WebDriver dr) throws InterruptedException {
		Scanner sc = new Scanner(System.in);
		// unos imena preko skenera
		System.out.println("Unesi FirstName :");
		String FirstName = sc.nextLine();
		RegistrationPage.clickFirstName(dr);
		RegistrationPage.sendKeysFirstName(dr, FirstName);

		// unos prezimena
		System.out.println("Unesi LastName :");
		String LastName = sc.nextLine();
		RegistrationPage.clickLastName(dr);
		RegistrationPage.sendKeysLastName(dr, LastName);

		// username
		System.out.println("Unesi username :");
		String Username = sc.nextLine();
		RegistrationPage.clickUsername(dr);
		RegistrationPage.sendKeysUsername(dr, Username);

		// email
		System.out.println("Unesi email :");
		String Email = sc.nextLine();
		RegistrationPage.clickEmail(dr);
		RegistrationPage.sendKeysEmail(dr, Email);

		// password
		System.out.println("Unesi password :");
		String Password = sc.nextLine();
		RegistrationPage.clickPassword(dr);
		RegistrationPage.sendKeysPassword(dr, Password);

		// registracija
		RegistrationPage.clickRegisterDugme(dr);
	}

	// popunjavanje registracije iz Excela
	public static void fillFormExcel(WebDriver dr, int i) throws Exception {
		String data;
		ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData, Constant.SHEET_NAME);
		RegistrationPage.clickFirstName(dr);
		data = ExcelUtils.getCellData(i, 0);
		RegistrationPage.sendKeysFirstName(dr, data);

		RegistrationPage.clickLastName(dr);
		data = ExcelUtils.getCellData(i, 1);
		RegistrationPage.sendKeysLastName(dr, data);

		RegistrationPage.clickUsername(dr);
		data = ExcelUtils.getCellData(i, 2);
		RegistrationPage.sendKeysUsername(dr, data);

		RegistrationPage.clickEmail(dr);
		data = ExcelUtils.getCellData(i, 3);
		RegistrationPage.sendKeysEmail(dr, data);

		RegistrationPage.clickPassword(dr);
		data = ExcelUtils.getCellData(i, 4);
		RegistrationPage.sendKeysPassword(dr, data);

		RegistrationPage.clickRegisterDugme(dr);
	}

	// test sa svim podacima iz tabele, sheet registracija
	public static void testExcelAllData(WebDriver dr) throws Exception {
		ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData, Constant.SHEET_NAME);
		for (int i = 0; i < ExcelUtils.getWorkSheet().getLastRowNum() + 1; i++) {
			fillFormExcel(dr, i);
			RegistrationPage.navigateTo(dr);
		}

	}

}
