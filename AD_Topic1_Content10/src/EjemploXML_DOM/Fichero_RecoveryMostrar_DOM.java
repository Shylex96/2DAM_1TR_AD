package EjemploXML_DOM;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Fichero_RecoveryMostrar_DOM {

	public static void recorrerDOMyMostrar(Document doc) {
		String datos_nodo[] = null;
		String salida = "";
		Node node;
		/* Obtiene el primer nodo del DOM (primer nodo) */
		Node raiz = doc.getFirstChild();
		/* Obtiene una lista de nodos con todos los nodos hijo */
		NodeList nodelist = raiz.getChildNodes();
		/* Procesa los nodos hijo */
		for (int i = 0; i < nodelist.getLength(); i++) {
			node = nodelist.item(i);
			/* Es un nodo Libro */
			if (node.getNodeType() == Node.ELEMENT_NODE) {
				/* Método que procesa el Nodo y extrae su información */
				datos_nodo = procesarLibro(node);
				salida += "\nPublicado en: " + datos_nodo[0];
				salida += "\nEl autor es: " + datos_nodo[2];
				salida += "\nEl título es: " + datos_nodo[1];
				salida += "\n ";
			}
		}
		System.out.println(salida);
	}

	protected static String[] procesarLibro(Node n) {
		String datos[] = new String[3];
		Node ntemp = null;
		int contador = 1;
		/* Obtiene el valor del primer atributo del nodo */
		datos[0] = n.getAttributes().item(0).getNodeValue();
		/* Obtiene los hijos del Libro (título y autor) */
		NodeList nodos = n.getChildNodes();
		for (int i = 0; i < nodos.getLength(); i++) {
			ntemp = nodos.item(i);
			if (ntemp.getNodeType() == Node.ELEMENT_NODE) {
				/* IMPORTANTE: para obtener el texto con el título y autor se accede
		al contenido TEXT del nodo */
				datos[contador] = ntemp.getTextContent();
				contador++;
			}
		}
		return datos;
	}
}
