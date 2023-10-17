package ejercicio14;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Ejercicio14 {



	public static void main(String[] args) {

		try {
			consultar("C:\\Users\\Studium\\Desktop\\DAM\\AD\\Ad_Topic1_Exercises02");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void consultar(String ruta) throws IOException {

		//int contador = 0;
		Scanner sc = new Scanner(System.in);
		System.out.println("Escriba el nombre del alumno a consultar: ");
		String alumno = sc.nextLine();
		//sc.close();

		String alumnoTxt = null;

		if (alumno.contains(".txt")) {
			alumnoTxt = alumno;
		} else {
			alumnoTxt = alumno + ".txt";
		}

		File fileComprobacion = new File(alumnoTxt);

		if (fileComprobacion.exists()) {
			try {
				FileReader fr = new FileReader(fileComprobacion);
				BufferedReader bf = new BufferedReader(fr);
				String linea;
				

				while ((linea = bf.readLine()) != null) {
					String[] partes = linea.split("=");
					String clave = partes[0];
					String valor = partes[1];
					
					//System.out.println(partes[1]);

					/*
					 * if (partes[0] == "nota") {
						System.out.println(partes[0]);
					}
					 */
					//System.out.println(partes[0]);
					if (partes[0].contains("nota")) {
						String nombreReal = alumno;
						//parsear el valor
						int resultadoNota = Integer.parseInt(valor);
						
						if (resultadoNota >= 5) {
							System.out.println("El alumno "+ nombreReal + " ha aprobado con " +valor);
							// preguntar si desea continuar mirando otros alumnos
						} else {
							System.out.println("El alumno "+ nombreReal + " ha suspendido con " +valor);
							// preguntar si desea continuar mirando otros alumnos
						}
						
					}
				}
			} catch (IOException ex) {
				System.out.println("Se ha producido un ERROR");
			}
		} else {
			System.out.println("El archivo del alumno no existe.");
		}
	}
}
