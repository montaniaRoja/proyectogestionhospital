package com.example.application.views;


import java.time.LocalDate;

import com.example.application.data.Paciente;
import com.example.application.data.services.CrudPacientes;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.BeanValidationBinder;

public class PacientForm extends FormLayout { 
  private static final long serialVersionUID = 1L;
  
  //componentes del formulario
  
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
  Button update = new Button("Update");
  Button close = new Button("Cancel");
  Button appmnt=new Button("Citas");
  
  BeanValidationBinder<Paciente> binder = new BeanValidationBinder<>(Paciente.class);
  
  public PacientForm() {
    addClassName("pacient-form");
    binder.bindInstanceFields(this); 
    genero.setItems(generos);
    add(dNi,firstName,lastName,datePicker,genero,direccion,telefono,responsable,createButtonsLayout());
    
    
  }

  private HorizontalLayout createButtonsLayout() {
    save.addThemeVariants(ButtonVariant.LUMO_PRIMARY); 
    update.addThemeVariants(ButtonVariant.LUMO_ERROR);
    close.addThemeVariants(ButtonVariant.LUMO_TERTIARY);
    appmnt.addThemeVariants(ButtonVariant.LUMO_SUCCESS);
    
    save.addClickListener(e->crearPaciente());
    
    appmnt.addClickListener(e -> { 
    	
    	agregarHistorial();
    	
    
    });
         
    	// Obtener el valor del campo dni del formulario
        
        
    


    
    save.addClickShortcut(Key.ENTER); 
    close.addClickShortcut(Key.ESCAPE);

    return new HorizontalLayout(save, update, close, appmnt); 
  }
  
  
  private void agregarHistorial() {
	  String dni=dNi.getValue();
	  UI.getCurrent().navigate("historial/"+dni);
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

public void setPaciente(Paciente paciente) {
	binder.setBean(paciente);
	// TODO Auto-generated method stub
	
}

  
  
}