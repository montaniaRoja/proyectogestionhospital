package com.example.application.data.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.example.application.data.Historial;
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
	         String fecha=paciente.getFecha();
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

	public static void guardarHistorial(Historial historial) {
		// TODO Auto-generated method stub
		System.out.println("guardando historial");

		 try {
	         Connection resultado = Conexion.conectarse();
	         
	       //preparar la consulta
	         String sqlString = "INSERT INTO historial(fecha_cita, motivo_cita, diagnostico, proxima_cita,paciente_id) VALUES (?,?,?,?,?);";
	         PreparedStatement stmt = resultado.prepareStatement(sqlString);
	         String fecha=historial.getFecha_cita();
	         String motivo=historial.getMotivo_cita();
	         String diag=historial.getDiagnostico();
	         String proxima=historial.getProxima_cita();
	         String identidad=historial.getIdentidad();
	         System.out.println(identidad);

	         stmt.setString(1, fecha);
	         stmt.setString(2, motivo);
	         stmt.setString(3, diag);
	         stmt.setString(4, proxima);
	         stmt.setString(5, identidad);
	         ;
	         
	         
	     	//ejecutar la consulta
	         stmt.executeUpdate();
	         
	         
	     } catch (SQLException e) {
	         e.printStackTrace();

	     }

		
		
	}
	

}
