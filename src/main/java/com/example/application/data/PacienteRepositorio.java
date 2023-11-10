package com.example.application.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.example.application.data.services.Conexion;

public class PacienteRepositorio {
	
	public List<Paciente> consultaPaciente() {
	    List<Paciente> pacientes = new ArrayList<>();

	    try {
	        Connection conexion = Conexion.conectarse();
	        String sqlString = "SELECT * FROM pacientes;";
	        PreparedStatement stmt = conexion.prepareStatement(sqlString);
	        ResultSet resultSet = stmt.executeQuery();

	        while (resultSet.next()) {
	            Paciente paciente = new Paciente();
	            paciente.setDni(resultSet.getString("dni_number"));
	            paciente.setNombre(resultSet.getString("nombre"));
	            paciente.setApellido(resultSet.getString("apellido"));
	            paciente.setFechaNac(resultSet.getString("fecha2"));
	            paciente.setGenero(resultSet.getString("genero"));
	            paciente.setDireccion(resultSet.getString("direccion"));
	            paciente.setTelefono(resultSet.getString("telefono"));
	            paciente.setResponsable(resultSet.getString("responsable"));

	            pacientes.add(paciente);
	        }

	        
	        resultSet.close();
	        stmt.close();
	        conexion.close();

	    } catch (SQLException ex) {
	        ex.printStackTrace();
	        System.out.println("No se pudo conectar a la base de datos");
	    }

	    return pacientes;
	}
	
}




