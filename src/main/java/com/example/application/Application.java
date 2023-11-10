package com.example.application;

import com.example.application.data.services.Conexion;
import com.vaadin.flow.component.page.AppShellConfigurator;
import com.vaadin.flow.theme.Theme;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * The entry point of the Spring Boot application.
 *
 * Use the @PWA annotation make the application installable on phones, tablets
 * and some desktop browsers.
 *
 */
@SpringBootApplication
@Theme(value = "flowcrmtutorial")
public class Application implements AppShellConfigurator {

    public static void main(String[] args) {
    	
    	//Conexion conexion=new Conexion();
    	System.out.println("conexion status "+Conexion.probarConexion());
        SpringApplication.run(Application.class, args);
    }

}
