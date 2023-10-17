package FileExampleHandler;

import java.io.File;
import java.io.IOException;
import java.io.FileReader;

public class Example2 {

    public static void main(String[] args) {

    	 File f = new File("proyecto\\libros.xml");
    	
        try {
          
            FileReader reader = new FileReader(f);

            System.out.println("Nombre: " + f.getName());
            System.out.println("Directorio padre: " + f.getParent());
            System.out.println("Ruta relativa: " + f.getPath());
            System.out.println("Ruta absoluta: " + f.getAbsolutePath());

            reader.close();
        } catch (IOException ex) {
            System.out.println("Se ha producido un error: " + ex);
        }

    }

}
