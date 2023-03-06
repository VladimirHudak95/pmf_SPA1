package fileparsing;

import java.io.IOException;
import java.util.Scanner;

public class Igracke {

	public static void main(String[] args) {
		
		SpisakIgracaka spisak = new SpisakIgracaka();
		Scanner in = new Scanner(System.in);
		System.out.println("Unesite naziv fajla za ucitavanje igracaka: ");
		String nazivFajla = in.next();
		
		try {
			spisak.readFromFile(nazivFajla);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		spisak.print();
		
		System.out.println();
		
		spisak.addIgracka("vojnik" , "zeleno", 350.00);
		
		try {
			spisak.writeToFile("resources/igrackeNove.txt");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Igracke sa zelenom bojom: ");
		spisak.printToysOfGivenColor("zeleno");
		
		System.out.println();
		System.out.println("Broj igracaka skupljih od 450.00 RSD je: " + spisak.countToysWithPriceHigherThan(450.00));
		
	}

}
