package ficherosBinarios;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class FicherosBinarios {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		FileOutputStream fos = null;
		DataOutputStream salida = null;
		int n;
		try {
			fos = new
					FileOutputStream("C:\\Users\\Studium\\Desktop\\DAM\\AD\\AD_Topic1_Content09\\prueba.txt");
			salida = new DataOutputStream(fos);
			System.out.print("Introduce número: ");
			n = sc.nextInt();
			while (n != -1) {
				/* Se escribe el número entero */
				salida.writeInt(n);
				System.out.print("Introduce número: ");
				n = sc.nextInt();
			}
			sc.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (fos != null)
					fos.close();
				if (salida != null)
					salida.close();
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
