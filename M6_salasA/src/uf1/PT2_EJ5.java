package uf1;

import java.io.File;
import java.io.FileWriter;

public class PT2_EJ5 {

	public static void main(String[] args) {
		ejercicio();
	}

	public static void ejercicio() {
		File f = new File("..\\M6_salasA\\frasesMatrix.txt");
		FileWriter fw;

		try {
			fw = new FileWriter(f);
			if (!f.exists()) {
				f.createNewFile();
			}

			if (f.length() == 0) {
				fw.write("Yo solo puedo mostrarte la puerta, tú eres quien la tiene que atravesar.");
			}

			fw.close();
		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
