package ptRepaso;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Main {

	public static void main(String[] args) {
		almacenarPersonas();
		generarXML();
		leerXML();
	}

	public static void almacenarPersonas() {
		Scanner lector = new Scanner(System.in);
		Scanner lectorInt = new Scanner(System.in);
		FileOutputStream fos = null;
		ObjectOutputStream dos = null;
		boolean salir = false;

		try {

			fos = new FileOutputStream("..\\M6_salasA\\FichPersona.dat");
			dos = new ObjectOutputStream(fos);

			while (!salir) {
				System.out.println("¿Quieres introducir una persona en el fichero? (SI|NO)");
				String opcion = lector.nextLine();
				if (opcion.equalsIgnoreCase("si")) {
					System.out.println("Introduce el nombre de la persona: ");
					String nombre = lector.nextLine();
					System.out.println("Introduce la edad de la persona: ");
					int edad = lectorInt.nextInt();
					PersonaRepaso p1 = new PersonaRepaso(nombre, edad);
					dos.writeObject(p1);
				}

				if (opcion.equalsIgnoreCase("no")) {
					salir = true;
				}

			}

			fos.close();
			dos.close();

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public static void generarXML() {
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		PersonaRepaso p1;

		try {
			DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();
			Document document = documentBuilder.newDocument();
			Element root = document.createElement("personas");
			document.appendChild(root);

			try {
				fis = new FileInputStream("..\\M6_salasA\\FichPersona.dat");
				ois = new ObjectInputStream(fis);
				while (true) {
					p1 = (PersonaRepaso) ois.readObject();
					Element persona = document.createElement("persona");
					root.appendChild(persona);
					Element nombre = document.createElement("nombre");
					persona.appendChild(nombre);
					Element edad = document.createElement("edad");
					persona.appendChild(edad);

					String nm = p1.getNombre();
					String ed = String.valueOf(p1.getEdad());
					nombre.setTextContent(nm);
					edad.setTextContent(ed);

				}
			} catch (Exception e) {

			}

			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(document);
			StreamResult result = new StreamResult(new File("..\\M6_salasA\\PersonasRepaso.xml"));

			transformer.transform(source, result);

			fis.close();
			ois.close();
		} catch (Exception e) {

		}

	}

	public static void leerXML() {
		File file = new File("..\\M6_salasA\\PersonasRepaso.xml");

		try {
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(file);
			NodeList nList = doc.getElementsByTagName("persona");
			for (int i = 0; i < nList.getLength(); i++) {
				Node node = nList.item(i);

				if (node.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) node;

					if (eElement.hasChildNodes()) {
						NodeList nl = node.getChildNodes();
						for (int j = 0; j < nl.getLength(); j++) {
							Node nd = nl.item(j);
							System.out.print(nd.getTextContent() + " ");
						}
						System.out.println();
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
