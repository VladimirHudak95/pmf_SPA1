package fileparsing;

import java.io.IOException;
import java.util.Scanner;

public class Studenti {

	public static void main(String[] args) {
		SpisakStudenata a = new SpisakStudenata();
		try {
			a.readFromFile("resources/studenti.txt");
			a.writeToFile("resources/studentiWrite.txt");
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		a.print();
		
		System.out.println();
		
		if(a.izbaciStudente("Anita", "Glisic")){
			System.out.println("Uspesno!");
		}else {
			System.out.println("Nema studenata sa tim imenom i prezimenom!");
		}
		
		System.out.println();
		
		a.print();
		
		System.out.println();
		Scanner s = new Scanner(System.in);
		System.out.println("Unesite godinu rodjenja studenata za ispis: ");
		int godina = s.nextInt();
		
		System.out.println("Studenti rodjeni " + godina + ". su:");
		System.out.println();
		
		a.stampajSaGodinom(godina);
		s.close();
		
		try {
			a.dodajUFajlAkoSeNeNalazi("Vladimir", "Hudak", 1995, "resources/studenti.txt");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
