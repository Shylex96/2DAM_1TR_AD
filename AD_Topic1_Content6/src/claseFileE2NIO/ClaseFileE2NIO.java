package claseFileE2NIO;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class ClaseFileE2NIO {
	
	public static void ejercicioFile2Nio(String pathname) throws IOException {
		
		/*Convertimos el String pasado como parámetro en un objeto Path*/
		Path path = Paths.get(pathname);
		
		/*Mostramos la ruta absoluta y eliminamos las redundancas.*/
		Path absoluta = path.toAbsolutePath().normalize();
		System.out.println("Ruta absoluta: " + absoluta);
		
		/*Creamos dos Stream uno con los ficheros y otro con los directorios.*/
		Stream<Path> directorios = Files.list(path).filter(file ->Files.isDirectory(file));
		Stream<Path> ficheros = Files.list(path).filter(file ->Files.isRegularFile(file));
		
		/*Mostramos primero los directorios y luego los ficheros.*/
		directorios.forEach(file -> {System.out.println("<DIR>\t" +
		file.getFileName());});
		ficheros.forEach(file ->System.out.println("\t" + file.getFileName()));
		}

	public static void main(String[] args) {
		
		try {
			ejercicioFile2Nio("C:\\Users\\Studium\\Desktop\\DAM\\AD");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
