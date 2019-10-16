package uf1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

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

public class PT5 {

	public static void main(String[] args) {
		System.out.println("hola");
		parte1();
		parte2();
		parte3();
	}

	public static void parte1() {
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;

		Persona p1 = new Persona("Maria", "Lopez", 36);
		Persona p2 = new Persona("Gustavo", "Gomez", 1);
		Persona p3 = new Persona("Irene", "Salas", 36);
		Persona p4 = new Persona("Roberto", "Morgade", 63);
		Persona p5 = new Persona("Graciela", "Iglesias", 60);
		try {
			fos = new FileOutputStream("..\\M6_salasA\\myPeople.dat");
			oos = new ObjectOutputStream(fos);

			oos.writeObject(p1);
			oos.writeObject(p2);
			oos.writeObject(p3);
			oos.writeObject(p4);
			oos.writeObject(p5);

		} catch (Exception e) {

		} finally {
			try {
				if (fos != null) {
					fos.close();
				}

				if (oos != null) {
					oos.close();
				}

				System.out.println("Las personas han sido agregadas al fichero con exito.");
			} catch (Exception e2) {

			}
		}

	}

	public static void parte2() {
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		Persona p1;

		try {
			DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();
			Document document = documentBuilder.newDocument();
			Element root = document.createElement("personas");
			document.appendChild(root);

			try {
				fis = new FileInputStream("..\\M6_salasA\\myPeople.dat");
				ois = new ObjectInputStream(fis);
				while (true) {
					Element persona = document.createElement("persona");
					root.appendChild(persona);
					Element nombre = document.createElement("nombre");
					root.appendChild(nombre);
					Element apellidos = document.createElement("apellidos");
					root.appendChild(apellidos);
					Element edad = document.createElement("edad");
					root.appendChild(edad);

					p1 = (Persona) ois.readObject();
					String nm = p1.getNombre();
					String ap = p1.getApellidos();
					String ed = String.valueOf(p1.getEdad());
					nombre.setTextContent(nm);
					apellidos.setTextContent(ap);
					edad.setTextContent(ed);

				}
			} catch (Exception e) {
				
			}

			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(document);
			StreamResult result = new StreamResult(new File("..\\M6_salasA\\myPeople.xml"));

			transformer.transform(source, result);

			fis.close();
			ois.close();
		} catch (Exception e) {
			
		}

	}

	public static void parte3() {
		File file = new File("..\\M6_salasA\\myPeople.xml");

		try {
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(file);
			NodeList nList = doc.getElementsByTagName("personas");
			for (int i = 0; i < nList.getLength(); i++) {
				Node node = nList.item(i);

				if (node.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) node;

					if (eElement.hasChildNodes()) {
						NodeList nl = node.getChildNodes();
						for (int j = 0; j < nl.getLength(); j++) {
							Node nd = nl.item(j);
							System.out.println(nd.getTextContent());
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
