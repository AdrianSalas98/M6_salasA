package uf1;

import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeMap;

public class PT1 {

	static TreeMap<String, Float> juegos = new TreeMap<String, Float>();

	public static void main(String[] args) {
		menu();

	}

	//Metodo para comprobar si un string es numerico
	public static boolean isNumeric(String cadena) {

		boolean resultado;

		try {
			Integer.parseInt(cadena);
			resultado = true;
		} catch (NumberFormatException excepcion) {
			resultado = false;
		}

		return resultado;
	}

	//Metodo para iniciar el menu en bucle, hasta que el usuario decida salir con la tecla 5
	//En cada opcion del switch estan los metodos que realizan los ejercicios
	public static void menu() {
		Scanner sn = new Scanner(System.in);
		boolean salir = false;
		int opcion;

		while (!salir) {
			System.out.println();
			System.out.println("1. Insertar Juego");
			System.out.println("2. Modificar Precio");
			System.out.println("3. Eliminar Juego");
			System.out.println("4. Mostrar Productos Ordenadamente");
			System.out.println("5. Salir");
			System.out.println();

			try {

				System.out.println("Escribe una de las opciones");
				opcion = sn.nextInt();

				switch (opcion) {
				case 1:
					insertarJuego();
					break;
				case 2:
					modificarPrecio();
					break;
				case 3:
					eliminarJuego();
					break;
				case 4:
					listarJuegos();
					break;
				case 5:
					salir = true;
					break;
				default:
					System.out.println("Opciones validas entre 1 y 5");
				}
			} catch (InputMismatchException e) {
				System.out.println("Debes insertar un número");
				sn.next();
			}

		}

	}

	//Metodo para insertar un juego, realizando diferentes comprobaciones para evitar errores
	//Si todas las comprobaciones pasan, se insertara un juego en el TreeMap
	public static void insertarJuego() {
		Scanner lector = new Scanner(System.in);
		boolean juegoValido = false;
		String nJuego = "";

		while (!juegoValido) {
			System.out.println("Introduce el nombre de un juego: ");
			nJuego = lector.nextLine();
			if (isNumeric(nJuego) == true) {
				System.out.println("Introduce un juego valido.");
			} else {
				juegoValido = true;
			}
		}

		System.out.println("Introduce el precio del juego: ");
		float pJuego = lector.nextFloat();

		juegos.put(nJuego, pJuego);

	}

	//Metodo para listar todos los juegos del TreeMap, para ello usamos un iterator y un bucle
	//para poder recorrer el TreeMap y printar por consola los juegos
	public static void listarJuegos() {
		String clave;
		float valor;

		Iterator<String> listaJuegos = juegos.keySet().iterator();

		if (juegos.size() > 0) {
			while (listaJuegos.hasNext()) {
				clave = listaJuegos.next();
				valor = juegos.get(clave);
				System.out.println(clave + " | " + valor);
			}
		}
	}

	//Metodo para modificar precio, recorremos el TreeMap, buscamos la coincidencia
	//del nombre que ha puesto el usuario y el nombre de los juegos que hay dentro
	//Si alguno coincide preguntamos un nuevo precio y lo insertamos
	public static void modificarPrecio() {
		String clave;
		float valor;
		Scanner lector = new Scanner(System.in);

		System.out.println("Introduce el nombre del VideoJuego a modificar: ");
		String nJuego = lector.nextLine();
		Iterator<String> listaJuegos = juegos.keySet().iterator();

		if (juegos.size() > 0) {
			while (listaJuegos.hasNext()) {
				clave = listaJuegos.next();
				if (clave.equalsIgnoreCase(nJuego)) {
					System.out.println("Introduce un nuevo Precio: ");
					float pJuego = lector.nextFloat();
					valor = pJuego;
					juegos.put(nJuego, pJuego);
				} else {
					valor = juegos.get(clave);
				}

			}
		}
	}

	//Metodo para eliminar juego, recorremos el TreeMap buscando la coincidencia con el nombre
	//que ha puesto el usuario con los nombres de los juegos del TreeMap
	//Si hay coincidencia eliminamos el juego
	public static void eliminarJuego() {
		String clave;
		float valor;
		Scanner lector = new Scanner(System.in);

		System.out.println("Introduce el nombre del VideoJuego a borrar: ");
		String nJuego = lector.nextLine();
		Iterator<String> listaJuegos = juegos.keySet().iterator();

		if (juegos.size() > 0) {
			while (listaJuegos.hasNext()) {
				clave = listaJuegos.next();
				valor = juegos.get(clave);
				if (clave.equalsIgnoreCase(nJuego)) {

					juegos.remove(clave, valor);

				}

			}
		}
	}

}
