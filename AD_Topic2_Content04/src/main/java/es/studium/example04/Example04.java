package es.studium.example04;

import java.sql.*;

public class Example04 {

	public static void main(String[] args) {
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			String sourceURL = "jdbc:mysql://localhost/videoclub";
			Connection dbcon = DriverManager.getConnection(sourceURL, "root", "rootEsteban1");
			Statement sentencia = dbcon.createStatement();
			String consulta = "SELECT TITULO, GENERO, PRECIO FROM peliculas";
			ResultSet rs = sentencia.executeQuery(consulta);
			ResultSetMetaData rsmdt = rs.getMetaData();
			System.out.println(rsmdt.getColumnName(1));
			System.out.println(rsmdt.getColumnTypeName(1)); 
			System.out.println(rsmdt.getColumnLabel(1)); 
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
