package FileExampleMethods;

import java.io.File;

public class EjercicioClaseFile {

	public static void main(String[] args) {

		try {

			File fichero;
			String[] listaNombresFicheros;
			String[] listaConFiltro;
			File[] listaFicheros;
			File ruta1 = new File("C:\\archivos_creados_Java");
			File ruta2 = new File("C:\\archivos_creados_Java\\pruebas_clase_file");
			File[] unidadesDisco = File.listRoots();

			for (File unidadDisco : unidadesDisco) {

				System.out.println("Unidad: " + unidadDisco + " espacio total: " + unidadDisco.getTotalSpace()
				+ " espacio libre: " + unidadDisco.getFreeSpace());
			}

			System.out.println("COMPROBAMOS LA EXISTENCIA DEL DIRECTORIO ANTES DE CREARLO");
			comprobarExistenciaFile(ruta1);
			comprobarExistenciaFile(ruta2);

			if (ruta1.exists()) {
				System.out.println("Existe la ruta : " + ruta1.getName());
				if (ruta2.mkdir()) {
					System.out.println("Se ha creado el directorio: " + ruta2.getName());
				}
			} else {
				System.out.println("No existe la ruta: " + ruta1.getName());
				if (ruta2.mkdirs()) {
					System.out.println("Se ha creado el directorio: " + ruta2.getName());
				}
			}
			System.out.println("COMPROBAMOS LA EXISTENCIA DEL DIRECTORIO DESPUES DE HABERLO CREADO");
			comprobarExistenciaFile(ruta2);
			for (int i = 0; i <= 4; i++) {
				fichero = new File(ruta2, "fichero" + i + ".dat");
				fichero.createNewFile();
				comprobarExistenciaFile(fichero);
			}
			listaNombresFicheros = ruta2.list();
			System.out.println("NOMBRE DE LOS FICHEROS QUE SE HAN CREADO (ACCEDIDO MEDIANTE list() )");

			for (String nombreFichero : listaNombresFicheros) {
				System.out.println(nombreFichero);
			}

			System.out.println("NOMBRE Y LONGITUD DE LOS FICHEROS QUE SE HAN CREADO (ACCEDIDO MEDIANTE listFiles() )");
			listaFicheros = ruta2.listFiles();

			for (File file : listaFicheros) {
				System.out.println("Nombre del fichero: " + file.getName() + " longitud: " + file.length());
			}

			System.out.println("NOMBRE DE LOS FICHEROS FILTRADOS POR EXTENSION");
			listaConFiltro = ruta2.list(new FiltroExtension(".dat"));

			for (String nombreFichero : listaConFiltro) {
				System.out.println(nombreFichero);
			}

			System.out.println("NOMBRE DE LOS FICHEROS FILTRADOS POR INICIO NOMBRE");
			listaConFiltro = ruta2.list(new FiltroInicioNombre("fichero1"));

			for (String nombreFichero : listaConFiltro) {
				System.out.println(nombreFichero);
			}

			System.out.println("RENOMBRAMOS LOS FICHEROS E IMPRIMIMOS EL NUEVO NOMBRE");

			for (int i = 0; i < listaFicheros.length; i++) {

				System.out.println("Para el renombrado del fichero, aplicamos: " + ruta2.getAbsolutePath()
				+ "\\nuevo_nombre_fichero" + i + ".dat");
				fichero = new File(ruta2.getAbsolutePath() + "\\nuevo_nombre_fichero" + i + ".dat");
				listaFicheros[i].getAbsoluteFile().renameTo(fichero);
			}
			listaNombresFicheros = ruta2.list();

			System.out.println("NUEVO NOMBRE DE LOS FICHEROS DESPUES DEL RENOMBRADO");

			for (String nombreFichero : listaNombresFicheros) {
				System.out.println(nombreFichero);
			}

			System.out.println("ELIMINAMOS LOS FICHEROS CREADOS Y EL DIRECTORIO DE RUTA2");
			listaFicheros = ruta2.listFiles();

			for (File file : listaFicheros) {
				String nombreFicheroAEliminar = file.getName();
				if (file.delete()) {
					System.out.println("Se ha eliminado el fichero: " + nombreFicheroAEliminar);
				}
			}

			String nombreDirectorioAEliminar = ruta2.getName();

			if (ruta2.delete()) {
				System.out.println("Se ha eliminado el directorio: " + nombreDirectorioAEliminar);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	private static void comprobarExistenciaFile(File file) {

		if (file.isDirectory()) {
			System.out.println(file.getName() + " es un directorio");
		} else {
			if (file.isFile()) {
				System.out.println(file.getName() + " es un fichero");
			} else {
				System.out.println(file.getName() + " no existe");
			}
		}
	}
}

