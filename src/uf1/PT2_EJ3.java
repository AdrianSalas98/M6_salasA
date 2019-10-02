package uf1;

import java.io.File;

public class PT2_EJ3 {

	public static void main(String[] args) {
		ejercicio();

	}

	//Metodo para crear dos ficheros, renombrar el fichero2 por otro nombre para comprobar
	//que realmente esta renombrado, listamos los ficheros, borramos el primer fichero
	//y por ultimo volvemos a mostrar los ficheros para ver que todo funciona correctamente
	public static void ejercicio() {
		File directorio = new File("myFiles");
		directorio.mkdir();

		File f1;
		File f2;
		File f3 = new File("..\\M6_salasA\\myFiles\\ficheroRenombrado");

		try {
			f1 = new File("..\\M6_salasA\\myFiles\\fichero1");
			f2 = new File("..\\M6_salasA\\myFiles\\fichero2");

			if (!f1.exists()) {
				f1.createNewFile();
			}

			if (!f2.exists()) {
				f2.createNewFile();
			}

			f2.renameTo(f3);

			File[] ficheros = directorio.listFiles();
			for (int x = 0; x < ficheros.length; x++) {
				System.out.println(ficheros[x].getName());
			}

			f1.delete();

			System.out.println();

			File[] ficheros2 = directorio.listFiles();
			for (int y = 0; y < ficheros2.length; y++) {
				System.out.println(ficheros2[y].getName());
			}

		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
