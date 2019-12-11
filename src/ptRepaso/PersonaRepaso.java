package ptRepaso;

import java.io.Serializable;

public class PersonaRepaso implements Serializable {
	private String nombre;
	private int edad;

	public PersonaRepaso(String nombre, int edad) {
		this.nombre = nombre;
		this.edad = edad;
	}

	public PersonaRepaso() {
		this.nombre = null;
	}

	public void setNombre(String nom) {
		nombre = nom;
	}

	public void setEdad(int ed) {
		edad = ed;
	}

	public String getNombre() {
		return nombre;
	}

	public int getEdad() {
		return edad;
	}
}