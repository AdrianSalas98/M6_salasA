package uf2;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class ForHonor {

	static String URL = "jdbc:sqlite:..\\M6_salasA\\ForHonor.db";

	public static void main(String[] args) {
		
	}

	public static void crearBaseDatos() {

		try (Connection conn = DriverManager.getConnection(URL)) {
			if (conn != null) {
				DatabaseMetaData meta = conn.getMetaData();
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

	}

	public static void connectar() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(URL);

			System.out.println("Connection to SQLite has been established.");

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException ex) {
				System.out.println(ex.getMessage());
			}
		}
	}

	public static void crearFaccion() {
		String sql = "CREATE TABLE IF NOT EXISTS Faccion (\n" + "    faccion_id integer PRIMARY KEY,\n"
				+ "    nombre_faccion text(15) NOT NULL,\n" + "    lore text(200)\n" + ");";

		try (Connection conn = DriverManager.getConnection(URL); Statement stmt = conn.createStatement()) {
			stmt.execute(sql);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public static void crearPersonaje() {
		String sql = "CREATE TABLE IF NOT EXISTS Personaje (\n" + "    personaje_id integer PRIMARY KEY,\n"
				+ "    nombre_personaje text(15) NOT NULL,\n" + "    ataque integer\n" + "	defensa integer\n" + "faccion_id, FOREIGN KEY (faccion_id) REFERENCES Faccion(faccion_id)" + ");";

		try (Connection conn = DriverManager.getConnection(URL); Statement stmt = conn.createStatement()) {
			stmt.execute(sql);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}	}

}
