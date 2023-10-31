package es.studium.example03;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Example03 {

	public static void main(String[] args) {
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			String sourceURL = "jdbc:mysql://localhost/videoclub";
			Connection dbcon = DriverManager.getConnection(sourceURL, "root", "rootEsteban1");
			Statement stm = dbcon.createStatement();
			
			String consulta = "UPDATE peliculas SET GENERO = ? WHERE TITULO LIKE ?";
			PreparedStatement pst = dbcon.prepareStatement(consulta);
			pst.setString(1, "Teatro");
			pst.setString(2, "Nueva Película");
			pst.executeUpdate();
			pst.clearParameters();
			
			ResultSet rs = stm.executeQuery("SELECT TITULO, GENERO, ANIO, PRECIO FROM peliculas");
			
			// Mostrar los datos
			while (rs.next())
			{
				String titulo = rs.getString(1);
				Float precio = rs.getFloat(4);
				
				System.out.println("Título: " +titulo+ " Precio: " +precio);
			}
			rs.close();
			stm.close();
			dbcon.close();
		}
		catch (ClassNotFoundException cnf)
		{
			System.out.println("Driver erróneo " + cnf);
		}
		catch (SQLException sqle)
		{
			System.out.println("Error de SQL " + sqle);
		}
	}
}
