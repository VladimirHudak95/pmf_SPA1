package fileparsing;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class SpisakStudenata implements IOFile<Student>{

	private static final int MAX_STUDENATA = 100;
	private static Student[] listaStudenata;
	private static int brojac;

	@Override
	public Student[] readFromFile(String fileName) throws IOException {
		BufferedReader in;
		String line;

		in = Files.newBufferedReader(Paths.get(fileName));

		listaStudenata = new Student[MAX_STUDENATA];
		brojac = 0;

		while ((line = in.readLine()) != null && brojac < MAX_STUDENATA) {
			String[] tokens = line.split(" ");
			String prezime = tokens[0];
			String ime = tokens[1];
			String godina = tokens[2];

			int godinaR = Integer.parseInt(godina);

			Student s = new Student(prezime, ime, godinaR);
			listaStudenata[brojac] = s;

			brojac++;
		}

		if (line != null) {
			System.out.println("Nema vise mesta! Nije bilo moguce ucitati sve radnike!");
		} else {
			System.out.println("Svi radnici su uspesno ucitani!");
		}

		in.close();

		return listaStudenata;
	}

	@Override
	public void writeToFile(String fileName) throws IOException {
		BufferedWriter out = Files.newBufferedWriter(Paths.get(fileName));
		for(int i = 0; i < brojac; i++) {
			out.write(listaStudenata[i].toString() + "\n");
		}
		out.close();
	}

	@Override
	public void print() {
		for(int i = 0; i < brojac; i++) {
			System.out.println(listaStudenata[i]);
		}

	}
	
	public boolean izbaciStudente(String ime, String prezime) {
		boolean success = false;
		int brojIzbacenih = 0;
		
		for(int i = 0; i < brojac; i++) {
			if(listaStudenata[i].getFirstName().equalsIgnoreCase(ime) && listaStudenata[i].getLastName().equalsIgnoreCase(prezime)) {
				for(int j = i; j < brojac - 1; j++) {
					listaStudenata[j] = listaStudenata[j + 1];
				}
				listaStudenata[brojac] = null;
				brojIzbacenih++;
				brojac--;
				success = true;
			}
		}
		System.out.println("Uspesno izbacen/o " + brojIzbacenih + " student/studenata!");
		return success;
	}
	
	public void stampajSaGodinom(int godina) {
		
		for(int i = 0; i < brojac; i++) {
			if(listaStudenata[i].getYearOfBirth() == godina) {
				System.out.println(listaStudenata[i]);
			}
		}
		
	}
	public boolean seNalazi(String ime, String prezime, int god) {
		
		for(int i = 0; i < brojac; i++) {
			if(listaStudenata[i].getFirstName().equals(ime) && listaStudenata[i].getLastName().equals(prezime)) {
				return true;
			}
		}
		
		return false;
		
	}
	
	public void dodajUFajlAkoSeNeNalazi(String ime, String prezime, int god, String fileName) throws IOException {
		if(seNalazi(ime, prezime, god)) {
			System.out.println("Nalazi se u fajlu!");
		}
		else {
			Path p = Paths.get(fileName);
			BufferedWriter out = Files.newBufferedWriter(p, StandardOpenOption.APPEND);
			out.write(ime + " " + prezime + " " + god + "\n");
			out.close();
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}
