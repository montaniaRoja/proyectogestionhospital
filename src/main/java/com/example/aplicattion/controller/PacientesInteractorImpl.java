package com.example.aplicattion.controller;

import java.io.IOException;

import com.example.application.model.DatabaseRepositoryImpl;
import com.example.application.views.PacientesView;

public class PacientesInteractorImpl implements PacientesInteractor{
	
	
	private DatabaseRepositoryImpl modelo;
	private PacientesView vista;
	
	
	public PacientesInteractorImpl(PacientesView view) {
		
		super();
		this.vista=view;
		this.modelo= DatabaseRepositoryImpl.getInstance("https://apex.oracle.com",30000L);
		
		
	}
	
	@Override
	public void consultarPacientes() {
		// TODO Auto-generated method stub
		
		
	}
	
	

}
