package es.studium.example01;

import java.sql.*;

public class Example01 {

	public static void main(String[] args) {
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			String sourceURL = "jdbc:mysql://localhost/videoclub";
			Connection dbcon = DriverManager.getConnection(sourceURL, "root", "rootEsteban1");
			Statement sentencia = dbcon.createStatement();
			String ins = "INSERT INTO PELICULAS (TITULO,GENERO,ANIO,PRECIO,PRECIOALQUILER) VALUES ('NUEVA PELI', 'ACCI�N', 2010, 5, 15)";
			sentencia.executeUpdate(ins);
			ResultSet resultado = sentencia.executeQuery("SELECT * FROM peliculas");
			// Mostrar los datos

			while (resultado.next())
			{
				System.out.println(resultado.getInt("ID") + " " + resultado.getString("TITULO"));
			}
			resultado.close();
			sentencia.close();
			// Cerramos la conexi�n. Al cerrar la conexi�n se cierran tambi�n los
			// recursos dependientes(Statement y ResultSet). No obstante, se
			// recomienda cerrarlos de forma expl�cita descomentando las
			// l�neas anteriores en rojo.
			dbcon.close();
		}
		catch (ClassNotFoundException cnf)
		{
			System.out.println("Driver err�neo " + cnf);
		}
		catch (SQLException sqle)
		{
			System.out.println("Error de SQL " + sqle);
		}
	}
}