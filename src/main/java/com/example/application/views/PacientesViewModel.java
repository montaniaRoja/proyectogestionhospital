package com.example.application.views;

import java.util.List;

import com.example.application.data.Paciente;

public interface PacientesViewModel {

	void mostrarPacientesEnGrid(List<Paciente> items);

	void mostrarMensaje(String string);
	
	

}
