package uf1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class PT2_EJ7 {

	public static void main(String[] args) {
		ejercicio();
	}
	
	//Metodo para copiar un fichero de la ruta origen a la ruta destino
	//El usuario introduce una ruta valida, nos guardamos la ruta en un file
	//El usuario nos introduce la ruta destino, tambien nos la guardamos
	//Despues escribimos el contenido de el archivo origen en el archivo destino
	public static void ejercicio() {
		System.out.println("Introduce ruta fichero: ");
		Scanner lector = new Scanner(System.in);
		String ruta = lector.nextLine();
		File f = new File(ruta);
		Scanner s = null;
		FileWriter fichero = null;
		if (f.isFile()) {
			System.out.println("Introduce ruta destino: ");
			String ruta2 = lector.nextLine();
			File f2 = new File(ruta2);
			if (f2.isDirectory()) {
				ruta2 = ruta2 + "\\" + f.getName();
				f2 = new File(ruta2);
				try {
					s = new Scanner(f);
					fichero = new FileWriter(f2);
					while (s.hasNextLine()) {
						String linea = s.nextLine();
						fichero.write(linea + "\n");
					}
					f.delete();
					fichero.close();
				} catch (FileNotFoundException e) {
					System.out.println(e);
				} catch (IOException e) {
					System.out.println(e);
				}
			} else {
				System.out.println("Es un fichero");
			}
		} else {
			System.out.println("Es un directorio");
		}
	}

}
