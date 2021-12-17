package com.example.projectview.view.profile;

import com.vaadin.flow.component.avatar.Avatar;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.dependency.StyleSheet;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

// Import font Prompt
@StyleSheet("https://fonts.googleapis.com/css2?family=Prompt")
// Import a style sheet
@CssImport(value = "profile.css")
@CssImport(value = "components/textfield.css", themeFor = "vaadin-text-field")
@CssImport(value = "components/textfield.css", themeFor = "vaadin-text-field[focus]")
@CssImport(value = "components/textArea.css", themeFor = "vaadin-text-area")
@CssImport(value = "components/textArea.css", themeFor = "vaadin-text-area[focus]")

@Route("view-profile")
public class ProfileView extends VerticalLayout {
    HorizontalLayout hProfile = new HorizontalLayout(); // all profile
    VerticalLayout vPost = new VerticalLayout();

    public ProfileView() {
        // Profile
        hProfile.getStyle().set("padding-left", "30%");
        hProfile.getStyle().set("padding-right", "20%");
        VerticalLayout vDetailProfile = new VerticalLayout();
        vDetailProfile.getStyle().set("padding-top", "20%");
        VerticalLayout vAvatar = new VerticalLayout();

        Avatar avatarName = new Avatar("Viu");
        avatarName.getStyle().set("background-color", "#ECB365");
        avatarName.setHeight("300px");
        avatarName.setWidth("300px");

        Label nickname = new Label("Viu");
        nickname.setClassName("font");
        Label description = new Label("FolkYou");
        description.setClassName("font");

        vAvatar.add(avatarName);
        vDetailProfile.add(nickname, description);
        hProfile.add(vAvatar, vDetailProfile);

        // Post
        vPost.getStyle().set("padding-left", "30%");
        vPost.setWidth("70%");
        vPost.getElement().getStyle().set("flex-grow", "1");

        add(hProfile, vPost);
    }

    private void createPost(String topic, String message, String tag) {

        VerticalLayout vPostLayout = new VerticalLayout();
        vPostLayout.getStyle()
                .set("background-color", "#064663")
                .set("border-radius", "10px");

        Label topicPost = new Label(topic);
        topicPost.getStyle().set("font-size", "25px");

        Label tagPost = new Label('#'+tag);

        Span description = new Span(message);
        description.setWidth("100%");
        description.getStyle()
                .set("overflow", "hidden")
                .set("text-overflow", "ellipsis");

        Button likeBtn = new Button("Like", new Icon(VaadinIcon.HEART));
        likeBtn.getStyle()
                .set("background-color", "#ECB365")
                .set("color", "black");
        likeBtn.setIconAfterText(true);

        Button commentBtn = new Button("Comment", new Icon(VaadinIcon.COMMENT_O));
        commentBtn.getStyle()
                .set("background-color", "#ECB365")
                .set("color", "black");
        commentBtn.setIconAfterText(true);

        Button chatBtn = new Button("Chat", new Icon(VaadinIcon.CHAT));
        chatBtn.getStyle()
                .set("background-color", "#ECB365")
                .set("color", "black");
        chatBtn.setIconAfterText(true);

        HorizontalLayout hButtonPost = new HorizontalLayout(); // add button for post
        HorizontalLayout vUserPost = new HorizontalLayout(); // add user post
        VerticalLayout vDetailPost = new VerticalLayout(); // add detail post
        VerticalLayout vOnePost = new VerticalLayout(); // add all detail in one post

        Avatar user = new Avatar();
        user.setWidth("50px");
        user.setHeight("50px");
        user.getStyle().set("background-color", "#ECB365");

        Label nameUser = new Label();
        nameUser.setWidth("80px");
        nameUser.getStyle()
                .set("text-align", "center")
                .set("margin-top", "10%");

        vUserPost.add(user, nameUser); //add detail user

        hButtonPost.add(likeBtn, commentBtn, chatBtn); // add button
        vDetailPost.add(topicPost, tagPost, description); // add detail post
        vPostLayout.add(vDetailPost, vUserPost); // add detail post and user
        vOnePost.add(vPostLayout, hButtonPost); // add all detail
        vPost.add(vOnePost);
    }
}
