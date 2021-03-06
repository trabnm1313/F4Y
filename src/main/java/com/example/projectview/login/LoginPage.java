package com.example.projectview.login;

import com.example.projectview.view.main.MainView;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.avatar.Avatar;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.dependency.StyleSheet;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.notification.NotificationVariant;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteParameters;
import com.vaadin.flow.router.RouterLink;
import org.springframework.http.MediaType;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

// Import font Prompt
@StyleSheet("https://fonts.googleapis.com/css2?family=Prompt")
// Import a style sheet into the global scope
@CssImport(value = "index.css")
// Import a style sheet into the local scope of the TextField component
@CssImport(value = "components/textfield.css", themeFor = "vaadin-text-field")
// Import a style sheet into the local scope of the TextField onFocus component
@CssImport(value = "components/textfield.css", themeFor = "vaadin-text-field[focus]")

@Route("")
public class LoginPage extends VerticalLayout {
    public LoginPage() {
        TextField usernameField = new TextField();
        usernameField.setWidth("600px");
        usernameField.setLabel("Username");
        usernameField.setPlaceholder("Please enter your username.");
        usernameField.addClassName("textField");
        usernameField.addClassName("font");

        PasswordField passwordField = new PasswordField();
        passwordField.setWidth("600px");
        passwordField.setLabel("Password");
        passwordField.setPlaceholder("Please enter your password.");
        passwordField.addClassName("textField");
        passwordField.addClassName("font");
        passwordField.addClassName("rightLayout");

        Avatar a1 = new Avatar();
        a1.addClassName("div");
        a1.setHeight("600px");
        a1.setWidth("600px");

        Button loginButton = new Button("Log In");
        loginButton.addClassName("b1");
        loginButton.addClassName("font");

        Button registerButton = new Button("Register");
        registerButton.addClassName("b2");
        registerButton.addClassName("font");

        VerticalLayout v1 = new VerticalLayout();
        VerticalLayout v2 = new VerticalLayout();

        HorizontalLayout h1 = new HorizontalLayout();

        FormLayout f1 = new FormLayout();

        h1.add(loginButton, registerButton);
        v1.add(a1);
        v2.add(usernameField, passwordField, h1);
        v1.setAlignItems(Alignment.CENTER);
        v2.setAlignItems(Alignment.CENTER);
        f1.add(v1, v2);
        this.setPadding(true);

        this.add(f1);

        /*------------------Event Handler------------------*/
        registerButton.addClickListener(event -> {
            UI.getCurrent().navigate("register");
        });

        loginButton.addClickListener(event -> {
            String username = usernameField.getValue();
            String password = passwordField.getValue();

            MultiValueMap<String, String> formData = new LinkedMultiValueMap<>();
            formData.add("username", username);
            formData.add("password", password);

            String id = WebClient.create()
                    .post()
                    .uri("http://localhost:9091/login")
                    .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                    .body(BodyInserters.fromFormData(formData))
                    .retrieve()
                    .bodyToMono(String.class)
                    .block();

            if (id == null) {
                Notification noti1 = new Notification("Username or Password invalid");
                noti1.addThemeVariants(NotificationVariant.LUMO_ERROR);
                noti1.open();
                noti1.setDuration(3000);

                return;
            }

            UI.getCurrent().navigate(MainView.class,
                    new RouteParameters("userID", id));
        });
    }
}
