package pruebaFile;

import java.io.FileReader;
import java.io.IOException;

public class PruebaFile {
	private static String FILE_NAME = "C:\\Users\\Studium\\Desktop\\DAM\\AD\\AD_Topic1_Content09\\prueba.txt";
	private static char BUSCAR = 'a';
	public static void main(String[] args) {
		try {
			int contador = 0;
			FileReader input = new FileReader(FILE_NAME);
			
			int c = input.read();
			System.out.println("C�digo ASCII " +c);
			System.out.println("Primer car�cter le�do: " +(char) c);
			while (c != -1) {
				/* vemos si es el que buscamos */
				if ((char) c == BUSCAR)
					contador++;
				/* leemos otro car�cter */
				c = input.read();
			}
			/* cerramos el flujo */
			input.close();
			System.out.println("N� de veces que aparece el car�cter " +BUSCAR+ " en el fichero "+ FILE_NAME + ": " +contador);
		} catch (IOException ex) {
			System.out.println("Se ha producido un ERROR");
		}
	}
}
