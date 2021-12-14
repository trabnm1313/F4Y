package com.example.projectview.view;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.dependency.StyleSheet;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.polymertemplate.Id;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.Theme;

// Import font Prompt
@StyleSheet("https://fonts.googleapis.com/css2?family=Prompt")
// Import a style sheet
@CssImport(value = "mainView.css")


@Route("main")
//@Theme(themeFolder = "my-theme")
public class MainView extends HorizontalLayout {
    VerticalLayout v1 = new VerticalLayout();
    VerticalLayout v2 = new VerticalLayout();
    VerticalLayout v21 = new VerticalLayout();

    VerticalLayout v3 = new VerticalLayout();
    HorizontalLayout h1 = new HorizontalLayout();

    Button btn1, btn2, btn3;
    TextField t1 = new TextField("Test");

    public MainView() {

        Label l1 = new Label("Menu1");
        l1.addClassName("font");
        Label l2 = new Label("Menu2");
        l2.addClassName("font");
        Label l3 = new Label("Menu3");
        l3.addClassName("font");
        Label l4 = new Label("Menu4");
        l4.addClassName("font");
        Label l5 = new Label("Menu5");
        l5.addClassName("font");

        v1.setWidth("20%");
        v1.setHeight("100%");
        v1.setMargin(true);
        v1.getStyle().set("background-color", "#064663");
        v1.getElement().getStyle().set("flex-grow", "1");
        v1.getStyle().set("border-radius", "10px");

        v21.setHeight("300px");
        v21.getStyle().set("background-color", "#064663");
        v21.getStyle().set("border-radius", "10px");

        v2.setWidth("60%");
        v2.getElement().getStyle().set("flex-grow", "1");
        v2.getStyle().set("padding-right", "2%");

        btn1 = new Button("Like");
        btn1.getStyle().set("background-color", "#ECB365");
        btn1.getStyle().set("color", "black");
        btn2 = new Button("Comment");
        btn2.getStyle().set("background-color", "#ECB365");
        btn2.getStyle().set("color", "black");
        btn3 = new Button("Chat");
        btn3.getStyle().set("background-color", "#ECB365");
        btn3.getStyle().set("color", "black");

        v3.setWidth("20%");
        v3.setHeight("100%");
        v3.setMargin(true);
        v3.getStyle().set("background-color", "#064663");
        v3.getElement().getStyle().set("flex-grow", "1");
        v3.getStyle().set("border-radius", "10px");

        Span formatSpan1 = new Span("Format");
        formatSpan1.setWidthFull();
        formatSpan1.getStyle().set("text-align", "center");
        formatSpan1.getStyle().set("background-color", "#ECB365");

        Span formatSpan3 = new Span("Format");
        formatSpan3.setWidthFull();
        formatSpan3.getStyle().set("text-align", "center");
        formatSpan3.getStyle().set("background-color", "#ECB365");

        v1.add(formatSpan1, l1, l2, l3, l4, l5);
        h1.add(btn1, btn2, btn3);
        v2.add(v21, h1);
        v3.add(formatSpan3);

        add(v1, v2, v3);


    }
}
