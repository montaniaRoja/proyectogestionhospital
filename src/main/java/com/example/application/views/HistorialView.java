package com.example.application.views;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.internal.ComponentTracker.Location;
import com.vaadin.flow.component.map.Map;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.router.BeforeEnterObserver;
import com.vaadin.flow.router.BeforeEvent;
import com.vaadin.flow.router.HasUrlParameter;
import com.vaadin.flow.router.OptionalParameter;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.QueryParameters;
import com.vaadin.flow.router.Route;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.example.aplicattion.controller.HistorialInteractor;
import com.example.aplicattion.controller.HistorialInteractorImpl;
import com.example.application.data.*;


@Route(value = "historial", layout = MainLayout.class)
@PageTitle("Historial | Hospital CRM")
public class HistorialView  extends VerticalLayout implements HasUrlParameter<String>, HistorialViewModel, BeforeEnterObserver {
	
	Grid<Historial> grid = new Grid<>(Historial.class);
		
    TextField filterText = new TextField();
    HistorialForm form;
   
    
    private static HistorialInteractor controlador;
    private List<Historial> elementos;
    
    
    public HistorialView() {
    	
    	//String dni = paciente.getDni();
    	//recuperarDni(null, null);
        addClassName("list-view"); 
        setSizeFull();
        configureGrid(); 
        configureForm();

        controlador=new HistorialInteractorImpl(this);
        
        this.setElementos(new ArrayList<>());
        
       add(getContent()); 

       controlador.consultarHistorial();
       
       closeEditor();
    }

    private void closeEditor() {
    	form.setHistorial(null);
        form.setVisible(true);
        removeClassName("editing");
		
	}
    /*
    private void addHistorial() { 
        //grid.asSingleSelect().clear();
        
        form.setVisible(true);
        editHistorial(new Historial());
    }
    */
	private void setElementos(ArrayList arrayList) {
		// TODO Auto-generated method stub
		
	}
	
	
	public void recuperarDni(BeforeEvent event,
	        @OptionalParameter String parameter) {

	    com.vaadin.flow.router.Location location = event.getLocation();
	    QueryParameters queryParameters = location.getQueryParameters();

	    java.util.Map<String, List<String>> parametersMap = queryParameters.getParameters();
	    
	    System.out.println(parametersMap);
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
	
	public void editHistorial(Historial historial) { 
        if (historial == null) {
            closeEditor();
        } else {
          
           
           form.setVisible(true);
            addClassName("editing");
        }
    }
    
	  
    
    private Component getContent() {
        HorizontalLayout content = new HorizontalLayout(grid, form );
         
        content.setFlexGrow(1, form);
        content.setFlexGrow(2, grid);
        content.addClassNames("content");
        content.setSizeFull();
        return content;
    }
    
    
    
    /*
    @Override
    public void setParameter(BeforeEvent event, String parameter) {
    	String dni=form.dniPaciente.getValue().toString();
         List<Historial> historial = new HistorialRepositorio(dni).consultaHistorial();
        grid.setItems(historial);
       form.dniPaciente.setValue(parameter);
          
    }
    
    */
    
    @Override
	public void mostrarHistorialEnGrid(List<Historial> items) {
		Collection<Historial> itemsCollections=items;
		grid.setItems(itemsCollections);
		setElementos(items);
	}


	@Override
	public void beforeEnter(BeforeEnterEvent event) {
		// TODO Auto-generated method stub
		
	}
	
	public List<Historial> getElementos() {
		return elementos;
	}
    
	
	public void setElementos(List<Historial> elementos) {
		this.elementos = elementos;
	}
	
	@Override
	public void mostrarMensaje(String string) {
		Notification.show(string);
		// TODO Auto-generated method stub
		
	}
	
	
	public static void nuevoHistorial(Historial historial) {
		try {
    			 		
	    	controlador.crearHistorial(historial);
	    		
	    	} catch (Exception ex) {
	            
	            ex.printStackTrace(); 
	            
	            Notification.show("Error al guardar el historial: " + ex.getMessage(), 3000, Notification.Position.TOP_CENTER);
	        }
		
		
		
	}

	@Override
	public void setParameter(BeforeEvent event, String parameter) {
		// TODO Auto-generated method stub
		
	}
	
	
}
	


