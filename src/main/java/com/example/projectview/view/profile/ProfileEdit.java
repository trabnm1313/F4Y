package com.example.projectview.view.profile;

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
@CssImport(value = "profile.css")
// Import a style sheet into the local scope of the TextField component
@CssImport(value = "textfield.css", themeFor = "vaadin-text-field")
// Import a style sheet into the local scope of the TextField onFocus component
@CssImport(value = "textfield.css", themeFor = "vaadin-text-field[focus]")
// Import a style sheet into the local scope of the TextField component
@CssImport(value = "textArea.css", themeFor = "vaadin-text-area")
// Import a style sheet into the local scope of the TextField onFocus component
@CssImport(value = "textArea.css", themeFor = "vaadin-text-area[focus]")

@Route("edit-profile/:userID")
public class ProfileEdit extends VerticalLayout{

    HorizontalLayout h1 = new HorizontalLayout();
    VerticalLayout v2 = new VerticalLayout();
    VerticalLayout v1 = new VerticalLayout();

    HorizontalLayout ho1 = new HorizontalLayout();
    VerticalLayout vi1 = new VerticalLayout();
    VerticalLayout vi2 = new VerticalLayout();
    VerticalLayout vi21 = new VerticalLayout();

    Button btn1, btn2, btn3, btnEdit, btnConfirm;
    Boolean viewB = false;
    public ProfileEdit() {

        Avatar avatarName = new Avatar("Viu");
        avatarName.getStyle().set("background-color", "#ECB365");
        avatarName.setHeight("300px");
        avatarName.setWidth("300px");

        TextField name = new TextField("Name");
        TextArea des = new TextArea("Description");

        v1.getStyle().set("padding-top", "20%");

        h1.getStyle().set("padding-left", "30%");
        h1.getStyle().set("padding-right", "20%");

        vi2.getStyle().set("padding-left", "30%");

        vi21.setHeight("150px");
        vi21.getStyle().set("background-color", "#064663");
        vi21.getStyle().set("border-radius", "10px");

        vi2.setWidth("70%");
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


        btnConfirm = new Button("Confirm");
        btnConfirm.getStyle().set("background-color", "#ECB365");
        btnConfirm.getStyle().set("color", "black");

        v1.add(name, des);
        v2.add(avatarName, btnConfirm);
        h1.add(v2, v1);
        ho1.add(btn1, btn2, btn3);
        vi2.add(vi21, ho1);

        add(h1, vi2);
    }
}
