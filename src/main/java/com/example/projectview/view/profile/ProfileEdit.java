package com.example.projectview.view.profile;

import com.example.projectview.chat.User;
import com.example.projectview.login.LoginPage;
import com.vaadin.flow.component.avatar.Avatar;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.dependency.StyleSheet;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.notification.NotificationVariant;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.router.BeforeEnterObserver;
import com.vaadin.flow.router.Route;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

// Import font Prompt
@StyleSheet("https://fonts.googleapis.com/css2?family=Prompt")
// Import a style sheet
@CssImport(value = "profile.css")
@CssImport(value = "components/textfield.css", themeFor = "vaadin-text-field")
@CssImport(value = "components/textfield.css", themeFor = "vaadin-text-field[focus]")
@CssImport(value = "components/textArea.css", themeFor = "vaadin-text-area")
@CssImport(value = "components/textArea.css", themeFor = "vaadin-text-area[focus]")

@Route("edit-profile/:userID")
public class ProfileEdit extends VerticalLayout implements BeforeEnterObserver {

    HorizontalLayout hProfile = new HorizontalLayout(); // all profile
    TextField nickname, username;
    TextArea description;
    PasswordField password, confirmPassword;
    User nowUser;

    public ProfileEdit() {
        getStyle().set("padding-top", "5%");

        VerticalLayout vAvatarAndSaveBtn = new VerticalLayout(); // all detail can edit
        HorizontalLayout vFieldPassword = new HorizontalLayout(); // field password and confirm password

        /*---------- Profile -------------*/
        hProfile.getStyle().set("padding-left", "25%");
        hProfile.getStyle().set("padding-right", "20%");

        // AVATAR AND SAVE BUTTON
        VerticalLayout vDetailEdit = new VerticalLayout(); // avatar and Save button
        Avatar avatarName = new Avatar("Viu");
        avatarName.getStyle().set("background-color", "#ECB365");
        avatarName.setHeight("300px");
        avatarName.setWidth("300px");

        vAvatarAndSaveBtn.add(avatarName);

        // EDIT DETAIL
        nickname = new TextField("Nickname");
        nickname.setClassName("font");

        description = new TextArea("Description");
        description.setMaxLength(100);
        description.setClassName("font");
        description.setWidth("100%");

        username = new TextField("Username");
        username.addClassName("font");

        password = new PasswordField("Password");
        password.addClassName("font");

        confirmPassword = new PasswordField("Confirm Password");
        confirmPassword.addClassName("font");

        Button btnConfirm = new Button("Save");
        btnConfirm.getStyle().set("background-color", "#ECB365");
        btnConfirm.getStyle().set("color", "black");
        btnConfirm.addClassName("font");

        btnConfirm.addClickListener(E -> {
            User newUserInfo = new User(nowUser.get_id(), username.getValue(), password.getValue(), nickname.getValue(), description.getValue());
            WebClient.create()
                    .put()
                    .uri("http://localhost:9091/updateUser")
                    .body(Mono.just(newUserInfo), User.class)
                    .retrieve()
                    .bodyToMono(User.class)
                    .block();
        });

        vFieldPassword.add(password, confirmPassword);
        vDetailEdit.add(nickname, description, username, vFieldPassword, btnConfirm);

        hProfile.add(vAvatarAndSaveBtn, vDetailEdit);
        add(hProfile);
    }

    @Override
    public void beforeEnter(BeforeEnterEvent beforeEnterEvent) {
        String userID = beforeEnterEvent.getRouteParameters().get("userID").get();

        try {
            User user = WebClient.create()
                    .get()
                    .uri("http://localhost:9090/getUser/byID/" + userID)
                    .retrieve()
                    .bodyToMono(User.class)
                    .block();

            this.nowUser = user;

            username.setValue(nowUser.getUsername());
            password.setValue(nowUser.getPassword());
            confirmPassword.setValue(nowUser.getPassword());
            nickname.setValue(nowUser.getNickname());
            description.setValue(nowUser.getDescription());

        } catch (Exception error) {
            Notification noti1 = new Notification("Please Login");
            noti1.addThemeVariants(NotificationVariant.LUMO_ERROR);
            noti1.open();
            noti1.setDuration(3000);
            System.out.println("WHY");
            beforeEnterEvent.rerouteTo(LoginPage.class);
        }
    }
}
