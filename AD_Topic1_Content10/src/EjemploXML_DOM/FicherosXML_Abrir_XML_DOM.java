package EjemploXML_DOM;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;

public class FicherosXML_Abrir_XML_DOM {

	public static void main(String[] args) {
		File f = new File("Libros.xml");
		abrir_XML_DOM(f);
		
		Fichero_RecoveryMostrar_DOM.recorrerDOMyMostrar(abrir_XML_DOM(f));
	}

	public static Document abrir_XML_DOM(File fichero) {
		/* Representa al árbol DOM */
		Document doc = null;
		try {
			/* Se crea un objeto DocumentBuilderFactory */
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			/* Ignoramos los comentarios del XML */
			factory.setIgnoringComments(true);
			/* Ignorar los espacios en blanco */
			factory.setIgnoringElementContentWhitespace(true);
			/* Se crea un objeto DocumentBuilder para cargar en él la estructura
		de árbol DOM a partir del XML seleccionado */
			DocumentBuilder builder = factory.newDocumentBuilder();
			/* Interpreta el XML y genera el DOM equivalente */
			doc = builder.parse(fichero);
			/* Ahora doc apunta al árbol DOM, listo para recorrer */
			System.out.println("Correctamente ejecutado.");

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		return doc;
	}
}
