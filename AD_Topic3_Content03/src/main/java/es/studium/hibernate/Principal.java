package es.studium.hibernate;

public class Principal {

	public static void main(String[] args) {
		{
			/*Creamos un objeto de tipo Usuario utilizando el
		constructor por parámetros*/
			Usuario usuario1 = new Usuario("Daniel", "1458lk");
			/*Llamamos la método crear(usuario1) de la clase
			 * FactoryCRUD para que se cree el objeto usuario1 en la
			 * base de datos*/
			//			FactoryCRUD.crear(usuario1);
//			FactoryCRUD.leer();
//			FactoryCRUD.actualizar(usuario1);
			
			Usuario usuario39 = new Usuario(39);
			FactoryCRUD.eliminar(usuario39);
			
		}
	}
}
