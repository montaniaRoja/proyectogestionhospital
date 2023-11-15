package com.example.application.views;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.router.BeforeEnterObserver;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import java.util.Collection;
import java.util.List;
import java.time.LocalDate;
import java.util.ArrayList;
import com.example.aplicattion.controller.PacientesInteractor;
import com.example.aplicattion.controller.PacientesInteractorImpl;
import com.example.application.data.*;


@Route(value = "pacientes", layout = MainLayout.class)
@PageTitle("Pacientes | Hospital CRM")
public class PacientesView  extends Div implements PacientesViewModel, BeforeEnterObserver {
	
	private static final long serialVersionUID = 1L;
	Grid<Paciente> grid = new Grid<>(Paciente.class);
	TextField filterText = new TextField();
    PacientForm form;
    private static PacientesInteractor controlador;
    private List<Paciente> elementos;
    
    
    public PacientesView() {
        addClassName("list-view"); 
        setSizeFull();
        configureGrid(); 
        configureForm();
        controlador=new PacientesInteractorImpl(this);
        this.setElementos(new ArrayList<>());
        add(getToolbar(), getContent()); 
            
    
        controlador.consultarPacientes(); //ESTE ES PARA CONECTARSE A ORACLE
        
        closeEditor();
    }

    private void closeEditor() {
    	form.setPaciente(null);
        form.setVisible(false);
        removeClassName("editing");
		
	}
    
    private void addPaciente() { 
        //grid.asSingleSelect().clear();
        form.firstName.clear();
        form.lastName.clear();
        form.datePicker.clear();
        form.setVisible(true);
        editPaciente(new Paciente());
    }
    
   
	private void configureForm() {
    	form = new PacientForm(); 
        form.setWidth("25em");
        
		// TODO Auto-generated method stub
		
	}
	
	
	private void configureGrid() {
        grid.addClassNames("paciente-grid"); 
        grid.setSizeFull();
        grid.setColumns("dni","nombre", "apellido", "fecha","genero","direccion","telefono","responsable"); 
        
        grid.getColumns().forEach(col -> col.setAutoWidth(true)); 
        
        grid.asSingleSelect().addValueChangeListener(event ->
        editPaciente(event.getValue()));
        
        
    }
	
	

	public void editPaciente(Paciente paciente) { 
        if (paciente == null) {
            closeEditor();
        } else {
           //form.setPaciente(paciente);//aqui llenamos el formulario con los datos del paciente pero como no me funciono lo hice con todos los campos
            form.dNi.setValue(paciente.getDni());
            form.firstName.setValue(paciente.getNombre());
            form.lastName.setValue(paciente.getApellido());
            
          
           form.datePicker.setValue(LocalDate.parse(paciente.getFecha()));// estos campos se agregaron manualmente
           form.genero.setValue(paciente.getGenero());
           form.direccion.setValue(paciente.getDireccion());
           form.telefono.setValue(paciente.getTelefono());
           form.responsable.setValue(paciente.getResponsable());
           
           
           form.setVisible(true);
            addClassName("editing");
        }
    }
	
	
	private HorizontalLayout getToolbar() {
        filterText.setPlaceholder("Filtrar por nombre...");
        filterText.setClearButtonVisible(true);
        filterText.setValueChangeMode(ValueChangeMode.LAZY); 

        Button addPacienteButton = new Button("Agregar Paciente");
        addPacienteButton.addClickListener(click -> addPaciente());
        var toolbar = new HorizontalLayout(filterText, addPacienteButton); 
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

	@Override
	public void mostrarPacientesEnGrid(List<Paciente> items) {
		Collection<Paciente> itemsCollections=items;
		grid.setItems(itemsCollections);
		setElementos(items);
	}

	@Override
	public void beforeEnter(BeforeEnterEvent event) {
		// TODO Auto-generated method stub
		
	}

	public List<Paciente> getElementos() {
		return elementos;
	}

	public void setElementos(List<Paciente> elementos) {
		this.elementos = elementos;
	}

	@Override
	public void mostrarMensaje(String string) {
		Notification.show(string);
		// TODO Auto-generated method stub
		
	}

	public static void nuevoPaciente(Paciente paciente) {
		try {
    			 		
	    	controlador.crearPacientes(paciente);
	    		
	    	} catch (Exception ex) {
	            
	            ex.printStackTrace(); 
	            
	            Notification.show("Error al guardar el paciente: " + ex.getMessage(), 3000, Notification.Position.TOP_CENTER);
	        }
		
		
		
	}

	
}
	


