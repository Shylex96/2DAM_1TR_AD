package hibernate.anotaciones;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class TestPerro {

	public static void main(String[] args) {
		{
			//Perro perro1 = new Perro("Border Collie", "Mediano", 4, "Negro");
			//Perro perro2 = new Perro("Pomerania", "Peque�o", 2, "Marr�n");
			//Perro perro3 = new Perro("Carlino", "Peque�o", 6, "Blanco");
			
			SessionFactory sessionFactory = new Configuration().addAnnotatedClass(Perro.class).configure().buildSessionFactory();
			Session session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
		
						
			Perro perro1 = new Perro();
			perro1.setRaza("Border Collie");
			perro1.setTamano("Mediano");
			perro1.setEdad(4);
			perro1.setColor("Negro");
			
			Perro perro2 = new Perro();
			perro2.setRaza("Pomerania");
			perro2.setTamano("Peque�o");
			perro2.setEdad(2);
			perro2.setColor("Marr�n");
			
			Perro perro3 = new Perro();
			perro3.setRaza("Carlino");
			perro3.setTamano("Peque�o");
			perro3.setEdad(6);
			perro3.setColor("Blanco");
			
			// merge or persist
			session.persist(perro1);
			session.persist(perro2);
			session.persist(perro3);
			tx.commit();
			session.close();
			
			
			
			System.out.println("El perro " + perro1.getRaza() + " de tama�o " + perro1.getTamano() + " con edad de " + perro1.getEdad() + " a�os y color " + perro1.getColor() +" se ha a�adido correctamente a tu base de datos");
			System.out.println("El perro " + perro2.getRaza() + " de tama�o " + perro2.getTamano()  + " con edad de " + perro2.getEdad() + " a�os y color " + perro2.getColor() + " se ha a�adido correctamente a tu base de datos");
			System.out.println("El perro " + perro3.getRaza() + " de tama�o " + perro3.getTamano() + " con edad de " + perro3.getEdad() + " a�os y color " + perro3.getColor() +" se ha a�adido correctamente a tu base de datos");
			
		}
	}
}
