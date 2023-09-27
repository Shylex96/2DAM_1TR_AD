package FileExampleMethods;

import java.io.File;
import java.io.FilenameFilter;
public class FiltroExtension implements FilenameFilter
{
	private String extension;
	public FiltroExtension(String extension)
	{
		this.extension = extension;
	}
	@Override
	public boolean accept(File ruta, String nombreFichero)
	{
		/* El método endsWith(extension)
		 * Prueba si la cadena nombreFichero termina con el
sufijo especificado.*/
		return nombreFichero.endsWith(extension);
	}
}