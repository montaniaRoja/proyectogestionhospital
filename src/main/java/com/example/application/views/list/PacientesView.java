package com.example.application.views.list;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import java.util.Collections;

import com.example.application.data.*;
import com.example.application.views.*;


@Route(value = "pacientes", layout = MainLayout.class)
@PageTitle("Pacientes | Hospital CRM")
public class PacientesView  extends VerticalLayout {
	
	Grid<Paciente> grid = new Grid<>(Paciente.class); 
    TextField filterText = new TextField();
    PacientForm form;

    public PacientesView() {
        addClassName("list-view"); 
        setSizeFull();
        configureGrid(); 
        configureForm();

        add(getToolbar(), getContent()); 
    }

    private void configureForm() {
    	form = new PacientForm(); 
        form.setWidth("25em");
		// TODO Auto-generated method stub
		
	}

	private void configureGrid() {
        grid.addClassNames("contact-grid"); 
        grid.setSizeFull();
        grid.setColumns("dni","nombre", "apellido", "fechaNac","genero","direccion","telefono","responsable"); 
        
        grid.getColumns().forEach(col -> col.setAutoWidth(true)); 
    }

    private HorizontalLayout getToolbar() {
        filterText.setPlaceholder("Filtrar por nombre...");
        filterText.setClearButtonVisible(true);
        filterText.setValueChangeMode(ValueChangeMode.LAZY); 

        Button addContactButton = new Button("Agregar Paciente");

        var toolbar = new HorizontalLayout(filterText, addContactButton); 
        toolbar.addClassName("toolbar"); 
        return toolbar;
    }
    
    
    private Component getContent() {
        HorizontalLayout content = new HorizontalLayout(grid,form );
         
        content.setFlexGrow(1, form);
        content.setFlexGrow(2, grid);
        content.addClassNames("content");
        content.setSizeFull();
        return content;
    }
}
	


