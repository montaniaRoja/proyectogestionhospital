package com.example.application.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.example.application.data.services.Conexion;

public class HistorialRepositorio {
	
	private String parametro;
	
	public HistorialRepositorio(String dni) {
		this.setParametro(dni);
	}
	

	public List<Historial> consultaHistorial() {
	    List<Historial> historiales = new ArrayList<>();

	    try {
	    	String dniP=getParametro();
	    	System.out.println(dniP);
	        Connection conexion = Conexion.conectarse();
	        String sqlString = "SELECT * FROM historial where paciente_id=?;";
	        PreparedStatement stmt = conexion.prepareStatement(sqlString);
	        stmt.setString(1, dniP);
	        
	        ResultSet resultSet = stmt.executeQuery();

	        while (resultSet.next()) {
	            Historial historial = new Historial();
	            historial.setFecha_cita(resultSet.getString("fecha_cita"));
	            historial.setMotivo_cita(resultSet.getString("motivo_cita"));
	            historial.setDiagnostico(resultSet.getString("diagnostico"));
	            historial.setProxima_cita(resultSet.getString("proxima_cita"));
	            

	            historiales.add(historial);
	        }

	        
	        resultSet.close();
	        stmt.close();
	        conexion.close();

	    } catch (SQLException ex) {
	        ex.printStackTrace();
	        System.out.println("No se pudo conectar a la base de datos");
	    }

	    return historiales;
	}


	public String getParametro() {
		return parametro;
	}


	public void setParametro(String parametro) {
		this.parametro = parametro;
	}
	
}




