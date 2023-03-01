package fileparsing;

public class Radnik {

	private int id;
	private String ime, prezime;
	private int brojKancelarije;
	
	public Radnik(int id, String ime, String prezime, int brojKancelarije) {
		this.id = id;
		this.ime = ime;
		this.prezime = prezime;
		this.brojKancelarije = brojKancelarije;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getPrezime() {
		return prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public int getBrojKancelarije() {
		return brojKancelarije;
	}

	public void setBrojKancelarije(int brojKancelarije) {
		this.brojKancelarije = brojKancelarije;
	}
	
	@Override
	public String toString() {
		String rez = prezime + " " + ime + " radi u kancelariji broj: " + brojKancelarije;
		rez = String.format("%-60s", rez);
		return rez;
	}
	
}
