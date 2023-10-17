package ejercicio10;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Ejercicio10 {

	public static void main(String[] args) {

		try {
			lectura("C:\\Users\\Studium\\Desktop\\DAM\\AD\\Ad_Topic1_Exercises02\\exercise02.txt");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void lectura(String ruta) throws IOException {

		File file = new File(ruta);
		FileReader fileReader = new FileReader(file);

		try {
			int contador = 0;
			int character = fileReader.read();

			while (character != -1 && contador < 10) {
				System.out.print((char) character);
				character = fileReader.read();
				contador++;
			}
		} catch (IOException ex) {
			System.out.println("Se ha producido un ERROR");
		}
		fileReader.close();
	}
}
