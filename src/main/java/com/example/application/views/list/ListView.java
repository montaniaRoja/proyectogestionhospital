package com.example.application.views.list;

import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.lumo.LumoUtility.Margin;
import com.example.application.views.*;

@PageTitle("Hospital || CRM")
@Route(value="", layout = MainLayout.class)
public class ListView extends VerticalLayout {
	
	
	
    public ListView() {
        setSpacing(false);

        Image img = new Image("images/hospital.png", "logo hospital");
        img.setWidth("200px");
        add(img);

        H2 header = new H2("C R M");
        header.addClassNames(Margin.Top.XLARGE, Margin.Bottom.MEDIUM);
        add(header);
        add(new Paragraph("Sistema de Gestion de Hospital"));

        setSizeFull();
        setJustifyContentMode(JustifyContentMode.CENTER);
        setDefaultHorizontalComponentAlignment(Alignment.CENTER);
        getStyle().set("text-align", "center");
        
        
    }

	

	

}
