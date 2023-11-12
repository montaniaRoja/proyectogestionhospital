package com.example.application.views;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.BeforeEvent;
import com.vaadin.flow.router.HasUrlParameter;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import java.util.List;

import com.example.application.data.*;


@Route(value = "historial", layout = MainLayout.class)
@PageTitle("Historial | Hospital CRM")
public class HistorialView  extends VerticalLayout implements HasUrlParameter<String>{
	
	Grid<Historial> grid = new Grid<>(Historial.class);
		
    TextField filterText = new TextField();
    HistorialForm form;

    public HistorialView() {
    	
    	//String dni = paciente.getDni();
    	recuperarDni();
        addClassName("list-view"); 
        setSizeFull();
        configureGrid(); 
        configureForm();

       add(getContent()); 

        
    }

    private void recuperarDni() {
    	
    	  // Instancia válida de Paciente
    	     // Obtener el DNI del paciente
    	
    	System.out.println();
		//form.dniPaciente.setValue(dni);
		
	}

	private void configureForm() {
    	form = new HistorialForm(); 
        form.setWidth("25em");
		// TODO Auto-generated method stub
		
	}
   
	private void configureGrid() {
        grid.addClassNames("historial-grid"); 
        grid.setSizeFull();
        grid.setColumns("fecha_cita", "motivo_cita", "diagnostico","proxima_cita"); 
        
        grid.getColumns().forEach(col -> col.setAutoWidth(true)); 
    }

    
	  
    
    private Component getContent() {
        HorizontalLayout content = new HorizontalLayout(grid, form );
         
        content.setFlexGrow(1, form);
        content.setFlexGrow(2, grid);
        content.addClassNames("content");
        content.setSizeFull();
        return content;
    }
    
    @Override
    public void setParameter(BeforeEvent event, String parameter) {
       
        form.dniPaciente.setValue(parameter);
        String dni=form.dniPaciente.getValue().toString();
        List<Historial> historial = new HistorialRepositorio(dni).consultaHistorial();
        grid.setItems(historial);
    }

    
}
	


