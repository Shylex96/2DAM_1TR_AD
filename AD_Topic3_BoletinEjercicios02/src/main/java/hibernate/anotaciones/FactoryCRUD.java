package hibernate.anotaciones;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class FactoryCRUD {

	private static Session getSession() {
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		return session;
	}

	public static void crearPersona(Persona person) {
		Session sessionObj = getSession();
		Transaction tx = sessionObj.beginTransaction();
		sessionObj.persist(person);
		tx.commit();
		sessionObj.close();
		System.out.println("Persona con ID: " + person.getId() + " y Nombre: " + person.getNombre() + " - se ha insertado correctamente en la tabla users de la base de datos adt3_hibernate.");
	}

	public static void crearPelicula(Pelicula peli) {
		Session sessionObj = getSession();
		Transaction tx = sessionObj.beginTransaction();
		sessionObj.persist(peli);
		tx.commit();
		sessionObj.close();
		System.out.println("Pel�cula con ID: " + peli.getId() + " con T�tulo: " + peli.getTitulo() + " del a�o: " + peli.getAnio() + "  con duraci�n:  " + peli.getDuracion() + " realizada por el director: " + peli.getDirector() + " - se ha insertado correctamente en la tabla users de la base de datos adt3_hibernate.");
	}

	public static List<Persona> leerPersonas() {
		String consulta = "FROM " + Persona.class.getName();
		Session sessionObj = getSession();
		List<Persona> listaResultado = sessionObj.createQuery(consulta, Persona.class).list();
		Iterator<Persona> iteradorResultado = listaResultado.iterator();
		while (iteradorResultado.hasNext()) {
			Persona person = iteradorResultado.next();
			System.out.println("Persona con ID: " + person.getId() + " y Nombre: " + person.getNombre());
		}
		sessionObj.close();
		return listaResultado;
	}

	public static List<Pelicula> leerPeliculas() {
		String consulta = "FROM " + Pelicula.class.getName();
		Session sessionObj = getSession();
		List<Pelicula> listaResultado = sessionObj.createQuery(consulta, Pelicula.class).list();
		Iterator<Pelicula> iteradorResultado = listaResultado.iterator();
		while (iteradorResultado.hasNext()) {
			Pelicula peli = iteradorResultado.next();
			System.out.println("Pel�cula con ID: " + peli.getId() + " con T�tulo: " + peli.getTitulo() + " del a�o: " + peli.getAnio() + "  con duraci�n:  " + peli.getDuracion() + " realizada por el director: " + peli.getDirector());
		}
		sessionObj.close();
		return listaResultado;
	}

	public static void actualizarPersona(Persona person) {
		Session sessionObj = getSession();
		Transaction transObj = sessionObj.beginTransaction();
		sessionObj.merge(person);
		transObj.commit();
		sessionObj.close();
		System.out.println("Actualizado correctamente la persona de id: " + person.getId());
	}

	public static void actualizarPelicula(Pelicula peli) {
		Session sessionObj = getSession();
		Transaction transObj = sessionObj.beginTransaction();
		sessionObj.merge(peli);
		transObj.commit();
		sessionObj.close();
		System.out.println("Actualizada correctamente la pel�cula de id: " + peli.getId());
	}

	public static void eliminarPersona(Persona person) {
		Session sessionObj = getSession();
		Transaction transObj = sessionObj.beginTransaction();
		sessionObj.remove(person);
		transObj.commit();
		sessionObj.close();
		System.out.println("Eliminada correctamente la persona de id: " + person.getId());
	}

	public static void eliminarPelicula(Pelicula peli) {
		Session sessionObj = getSession();
		Transaction transObj = sessionObj.beginTransaction();
		sessionObj.remove(peli);
		transObj.commit();
		sessionObj.close();
		System.out.println("Eliminada correctamente la pel�cula de id: " + peli.getId());
	}
}
