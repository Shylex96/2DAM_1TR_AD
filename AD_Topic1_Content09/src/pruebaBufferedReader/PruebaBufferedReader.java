package pruebaBufferedReader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class PruebaBufferedReader {

	public static void main(String[] args) {
		try {
			File f = new File("C:\\Users\\Studium\\Desktop\\DAM\\AD\\AD_Topic1_Content09\\prueba.txt");
			FileReader fr = new FileReader(f);
			BufferedReader bf = new BufferedReader(fr);
			int contador = 0;
			while (bf.readLine() != null) {
				contador++;
				/* El método readLine() no necesita añadirle que siga leyendo porque se coloca en el siguiente cuando termina*/
			}
			bf.close();
			fr.close();
			System.out.println("Total de líneas: "+ contador);
		} catch (IOException ex) {
			System.out.println("Se ha producido un ERROR");
		}
	}
}

