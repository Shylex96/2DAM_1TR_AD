package nio2.path;

import java.nio.file.Path;
import java.nio.file.Paths;

public class EjemploNIO2Path {
	
	public static void main(String[] args) {
		
		/*Obtenemos la ruta relativa.*/
		Path relativa = Paths.get("..\\ADT1_NIO.2_Path");
		
		/*Obtenemos la ruta absoluta, de la ruta relativa y
		 * eliminamos los elementos de nombre redundantes.
		 * Ej.: C:\Users\W10\María José\María José\Grupo Studium DAM*/
		Path absoluta = relativa.toAbsolutePath().normalize();
		
		/*Mostramos por consola la ruta relativa.*/
		System.out.println("Ruta relativa: " + relativa);
		
		/*Mostramos por consola la ruta absoluta.*/
		System.out.println("Ruta absoluta: " + absoluta);
		
		/*Indicamos el número de elementos, nombres, que tiene la ruta
		absoluta.*/
		System.out.println("Número de elementos nombre, en la ruta absoluta: " + absoluta.getNameCount());
		
		/*Mostramos la ruta padre.*/
		System.out.println("Ruta padre: " + absoluta.getParent());
		
		/*Mostramos una subruta de la ruta absoluta.*/
		/*La carpeta 0 de la ruta absoluta, es la carpeta que tenemos más
		próxima
		 * a la unidad de disco duro del ordenador, que es Users en nuestro
		ejemplo.
		 * El método subpath(0, 2) toma como subruta las carpetas de
		posición
		 * 0 y la de posición 2-1.
		 * El método subpath(4, 6) sacará como subruta las carpetas de
		posición
		 * 4 y 6-1*/
		System.out.println("Sub ruta(0, 2): " + absoluta.subpath(0, 2));
		System.out.println("Sub ruta(4, 6): " + absoluta.subpath(4, 6));
	}
}

