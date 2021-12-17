package com.example.projectview.view.profile;

import com.vaadin.flow.component.avatar.Avatar;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.dependency.StyleSheet;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

// Import font Prompt
@StyleSheet("https://fonts.googleapis.com/css2?family=Prompt")
// Import a style sheet
@CssImport(value = "profile.css")
@CssImport(value = "components/textfield.css", themeFor = "vaadin-text-field")
@CssImport(value = "components/textfield.css", themeFor = "vaadin-text-field[focus]")
@CssImport(value = "components/textArea.css", themeFor = "vaadin-text-area")
@CssImport(value = "components/textArea.css", themeFor = "vaadin-text-area[focus]")

@Route("edit-profile")
public class ProfileEdit extends VerticalLayout{

    HorizontalLayout hProfile = new HorizontalLayout(); // all profile

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
        TextField nickname = new TextField("Nickname");
        nickname.setClassName("font");

        TextArea description = new TextArea("Description");
        description.setMaxLength(100);
        description.setClassName("font");
        description.setWidth("100%");

        TextField username = new TextField("Username");
        username.addClassName("font");

        PasswordField password = new PasswordField("Password");
        password.addClassName("font");

        PasswordField confirmPassword = new PasswordField("Confirm Password");
        confirmPassword.addClassName("font");

        Button btnConfirm = new Button("Save");
        btnConfirm.getStyle().set("background-color", "#ECB365");
        btnConfirm.getStyle().set("color", "black");
        btnConfirm.addClassName("font");


        vFieldPassword.add(password, confirmPassword);
        vDetailEdit.add(nickname, description, username, vFieldPassword, btnConfirm);

        hProfile.add(vAvatarAndSaveBtn, vDetailEdit);
        add(hProfile);
    }
}
