package fileparsing;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class SpisakIgracaka implements IOFile<Igracka> {

	private static final int MAX_IGRACAKA = 100;
	private Igracka[] igracke;
	private int brIgracaka;
	
	public SpisakIgracaka() {
		this.igracke = new Igracka[MAX_IGRACAKA];
		this.brIgracaka = 0;
	}

	@Override
	public Igracka[] readFromFile(String fileName) throws IOException {

		if(fileName.length() < 2) {
			fileName = "resources/igracke50.txt";
		}
		String line;
		BufferedReader in = Files.newBufferedReader(Paths.get(fileName));
		
		while ((line = in.readLine()) != null && brIgracaka < MAX_IGRACAKA) {
			String[] tokens = line.split(" ");

			String tip = tokens[0];
			String boja = tokens[1];
			String cena = tokens[2];
			double dCena = Double.parseDouble(cena);

			addIgracka(tip, boja, dCena);
		}

		in.close();

		return igracke;
	}

	@Override
	public void writeToFile(String fileName) throws IOException {
			
		BufferedWriter out = Files.newBufferedWriter(Paths.get(fileName));
		for(int i = 0; i < brIgracaka; i++) {
			out.write(igracke[i].getTip() + " " + igracke[i].getBoja() + " " + igracke[i].getCena() + "\n");
		}
		out.close();
	}

	@Override
	public void print() {
		for(int i = 0; i < brIgracaka; i++)
			System.out.println(igracke[i]);
	}

	public void addIgracka(String tip, String boja, double cena) {
		if (brIgracaka >= MAX_IGRACAKA) {
			System.out.println("Nije moguce uneti vise igracaka!");
			return;
		}
		Igracka toy = new Igracka(tip, boja, cena);
		igracke[brIgracaka] = toy;
		brIgracaka++;
	}
	
	public void printToysOfGivenColor(String color) {
		for(int i = 0; i < brIgracaka; i++) {
			if(igracke[i].getBoja().equalsIgnoreCase(color)) {
				System.out.printf( "%-12s %2s %-6.2f %-3s %n",igracke[i].getTip(), " -> ", igracke[i].getCena(), "RSD");
			}
		}
	}
	
	public int countToysWithPriceHigherThan(double cena) {
		int count = 0;
		for(int i = 0; i < brIgracaka; i++) {
			if(igracke[i].getCena() > cena) {
				count++;
			}
		}
		return count;
	}
	
	
	
	
	
	
	

}
