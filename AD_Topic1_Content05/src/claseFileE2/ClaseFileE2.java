package claseFileE2;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ClaseFileE2 {

	public static void dir(String pathname) {
		
		/*Instanciamos el objeto de tipo File*/
		File filePathname = new File(pathname);
		
		/*Con el objeto de tipo File llamamos al método listFiles() que nos
		devuelve un array de objetos de tipo File[]*/
		File[] files = filePathname.listFiles();
		
		/*El método asList(files) devuelve una Lista de objetos File.*/
		/*El método asList(files) actúa como puente entre las API de Array y
		la API de Colecciones.*/
		List<File> listTotal = Arrays.asList(files);
		
		/*Instanciamos dos objetos de tipo List, es decir creamos dos listas,
		una para los ficheros y otra para los directorios.*/
		List<File> listFiles = new ArrayList<File>();
		List<File> listDirectories = new ArrayList<File>();
		
		/*Recorremos la lista total y diferenciamos si es un fichero o un
		direcorio y lo añadimos a la lista correspondiente en cada caso.*/
		for (File element : listTotal) {
			if (element.isDirectory()) {
				listDirectories.add(element);
			} else {
				listFiles.add(element);
			}
		}
		
		/*Mostramos la ruta absoluta.*/
		System.out.println("Contenido de la carpeta " + filePathname.getAbsolutePath() + "\n");
		
		/*Recorremos la lista de directorios mostrando el nombre de cada
		elemento y le anteponemos <DIR> para indicar que es un directorio.*/
		for (File element : listDirectories) {
			String name = element.getName();
			System.out.print("<DIR>\t");
			System.out.println(name);
		}
		/*Recorremos la lista de ficheros mostrando el nombre de cada elemento.*/
		for (File element : listFiles) {
			String name = element.getName();
			//Introduce una tabulación al mostrar el nombre del fichero.
			System.out.print("\t");
			System.out.println(name);
		}
	}

	public static void main(String[] args) {
		dir("C:\\Users\\Studium\\Desktop\\DAM\\AD");
	}
}

