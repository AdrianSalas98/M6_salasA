package uf1;

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class PT2_EJ6 {

	public static void main(String[] args) {
		ejercicio();
	}

	public static void ejercicio() {
		File f = new File("..\\M6_salasA\\ficheroLineas.txt");
		Scanner s = null;
		FileWriter fw;
		int contador = 1;

		try {

			if (!f.exists()) {
				f.createNewFile();
			}

			s = new Scanner(f);
			fw = new FileWriter(f);

			while (contador <= 10) {
				fw.write("Linea" + contador + "\n");
				contador++;
			}

			fw.close();
			
			while (s.hasNextLine()) {
				String linea = s.next();
				System.out.println(linea);
			}

		} catch (Exception ex) {
			System.out.println("Mensaje: " + ex.getMessage());
		}
	}

}
