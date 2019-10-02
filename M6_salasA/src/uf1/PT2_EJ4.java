package uf1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PT2_EJ4 {

	public static void main(String[] args) {
		ejercicio();
	}

	public static void ejercicio() {
		File f = new File("..\\M6_salasA\\ficherito.txt");
		Scanner lector;
		try {
			lector = new Scanner(f);
			if (f.isFile()) {
				while (lector.hasNextLine()) {
					String linea = lector.nextLine();
					System.out.println(linea);
				}
			} 
			
			if(f.isDirectory()) {
				System.out.println(f + " No es un fichero, es un directorio");
			}

		} catch (FileNotFoundException e) {
			System.out.println(e);
		}

	}

}
