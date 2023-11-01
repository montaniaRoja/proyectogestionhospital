package com.example.application.views.list;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

import com.example.application.data.Genero;
import com.example.application.data.Paciente;
import com.example.application.data.service.Conexion;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.TextField;

public class PacientForm extends FormLayout { 
  TextField dNi = new TextField("Numero de Identidad");
  TextField firstName = new TextField("Nombre"); 
  TextField lastName = new TextField("Apellidos");
  DatePicker datePicker = new DatePicker("Fecha de Nacimiento");
  //Genero masculino=new Genero("Masculino");
  //Genero femenino=new Genero("Femenino");
  
  
  String generos[]= {"Masculino","Femenino"};
  ComboBox<String> genero = new ComboBox<>("Género");
  
  TextField direccion = new TextField("Direccion");
  TextField telefono = new TextField("Telefono"); 
  TextField responsable = new TextField("Responsable");
  

  Button save = new Button("Save");
  Button delete = new Button("Delete");
  Button close = new Button("Cancel");

  public PacientForm() {
    addClassName("pacient-form"); 
    
    add(dNi,firstName,lastName,datePicker,genero,direccion,telefono,responsable,createButtonsLayout());
  }

  private HorizontalLayout createButtonsLayout() {
    save.addThemeVariants(ButtonVariant.LUMO_PRIMARY); 
    delete.addThemeVariants(ButtonVariant.LUMO_ERROR);
    close.addThemeVariants(ButtonVariant.LUMO_TERTIARY);
    
    save.addClickListener(e->guardarPaciente());
    
    save.addClickShortcut(Key.ENTER); 
    close.addClickShortcut(Key.ESCAPE);

    return new HorizontalLayout(save, delete, close); 
  }

private Object guardarPaciente() {
	
	
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
	return null;
}
  
  
  
  
}