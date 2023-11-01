package com.example.application.data.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Conexion {
	
	// Luego, puedes establecer la conexión


	
	private final static String ruta = "jdbc:postgresql://127.0.0.1:5432/hospitaldb";
	private final static String usuario = "adolfo";
	private final static String contrasenia = "ofloda01";
	
	public static Connection conectarse() throws SQLException{
		Connection conexion = DriverManager.getConnection(ruta, usuario, contrasenia);
			System.out.println("conexion ok");
		return conexion;	
	}
	
	public static boolean probarConexion() {
		try {
			
			Connection conn=conectarse();
			
			return true;
		} catch (SQLException ex) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null,"Conexion Fallo");
			return false;
		}
		
		
		
		
	}

}

