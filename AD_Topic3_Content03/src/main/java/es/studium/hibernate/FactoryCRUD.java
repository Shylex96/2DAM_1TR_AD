package es.studium.hibernate;

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

	public static void crear(Usuario u) {
		Session sessionObj = getSession();
		Transaction tx = sessionObj.beginTransaction();
		sessionObj.persist(u);
		tx.commit();
		sessionObj.close();
		System.out.println("Usuario con ID: " + u.getId() + " - Nombre: " + u.getNombre() + " - y Contraseña: " + u.getClave() + " - se ha insertado correctamente en la tabla users de la base de datos adt3_hibernate.");

	}

	public static List<Usuario> leer() {
		/* Podemos expresar así la consulta o también indicando
			directamente el nombre
		 * de la clase POJO: "FROM Usuario";*/
		String consulta = "FROM " + Usuario.class.getName();
		Session sessionObj = getSession();
		List<Usuario> listaResultado = sessionObj.createQuery(consulta, Usuario.class).list();
		Iterator<Usuario> iteradorResultado = listaResultado.iterator();
		while (iteradorResultado.hasNext()) {
			/* En este objeto Usuario u es donde recuperamos
			cada objeto de la base de datos
			 * que cumple la condición de la consulta que
			hemos ejecutado*/
			Usuario u = iteradorResultado.next();
			System.out.println(u.getId() + " - " + u.getNombre() + " - " + u.getClave());
		}
		sessionObj.close();
		return listaResultado;
	}
	
	public static void actualizar(Usuario u) {
		Session sessionObj = getSession();
		Transaction transObj = sessionObj.beginTransaction();
		/* Actualizamos el objeto */
		sessionObj.merge(u);
		transObj.commit();
		sessionObj.close();
		System.out.println(
		"Actualizado correctamente el usuario de id: " + u.getId());
		}
	
	public static void eliminar(Usuario u) {
		Session sessionObj = getSession();
		Transaction transObj = sessionObj.beginTransaction();
		sessionObj.remove(u);
		transObj.commit();
		sessionObj.close();
		System.out.println("Eliminado correctamente el usuario de id: " + u.getId());
		}

}
