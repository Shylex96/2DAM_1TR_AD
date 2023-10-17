package claseFileE2Stream;

import java.io.File;
import java.util.Arrays;

public class ClaseFileE2Stream {

	public static void main(String[] args)
	{
		dir("C:\\Users\\Studium\\Desktop\\DAM\\AD\\AD_Topic1_Content7");
	}

	public static void dir(String pathname) {
		
		/* Instanciamos el objeto de tipo File*/
		File filePathname = new File(pathname);
		File[] files = filePathname.listFiles();
		
		//File[] files = (new File(pathname)).listFiles();
		
		/*Mostramos el contenido de la carpeta*/
		System.out.println("Contenido de la carpeta " + pathname + "\n");
		
		/*Mostramos la ruta absoluta y para ello necesitamos el objeto de
		tipo File con el que llamamos al método ilePathname.getAbsolutePath().*/
		System.out.println("Ruta absoluta " + filePathname.getAbsolutePath() + "\n");
		
		/*En este ejercicio, utilizamos el método stream() de la clase Arrays
		para obtener los objetos de tipo Stream y poder utilizar sus métodos filter y
		forEach.*/
		Arrays.stream(files).filter(file -> file.isDirectory()).forEach(file ->
		System.out.println("<DIR>\t" + file.getName()));
		
		Arrays.stream(files).filter(file -> file.isFile()).forEach(file ->
		System.out.println("\t" + file.getName()));
	}
}