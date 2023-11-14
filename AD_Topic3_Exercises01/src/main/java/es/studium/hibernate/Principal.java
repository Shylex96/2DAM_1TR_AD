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
			FactoryCRUD.crear(usuario1);
			FactoryCRUD.leer();
			

			Usuario usuario51 = new Usuario(51, "Daniel", "145dsfddgdf8lk");
			FactoryCRUD.actualizar(usuario51);
//			FactoryCRUD.actualizar(usuario1);
			
			Usuario usuarioObj = new Usuario(13);
			FactoryCRUD.eliminar(usuarioObj);

		}
	}
}
