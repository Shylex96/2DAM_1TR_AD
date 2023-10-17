package FileExampleMethods;

import java.io.File;
import java.io.FilenameFilter;
public class FiltroInicioNombre implements FilenameFilter
{
	private String inicioNombre;
	public FiltroInicioNombre(String inicioNombre)
	{
		this.inicioNombre = inicioNombre;
	}
	@Override
	public boolean accept(File ruta, String nombreFichero)
	{
		boolean coincideInicioNombre = false;
		// El método compareTo() devuelve 0 si los String que se comparan son iguales.
		if
		(nombreFichero.substring(0,inicioNombre.length()).compareTo(inicioNombre) == 0)
		{
			coincideInicioNombre = true;
		}
		return coincideInicioNombre;
	}
}