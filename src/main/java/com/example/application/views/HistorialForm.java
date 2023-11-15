package com.example.application.views;


import java.time.LocalDate;

import com.example.application.data.Historial;
import com.example.application.data.services.CrudPacientes;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.TextField;

public class HistorialForm extends FormLayout { 
  private static final long serialVersionUID = 1L;
  TextField dniPaciente = new TextField("DNI Paciente");
  DatePicker dateDate = new DatePicker("Fecha Cita");
  TextField motivoDate = new TextField("Motivo Cita"); 
  TextField diagnos = new TextField("Diagnostico");
  DatePicker dateNext = new DatePicker("Proxima Cita");
  
  

  Button save = new Button("Save");
  
  Button close = new Button("Pacientes");

  public HistorialForm() {
    addClassName("historial-form"); 
    
    add(dniPaciente, dateDate,motivoDate,diagnos,dateNext,createButtonsLayout());
    
    
  }

  private HorizontalLayout createButtonsLayout() {
    save.addThemeVariants(ButtonVariant.LUMO_PRIMARY); 
    
    close.addThemeVariants(ButtonVariant.LUMO_TERTIARY);
    
    save.addClickListener(e->crearHistorial());
    
    save.addClickShortcut(Key.ENTER); 
    close.addClickShortcut(Key.ESCAPE);

    return new HorizontalLayout(save, close); 
  }

private Object crearHistorial() {
	
	Historial historial=new Historial();
	LocalDate fechaCita = dateDate.getValue();
	historial.setFecha_cita(fechaCita.toString());
	historial.setMotivo_cita(motivoDate.getValue());
	historial.setDiagnostico(diagnos.getValue());
	LocalDate fechaSeleccionada = dateNext.getValue();
	historial.setProxima_cita(fechaSeleccionada.toString());
	historial.setIdentidad(dniPaciente.getValue());
	
	
	CrudPacientes.guardarHistorial(historial);
	// TODO Auto-generated method stub
	return null;
}

public void setHistorial(Object object) {
	// TODO Auto-generated method stub
	
}


    
  
}