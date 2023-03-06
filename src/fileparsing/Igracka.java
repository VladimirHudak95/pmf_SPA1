package fileparsing;

public class Igracka {

	private String tip, boja;
	private double cena;
	
	public Igracka(String tip, String boja, double cena) {
		this.tip = tip;
		this.boja = boja;
		this.cena = cena;
	}
	
	
	public String getTip() {
		return this.tip;
	}
	
	public String getBoja() {
		return this.boja;
	}
	
	public double getCena() {
		return this.cena;
	}
	
	public void setTip(String tip) {
		this.tip = tip;
	}

	public void setBoja(String boja) {
		this.boja = boja;
	}
	
	public void setCena(double cena) {
		this.cena = cena;
	}
	
	@Override
	public String toString() {
		return tip + " Boja: " + boja + " Cena: " + cena + " RSD";
	}
	
	
}
