package com.example.application.data.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Conexion {
	
	// Luego, puedes establecer la conexión


	//conexion a google cloud, si no esta en linea favor solicitar reinicio.
	private final static String ruta = "jdbc:postgresql://34.71.178.20:5432/hospitaldb";
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
			JOptionPane.showMessageDialog(null,"Favor verificar si servidor esta encendido");
			return false;
		}
		

	}

}

