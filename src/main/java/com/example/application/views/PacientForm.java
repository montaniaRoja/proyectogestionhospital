package com.example.application.views;


import java.time.LocalDate;

import com.example.application.data.Paciente;
import com.example.application.data.services.CrudPacientes;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.TextField;

public class PacientForm extends FormLayout { 
  private static final long serialVersionUID = 1L;
TextField dNi = new TextField("Numero de Identidad");
  TextField firstName = new TextField("Nombre"); 
  TextField lastName = new TextField("Apellidos");
  DatePicker datePicker = new DatePicker("Fecha de Nacimiento");
  //Genero masculino=new Genero("Masculino");
  //Genero femenino=new Genero("Femenino");
  
  
  String generos[]= {"Masculino","Femenino","Prefiero no decirlo"};
  ComboBox<String> genero = new ComboBox<>("Género");
  
  
  
  
  TextField direccion = new TextField("Direccion");
  TextField telefono = new TextField("Telefono"); 
  TextField responsable = new TextField("Responsable");
  

  Button save = new Button("Save");
  Button delete = new Button("Delete");
  Button close = new Button("Cancel");

  public PacientForm() {
    addClassName("pacient-form"); 
    genero.setItems(generos);
    add(dNi,firstName,lastName,datePicker,genero,direccion,telefono,responsable,createButtonsLayout());
    
    
  }

  private HorizontalLayout createButtonsLayout() {
    save.addThemeVariants(ButtonVariant.LUMO_PRIMARY); 
    delete.addThemeVariants(ButtonVariant.LUMO_ERROR);
    close.addThemeVariants(ButtonVariant.LUMO_TERTIARY);
    
    save.addClickListener(e->crearPaciente());
    
    save.addClickShortcut(Key.ENTER); 
    close.addClickShortcut(Key.ESCAPE);

    return new HorizontalLayout(save, delete, close); 
  }

private Object crearPaciente() {
	
	Paciente paciente=new Paciente();
	paciente.setDni(dNi.getValue());
	paciente.setNombre(firstName.getValue());
	paciente.setApellido(lastName.getValue());
	LocalDate fechaSeleccionada = datePicker.getValue();
	paciente.setFechaNac(fechaSeleccionada.toString());
	paciente.setGenero(genero.getValue());
	paciente.setDireccion(direccion.getValue());
	paciente.setTelefono(telefono.getValue());
	paciente.setResponsable(responsable.getValue());
	
	CrudPacientes.guardarPaciente(paciente);
	// TODO Auto-generated method stub
	return null;
}


  
  
  
  
}