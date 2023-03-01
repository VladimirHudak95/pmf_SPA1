package fileparsing;

import java.io.IOException;

public class Radnici {

	public static void main(String[] args) {
		
		try {
			RadniciSpisak.citajIzFajla("resources/radnici.txt");
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		RadniciSpisak.stampajRadnike();
		
		try {
			RadniciSpisak.ispisiRadnike("resources/radniciIspis.txt");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}

}
