package FileExampleHandler;

import java.io.File;
import java.io.IOException;

public class Example3 {

	public static void main(String[] args) {

			File f = new File("proyecto");
			f.mkdirs();

			File f2 = new File("proyecto\\libros.xml");

			try {
				
			f2.createNewFile();
			
			System.out.println("Nombre del directorio creado: " + f.getName());
			System.out.println("Nombre del fichero creado: " + f2.getName());
			System.out.println("Directorio padre: " + f2.getParent());
			System.out.println("Ruta relativa: " + f2.getPath());
			System.out.println("Ruta absoluta: " + f2.getAbsolutePath());

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
