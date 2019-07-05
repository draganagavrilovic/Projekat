package page.tests;
import java.util.Scanner;

import org.openqa.selenium.WebDriver;

import page.objects.DasboardPage;

public class DashboardPageTest {

	//
	public static void LogOut (WebDriver dr) {
		DasboardPage.clickLogout(dr);
	}
	//editovanje posta preko skenera
	public static void editPostUser(WebDriver dr, int i) throws InterruptedException {
	//izmeni naziv
	Scanner sc = new Scanner(System.in);
	DasboardPage.nadjiPost(dr,1);
	DasboardPage.clickMyFunction(dr,1);
	DasboardPage.Edit(dr, i);
	System.out.println("Izmeni naziv :");
	String naziv=sc.nextLine();  
	DasboardPage.clickEditNaziv(dr);
	DasboardPage.sendKeysNaziv(dr, naziv);
	
	// izmeni lokaciju
	System.out.println("Izmeni Lokaciju");
	String Lokacija = sc.nextLine();
	DasboardPage.clickEditLokacija(dr);
	DasboardPage.sendKeysEditLokacija(dr, Lokacija);
	
	//slika
	//PostPage.sendKeysBROWSE(dr, str);
	
	//izbor prevoza
	System.out.println("Izaberi prevozno sredstvo");
	String prevoz = sc.nextLine();
	DasboardPage.clickEditPrevoz(dr);
	DasboardPage.sendKeysEditPrevoz(dr, prevoz);
	
	// opis posta
	System.out.println("Izmeni Opis");
	String Opis = sc.nextLine();
	DasboardPage.clickEditOpis(dr);
	DasboardPage.sendKeysEditOpis(dr, Opis);

	DasboardPage.clickPostDugme(dr);
	}

	//delete post
	public static void deletePost (WebDriver dr, int i) throws InterruptedException {
		DasboardPage.clickMyFunction(dr, i);
		DasboardPage.clicDelete(dr, i);
		if(dr.getCurrentUrl().equals(DasboardPage.DASHBOARDPAGE_URL)) {
			System.out.println("Post je izbrisan!");
		}else {
			System.out.println("Post nije izbrisan!");
		}
		Thread.sleep(5000);
	}
}