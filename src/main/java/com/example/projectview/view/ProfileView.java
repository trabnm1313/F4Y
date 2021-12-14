package com.example.projectview.view;

import com.vaadin.flow.component.avatar.Avatar;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.dependency.StyleSheet;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

// Import font Prompt
@StyleSheet("https://fonts.googleapis.com/css2?family=Prompt")
// Import a style sheet
@CssImport(value = "mainView.css")

@Route("profile")
public class ProfileView extends VerticalLayout {
    HorizontalLayout h1 = new HorizontalLayout();
    VerticalLayout v2 = new VerticalLayout();
    VerticalLayout v1 = new VerticalLayout();

    HorizontalLayout ho1 = new HorizontalLayout();
    VerticalLayout vi1 = new VerticalLayout();
    VerticalLayout vi2 = new VerticalLayout();
    VerticalLayout vi21 = new VerticalLayout();

    Button btn1, btn2, btn3, btnEdit;

    public ProfileView() {

        Avatar avatarName = new Avatar("Viu");
        avatarName.setHeight("300px");
        avatarName.setWidth("300px");

        Label name = new Label("Viu");
        Label des = new Label("FolkYou Everyone");

//        TextArea textArea = new TextArea();
//        textArea.getStyle().set("color", "white");
//        textArea.setWidthFull();
//        textArea.setLabel("Description");
//        textArea.setValue("FolkYou Everyone");
//        add(textArea);

        v1.getStyle().set("padding-top", "30%");

        h1.getStyle().set("padding-left", "30%");
        h1.getStyle().set("padding-right", "20%");

        vi2.getStyle().set("padding-left", "10%");
        vi2.getStyle().set("padding-right", "10%");

        vi21.setHeight("200px");
        vi21.getStyle().set("background-color", "#064663");
        vi21.getStyle().set("border-radius", "10px");

        vi2.setWidth("100%");
        vi2.getElement().getStyle().set("flex-grow", "1");

        btn1 = new Button("Like");
        btn1.getStyle().set("background-color", "#ECB365");
        btn1.getStyle().set("color", "black");
        btn2 = new Button("Comment");
        btn2.getStyle().set("background-color", "#ECB365");
        btn2.getStyle().set("color", "black");
        btn3 = new Button("Chat");
        btn3.getStyle().set("background-color", "#ECB365");
        btn3.getStyle().set("color", "black");

        btnEdit = new Button("แก้ไข");
        btnEdit.getStyle().set("background-color", "#ECB365");
        btnEdit.getStyle().set("color", "black");

        v1.add(name, des);
        v2.add(avatarName, btnEdit);
        h1.add(v2, v1);
        ho1.add(btn1, btn2, btn3);
        vi2.add(vi21, ho1);

        add(h1, vi2);
    }
}
