package com.example.application.views;

import java.util.List;

import com.example.application.data.Historial;

public interface HistorialViewModel {

	void mostrarHistorialEnGrid(List<Historial> items);

	void mostrarMensaje(String string);

}
