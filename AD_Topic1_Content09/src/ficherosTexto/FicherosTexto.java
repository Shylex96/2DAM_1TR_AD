package ficherosTexto;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FicherosTexto {
	private static String FILE_NAME = ("C:\\Users\\Studium\\Desktop\\DAM\\AD\\AD_Topic1_Content09\\prueba.txt");
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		try {
			System.out.print("Introduzca texto: ");
			String text = sc.nextLine();
			FileWriter output = new FileWriter(FILE_NAME);
			output.write(text);
			output.close();
			sc.close();
		} catch (IOException ex) {
			System.out.println("Se ha producido un ERROR");
		}
	}
}
