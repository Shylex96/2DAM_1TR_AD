package exercises;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Exercise02 {

	public static void main(String[] args) 
	{
		System.out.println("------------------------------- SEPARADOR -------------------------------\n");
		dir("C:\\Users\\Studium\\Desktop\\DAM\\AD\\AD_Topic1_Exercises1", "");
		System.out.println("------------------------------- SEPARADOR -------------------------------\n");
		dir("C:\\Users\\Studium\\Desktop\\DAM\\AD\\AD_Topic1_Exercises1", "b");
		System.out.println("------------------------------- SEPARADOR -------------------------------\n");
		dir("C:\\Users\\Studium\\Desktop\\DAM\\AD\\AD_Topic1_Exercises1", "d");
	}

	public static void dir(String pathname, String filter) {

		/*Instanciamos el objeto de tipo File*/
		File filePathname = new File(pathname);

		/*Con el objeto de tipo File llamamos al método listFiles()
		 * que nos devuelve un array de objetos de tipo File[]*/
		File[] files = null;

		if (filter != "") {
			files = filePathname.listFiles(new Filtro(filter));
		} else {
			files = filePathname.listFiles();
		}

		/*El método asList(files) devuelve una Lista de objetos File.*/
		/*El método asList(files) actúa como puente entre las API de Array y
			la API de Colecciones.*/
		List<File> listTotal = Arrays.asList(files);

		/*Instanciamos dos objetos de tipo List, es decir creamos dos listas,
			una para los ficheros y otra para los drectorios.*/
		List<File> listFiles = new ArrayList<File>();
		List<File> listDirectories = new ArrayList<File>();

		SimpleDateFormat sdf = new SimpleDateFormat("dd/M/yy HH:mm:ss");

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
			elemento y le anteponemos <DIR>, con una tabulación, para indicar que es un
			directorio.*/
		for (File element : listDirectories) {
			String name = element.getName();
			//System.out.print("<DIR>\t");
			String lastModified = sdf.format(element.lastModified());
			System.out.println(lastModified + "\t<DIR>\t" +name);

		}

		System.out.println("\n");

		/*Recorremos la lista de ficheros mostrando el nombre de cada
			elemento.*/
		for (File element : listFiles) {
			String name = element.getName();
			//System.out.print("\t");

			String lastModified = sdf.format(element.lastModified());
			System.out.println(lastModified + "\t<DIR>\t" +name);
		}

		System.out.println("\n");

		/*Mostramos el número de directorios y ficheros que hay en el
			directorio especificado. Para ello hemos utilizado el método size() de List. */
		System.out.println("Hay " + listFiles.size() + " archivos");
		System.out.println("Hay " + listDirectories.size() + " carpetas");
	}
}
