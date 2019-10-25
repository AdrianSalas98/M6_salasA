package uf1;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.io.File;
import java.util.InputMismatchException;
import java.util.Scanner;

public class PT5_2 {

	public static void main(String argv[]) {
		generarXML();
		menu();

	}

	public static void generarXML() {
		try {
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.newDocument();

			Element departamento = doc.createElement("Cursos");
			doc.appendChild(departamento);

			Element curso = doc.createElement("Curso");
			Attr attrCurso = doc.createAttribute("id");
			attrCurso.setValue("AMS2");
			curso.setAttributeNode(attrCurso);
			departamento.appendChild(curso);

			Element tutor = doc.createElement("Tutor");
			tutor.appendChild(doc.createTextNode("David Despeja"));
			curso.appendChild(tutor);

			Element alumnes = doc.createElement("Alumnes");
			curso.appendChild(alumnes);

			Element alumne1 = doc.createElement("Alumne");
			alumne1.appendChild(doc.createTextNode("Adrian Salas"));
			Element alumne2 = doc.createElement("Alumne");
			alumne2.appendChild(doc.createTextNode("David Uson"));
			Element alumne3 = doc.createElement("Alumne");
			alumne3.appendChild(doc.createTextNode("Marc Martinez"));
			Element alumne4 = doc.createElement("Alumne");
			alumne4.appendChild(doc.createTextNode("Darius Sobouti"));
			alumnes.appendChild(alumne1);
			alumnes.appendChild(alumne2);
			alumnes.appendChild(alumne3);
			alumnes.appendChild(alumne4);

			Element moduls = doc.createElement("Moduls");
			curso.appendChild(moduls);

			Element modul1 = doc.createElement("Modul");
			Attr attr = doc.createAttribute("id");
			attr.setValue("M06");
			modul1.setAttributeNode(attr);
			moduls.appendChild(modul1);

			Element titol = doc.createElement("Titol");
			titol.appendChild(doc.createTextNode("Acces a Dades"));
			modul1.appendChild(titol);

			Element profes = doc.createElement("Profes");
			modul1.appendChild(profes);

			Element profe1 = doc.createElement("Profe");
			profe1.appendChild(doc.createTextNode("Rafa Alcracil"));
			Element profe2 = doc.createElement("Profe");
			profe2.appendChild(doc.createTextNode("Enric Mieza"));
			profes.appendChild(profe1);
			profes.appendChild(profe2);

			Element ufs = doc.createElement("Ufs");
			modul1.appendChild(ufs);

			Element uf1 = doc.createElement("Uf");
			uf1.appendChild(doc.createTextNode("Persistencia en fitxers"));
			Attr attr1 = doc.createAttribute("n");
			attr1.setValue("1");
			uf1.setAttributeNode(attr1);
			ufs.appendChild(uf1);

			Element uf2 = doc.createElement("Uf");
			uf2.appendChild(doc.createTextNode("Persistencia en BDR-BDOR-BDOO"));
			Attr attr2 = doc.createAttribute("n");
			attr2.setValue("2");
			uf2.setAttributeNode(attr2);
			ufs.appendChild(uf2);

			Element uf3 = doc.createElement("Uf");
			uf3.appendChild(doc.createTextNode("Persistencia en BD natives XML"));
			Attr attr3 = doc.createAttribute("n");
			attr3.setValue("3");
			uf3.setAttributeNode(attr3);
			ufs.appendChild(uf3);

			Element uf4 = doc.createElement("Uf");
			uf4.appendChild(doc.createTextNode("Components d'acces a dades"));
			Attr attr4 = doc.createAttribute("n");
			attr4.setValue("4");
			uf4.setAttributeNode(attr4);
			ufs.appendChild(uf4);

			Element curso2 = doc.createElement("Curso");
			Attr attrCurso2 = doc.createAttribute("id");
			attrCurso2.setValue("AWS2");
			curso2.setAttributeNode(attrCurso2);
			departamento.appendChild(curso2);

			Element tutor2 = doc.createElement("Tutor");
			tutor2.appendChild(doc.createTextNode("Leandro Zabala"));
			curso2.appendChild(tutor2);

			Element alumnes2 = doc.createElement("Alumnes");
			curso2.appendChild(alumnes2);

			Element alumne11 = doc.createElement("Alumne");
			alumne11.appendChild(doc.createTextNode("Roger Carballo"));
			Element alumne22 = doc.createElement("Alumne");
			alumne22.appendChild(doc.createTextNode("Alexis Mengual"));
			Element alumne33 = doc.createElement("Alumne");
			alumne33.appendChild(doc.createTextNode("Adrian Nguema"));
			Element alumne44 = doc.createElement("Alumne");
			alumne44.appendChild(doc.createTextNode("Ali Murtaza"));
			alumnes2.appendChild(alumne11);
			alumnes2.appendChild(alumne22);
			alumnes2.appendChild(alumne33);
			alumnes2.appendChild(alumne44);

			Element moduls2 = doc.createElement("Moduls");
			curso2.appendChild(moduls2);

			Element modul11 = doc.createElement("Modul");
			Attr attr11 = doc.createAttribute("id");
			attr11.setValue("M01");
			modul11.setAttributeNode(attr11);
			moduls2.appendChild(modul11);

			Element titol2 = doc.createElement("Titol");
			titol2.appendChild(doc.createTextNode("Sistemes informatics"));
			modul11.appendChild(titol2);

			Element profes2 = doc.createElement("Profes");
			modul11.appendChild(profes2);

			Element profe11 = doc.createElement("Profe");
			profe11.appendChild(doc.createTextNode("Julian Fuentes"));
			Element profe22 = doc.createElement("Profe");
			profe22.appendChild(doc.createTextNode("Manu Mestre"));
			profes2.appendChild(profe11);
			profes2.appendChild(profe22);

			Element ufs2 = doc.createElement("Ufs");
			modul11.appendChild(ufs2);

			Element uf11 = doc.createElement("Uf");
			uf11.appendChild(doc.createTextNode("Instal.lacio, configuracio i explotacio d'un SI"));
			Attr attr111 = doc.createAttribute("n");
			attr111.setValue("1");
			uf11.setAttributeNode(attr111);
			ufs2.appendChild(uf11);

			Element uf22 = doc.createElement("Uf");
			uf22.appendChild(doc.createTextNode("Gestio de la informacio i de recursos en una xarxa"));
			Attr attr22 = doc.createAttribute("n");
			attr22.setValue("2");
			uf22.setAttributeNode(attr22);
			ufs2.appendChild(uf22);

			Element uf33 = doc.createElement("Uf");
			uf33.appendChild(doc.createTextNode("Implantacio de programari especific"));
			Attr attr33 = doc.createAttribute("n");
			attr33.setValue("3");
			uf33.setAttributeNode(attr33);
			ufs2.appendChild(uf33);

			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(new File("Instituto.xml"));
			transformer.transform(source, result);
			StreamResult consoleResult = new StreamResult(System.out);
			transformer.transform(source, consoleResult);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void menu() {
		Scanner sn = new Scanner(System.in);
		boolean salir = false;
		int opcion;

		while (!salir) {
			System.out.println();
			System.out.println("1. Insertar Alumno");
			System.out.println("2. Eliminar Alumno");
			System.out.println("3. Salir");
			System.out.println();

			try {
				System.out.println("Escribe una de las opciones");
				opcion = sn.nextInt();

				switch (opcion) {
				case 1:
					anadirAlumno();
					break;
				case 2:
					eliminarAlumno();
					break;
				case 3:
					salir = true;
					break;
				default:
					System.out.println("Opciones validas entre 1 y 3");
				}
			} catch (InputMismatchException e) {
				System.out.println("Debes insertar un número");
				sn.next();
			}

		}

	}

	public static void anadirAlumno() {
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse(new File("..\\M6_salasA\\Instituto.xml"));

			Scanner lector = new Scanner(System.in);

			NodeList curso = doc.getElementsByTagName("Curso");

			System.out.println("Introduce el curso del alumno: ");
			String nCurso = lector.nextLine();
			for (int i = 0; i < curso.getLength(); i++) {
				Element element = (Element) curso.item(i);
				NamedNodeMap nodeMap = element.getAttributes();
				for (int j = 0; j < nodeMap.getLength(); j++) {
					Node node = nodeMap.item(j);
					if (node.getNodeValue().equalsIgnoreCase(nCurso)) {
						NodeList nl = element.getChildNodes();
						for (int k = 0; k < nl.getLength(); k++) {
							Element element2 = (Element) nl.item(k);
							if (element2.getNodeName().equalsIgnoreCase("alumnes")) {
								NodeList nl2 = element2.getChildNodes();
								System.out.println("Introduce el nombre del alumno a anadir: ");
								String alumnoAnadir = lector.nextLine();
								Element alumnoNuevo = doc.createElement("alumne");
								alumnoNuevo.appendChild(doc.createTextNode(alumnoAnadir));
								element2.appendChild(alumnoNuevo);
								
							}
						}
					}
				}
			}

		} catch (Exception e) {

		}
	}

	public static void eliminarAlumno() {
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse(new File("..\\M6_salasA\\Instituto.xml"));
			Scanner lector = new Scanner(System.in);

			NodeList curso = doc.getElementsByTagName("Curso");

			System.out.println("Introduce el curso del alumno: ");
			String nCurso = lector.nextLine();
			for (int i = 0; i < curso.getLength(); i++) {
				Element element = (Element) curso.item(i);
				NamedNodeMap nodeMap = element.getAttributes();
				for (int j = 0; j < nodeMap.getLength(); j++) {
					Node node = nodeMap.item(j);
					if (node.getNodeValue().equalsIgnoreCase(nCurso)) {
						NodeList nl = element.getChildNodes();
						for (int k = 0; k < nl.getLength(); k++) {
							Element element2 = (Element) nl.item(k);
							if (element2.getNodeName().equalsIgnoreCase("alumnes")) {
								NodeList nl2 = element2.getChildNodes();
								System.out.println("Introduce el nombre del alumno a eliminar: ");
								String alumnoEliminar = lector.nextLine();
								for (int l = 0; l < nl2.getLength(); l++) {
									Element element3 = (Element) nl2.item(l);
									String nAlumno = element3.getTextContent();
									String[] separacion = nAlumno.split(" ");
									if (separacion[0].equalsIgnoreCase(alumnoEliminar)) {
										element3.getParentNode().removeChild(element3);
									}
								}
							}
						}
					}
				}
			}

		} catch (Exception e) {

		}
	}

}