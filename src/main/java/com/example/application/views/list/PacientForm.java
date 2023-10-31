package com.example.application.views.list;


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
  ComboBox<String> genero=new ComboBox<>("Genero");
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

    save.addClickShortcut(Key.ENTER); 
    close.addClickShortcut(Key.ESCAPE);

    return new HorizontalLayout(save, delete, close); 
  }
}