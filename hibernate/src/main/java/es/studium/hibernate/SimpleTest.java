package es.studium.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
public class SimpleTest
{
	public static void main(String[] args)
	{
		// Crea un objeto de tipo SessionFactory con la configuraciÃ³n especificada en el
		// fichero hibernate.cfg.xml
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		
		/*Creamos un objeto de tipo Usuario utilizando el
	constructor por defecto*/
		Usuario usuario1 = new Usuario();
		usuario1.setNombre("María José");
		usuario1.setClave("12345678");
		
		/*Creamos un objeto de tipo Usuario utilizando el
	constructor por parÃ¡metros*/
		Usuario usuario2 = new Usuario("Jaime", "7895mikl");
		
		/*Para crear objetos con save() no necesitamos objeto Transaction*/
		session.persist(usuario1); // Marcamos el objeto para guardarlo en la BBDD.
		session.persist(usuario2); //Guardamos el objeto en la base de datos
		session.close();
		
		System.out.println("El usuario " + usuario1.getNombre() + " y la contraseña " + usuario1.getClave() + " se ha añadido correctamente a tu base de datos");
		System.out.println("El usuario " + usuario2.getNombre() + " y la contraseña " + usuario2.getClave() + " se ha añadido correctamente a tu base de datos");
	}
}
