package FileExampleHandler;

import java.io.File;

public class Example1 {

	public static void main(String[] args) {
		
			File f = new File ("proyecto\\libros.xml");

			System.out.println ("Nombre: " + f.getName());
			System.out.println ("Directorio padre: " + f.getParent());
			System.out.println ("Ruta relativa: " + f.getPath());
			System.out.println ("Ruta absoluta: " + f.getAbsolutePath());

	}

}
