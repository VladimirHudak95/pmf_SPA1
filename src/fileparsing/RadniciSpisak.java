package fileparsing;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class RadniciSpisak {
	
	private static final int MAX_RADNIKA = 100;
	private static Radnik[] radnici = null;
	private static int brojac;
	
	public RadniciSpisak() {
	}
	
	public static Radnik[] citajIzFajla(String nazivFajla) throws IOException {
		
		radnici = new Radnik[MAX_RADNIKA];
		brojac = 0;
		
		BufferedReader in = Files.newBufferedReader(Paths.get(nazivFajla));
		String line = null;
		while((line = in.readLine()) != null && brojac < MAX_RADNIKA) {
			String[] tokens = line.split(" ");
			String id = tokens[0];
			String ime = tokens[1];
			String prezime = tokens[2];
			String brK = tokens[3];
			
			int idR = Integer.parseInt(id);
			int brKancelarije = Integer.parseInt(brK);
			
			Radnik r = new Radnik(idR, ime, prezime, brKancelarije);
			radnici[brojac] = r;
			brojac++;
			
		}
		
		if(line != null) {
			System.out.println("Nema vise mesta! Nije bilo moguce ucitati sve radnike!");
		}else {
			System.out.println("Svi radnici su uspesno ucitani!");
		}
		
		in.close();
		
		return radnici;
	}
	
	public static void stampajRadnike() {
		for(int i = 0; i < brojac; i++) {
			System.out.println(radnici[i]);
		}
	}
	
	public static void ispisiRadnike(String imeFajla) throws IOException {
		BufferedWriter out = Files.newBufferedWriter(Paths.get(imeFajla));
		for(int i = 0; i < brojac; i++) {
			out.write(radnici[i].toString() + "\n");
		}
		out.close();
	}
	
}
