package com.example.project.register;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.avatar.Avatar;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.dependency.StyleSheet;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

// Import font Prompt
@StyleSheet("https://fonts.googleapis.com/css2?family=Prompt")
// Import a style sheet into the global scope
@CssImport(value = "index.css")
// Import a style sheet into the local scope of the TextField component
@CssImport(value = "textfield.css", themeFor = "vaadin-text-field")
// Import a style sheet into the local scope of the TextField onFocus component
@CssImport(value = "textfield.css", themeFor = "vaadin-text-field[focus]")
// Import a style sheet into the local scope of the TextField component
@CssImport(value = "textArea.css", themeFor = "vaadin-text-area")
// Import a style sheet into the local scope of the TextField onFocus component
@CssImport(value = "textArea.css", themeFor = "vaadin-text-area[focus]")

@Route("/register")
public class RegisterPage extends VerticalLayout {
    public RegisterPage() {
        TextField usernameField = new TextField();
        usernameField.setWidth("600px");
        usernameField.setLabel("New Username");
        usernameField.setPlaceholder("Create your username.");
        usernameField.addClassName("textField");
        usernameField.addClassName("font");

        PasswordField passwordField = new PasswordField();
        passwordField.setWidth("600px");
        passwordField.setLabel("Create New Password");
        passwordField.setPlaceholder("Please enter your password.");
        passwordField.addClassName("textField");
        passwordField.addClassName("font");
        passwordField.addClassName("rightLayout");

        PasswordField confirmPasswordField = new PasswordField();
        confirmPasswordField.setWidth("600px");
        confirmPasswordField.setLabel("Confirm Password");
        confirmPasswordField.setPlaceholder("Please re-enter your password.");
        confirmPasswordField.addClassName("textField");
        confirmPasswordField.addClassName("font");
        confirmPasswordField.addClassName("rightLayout");

        TextField nameField = new TextField();
        nameField.setWidth("600px");
        nameField.setLabel("Nickname");
        nameField.setPlaceholder("Please enter your Nickname.");
        nameField.addClassName("textField");
        nameField.addClassName("font");

        TextArea descriptionField = new TextArea();
        descriptionField.setMaxLength(500);
        descriptionField.setWidth("600px");
        descriptionField.setLabel("Tell about yourself");
        descriptionField.setPlaceholder("Describe about yourself.");
        descriptionField.addClassName("textField");
        descriptionField.addClassName("font");

        Avatar a1 = new Avatar();
        a1.addClassName("div");
        a1.setHeight("600px");
        a1.setWidth("600px");

        Button uploadButton = new Button("Upload");
        uploadButton.addClassName("b2");
        uploadButton.addClassName("font");

        Button registerButton = new Button("Register");
        registerButton.addClassName("b1");
        registerButton.addClassName("font");

        VerticalLayout v1 = new VerticalLayout();
        VerticalLayout v2 = new VerticalLayout();
        v1.setPadding(true);

        FormLayout f1 = new FormLayout();

        v1.add(a1, uploadButton);
        v2.add(usernameField, passwordField, confirmPasswordField, nameField, descriptionField, registerButton);
        v1.setAlignItems(Alignment.CENTER);
        v2.setAlignItems(Alignment.CENTER);
        f1.add(v1, v2);
        this.setPadding(true);

        this.add(f1);

        registerButton.addClickListener(event -> {
            UI.getCurrent().navigate("login");
        });
    }
}
