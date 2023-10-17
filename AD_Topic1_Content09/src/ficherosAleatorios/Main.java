package ficherosAleatorios;

import java.io.IOException;
import java.io.RandomAccessFile;

public class Main {

	public static void main(String[] args) {

		try {
			creaFichBin("C:\\Users\\Studium\\Desktop\\DAM\\AD\\AD_Topic1_Content09\\aleatorio.dat");
			imprimeNumeroyPosicion("Aleatorio.dat", 20);
		} catch (IOException e){
			e.getMessage();
		}

	}

	private static void imprimeNumeroyPosicion(String ruta, long cual) throws IOException {
		RandomAccessFile f = new RandomAccessFile(ruta, "r");
		System.out.print("El fichero " + ruta +" ocupa " + f.length() + " bytes.");
		/* Me posicione cual - 1 porque empieza en 0 */
		f.seek(cual - 1);
		System.out.print(" En la posición " + f.getFilePointer()+ " está el numero " + f.readByte());
		/* Salto 9, 10 elementos más allá */
		f.skipBytes(9);
		System.out.print(". Y 10 elementos más allá, está el " + f.readByte());
		f.close();
	}


	private static void creaFichBin(String ruta) throws IOException {
		RandomAccessFile f = new RandomAccessFile(ruta, "rw");
		for (int i = 1; i<= 100; i++) {
			f.write(i);
		}
		f.close();
	}
}

