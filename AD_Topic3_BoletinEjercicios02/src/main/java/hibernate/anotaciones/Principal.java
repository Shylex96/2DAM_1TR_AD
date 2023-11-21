package hibernate.anotaciones;

public class Principal {

	public static void main(String[] args) {

		Persona persona1 = new Persona("Dyma");
		FactoryCRUD.crearPersona(persona1);
		FactoryCRUD.leerPersonas();


		Pelicula pelicula1 = new Pelicula("Lost in paradise", 2023, 125, persona1);
		FactoryCRUD.crearPelicula(pelicula1);
		FactoryCRUD.leerPeliculas();
		
		//FactoryCRUD.actualizar...
		//FactoryCRUD.eliminar...

	}
}
