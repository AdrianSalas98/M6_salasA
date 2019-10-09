package uf1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Scanner;

public class PT3 {

	public static void main(String[] args) {
		leerTeclado();
		System.out.println();
		listarFichero();
		System.out.println();
		backupFichero();
	}

	public static void leerTeclado() {
		Scanner lector = new Scanner(System.in);
		FileOutputStream fos = null;
		DataOutputStream dos = null;

		try {
			fos = new FileOutputStream("..\\M6_salasA\\becadades.dat");
			dos = new DataOutputStream(fos);

			System.out.println("Introduce el nombre completo del becario: ");
			String nCompleto = lector.nextLine();

			System.out.println("Introduce el sexo (H|M): ");
			char genero = lector.next().charAt(0);
			while (genero != 'H' && genero != 'M') {
				System.out.println("Introduce el genero correctamente...");
				genero = lector.next().charAt(0);
			}

			System.out.println("Introduce la edad (Entre 20 y 60): ");
			int edad = lector.nextInt();
			while (edad < 20 || edad > 60) {
				System.out.println("Introduce la edad correctamente...");
				edad = lector.nextInt();

			}

			System.out.println("Introduce numero de suspensos (Entre 0 y 4): ");
			int suspensos = lector.nextInt();
			while (suspensos < 0 || suspensos > 4) {
				System.out.println("Introduce los suspsensos correctamente...");
				suspensos = lector.nextInt();
			}

			System.out.println("Introduce residencia familiar (SI|NO): ");
			String rFamiliar = lector.nextLine();
			while (!rFamiliar.equalsIgnoreCase("SI") && !rFamiliar.equalsIgnoreCase("NO")) {
				rFamiliar = lector.nextLine();
			}

			System.out.println("Introduce los ingresos anuales: ");
			double ingresos = lector.nextDouble();

			dos.writeUTF(nCompleto);
			dos.writeChar(genero);
			dos.writeInt(edad);
			dos.writeInt(suspensos);
			dos.writeUTF(rFamiliar);
			dos.writeDouble(ingresos);

			fos.close();
			dos.close();
		} catch (Exception e) {
			
		}
	}

	public static void listarFichero() {
		FileInputStream fis = null;
		DataInputStream dis = null;

		try {
			fis = new FileInputStream("..\\M6_salasA\\becadades.dat");
			dis = new DataInputStream(fis);

			while (true) {
				String nombre = dis.readUTF();
				System.out.println(nombre);
				char genero = dis.readChar();
				System.out.println(genero);
				int edad = dis.readInt();
				System.out.println(edad);
				int suspensos = dis.readInt();
				System.out.println(suspensos);
				String residencia = dis.readUTF();
				System.out.println(residencia);
				double ingresos = dis.readDouble();
				System.out.println(ingresos);
			}

		} catch (Exception e) {

		} finally {
			try {
				if (fis != null) {
					fis.close();
				}

				if (dis != null) {
					dis.close();
				}
			} catch (Exception e2) {

			}
		}
	}

	public static void backupFichero() {
		FileInputStream fis = null;
		DataInputStream dis = null;
		FileOutputStream fos = null;
		DataOutputStream dos = null;

		try {
			fis = new FileInputStream("..\\M6_salasA\\becadades.dat");
			dis = new DataInputStream(fis);
			fos = new FileOutputStream("..\\M6_salasA\\becadadesBK.dat");
			dos = new DataOutputStream(fos);

			while (true) {
				String nombre = dis.readUTF();
				dos.writeUTF(nombre);
				char genero = dis.readChar();
				dos.writeChar(genero);
				int edad = dis.readInt();
				dos.writeInt(edad);
				int suspensos = dis.readInt();
				dos.writeInt(suspensos);
				String residencia = dis.readUTF();
				dos.writeUTF(residencia);
				double ingresos = dis.readDouble();
				dos.writeDouble(ingresos);

			}

		} catch (Exception e) {

		} finally {
			try {
				if (fis != null) {
					fis.close();
				}

				if (dis != null) {
					dis.close();
				}

				if (fos != null) {
					fos.close();
				}

				if (dos != null) {
					dos.close();
				}

				System.out.println("¡Backup Realizado con exito!");
			} catch (Exception e2) {

			}
		}

	}

}
