package com.example.application.data.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.example.application.data.Paciente;

public class CrudPacientes {
	
		
	public static void guardarPaciente(Paciente paciente) {
		
		
		 try {
	         Connection resultado = Conexion.conectarse();
	         
	       //preparar la consulta
	         String sqlString = "INSERT INTO pacientes(dni_number, nombre, apellido, fecha2,genero, direccion, telefono, responsable) VALUES (?,?,?,?,?,?,?,?);";
	         PreparedStatement stmt = resultado.prepareStatement(sqlString);
	         String dni=paciente.getDni();
	         String nombre=paciente.getNombre();
	         String apellido=paciente.getApellido();
	         String fecha=paciente.getFechaNac();
	         String genero=paciente.getGenero();
	         String direccion=paciente.getDireccion();
	         String telefono=paciente.getTelefono();
	         String responsable=paciente.getResponsable();

	         stmt.setString(1, dni);
	         stmt.setString(2, nombre);
	         stmt.setString(3, apellido);
	         stmt.setString(4, fecha);
	         stmt.setString(5, genero);
	         stmt.setString(6, direccion);
	         stmt.setString(7, telefono);
	         stmt.setString(8, responsable);
	         
	         
	     	//ejecutar la consulta
	         stmt.executeUpdate();
	         
	         
	     } catch (SQLException e) {
	         e.printStackTrace();

	     }
			// TODO Auto-generated method stub
		
	}
	

}
