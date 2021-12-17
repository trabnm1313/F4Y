package com.example.projectview.view.profile;

import com.example.projectview.chat.ChatPage;
import com.example.projectview.login.LoginPage;
import com.example.projectview.model.Thread;
import com.example.projectview.model.User;
import com.example.projectview.post.ViewPost;
import com.example.projectview.view.main.MainView;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.avatar.Avatar;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.dependency.StyleSheet;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.notification.NotificationVariant;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.*;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Import font Prompt
@StyleSheet("https://fonts.googleapis.com/css2?family=Prompt")
// Import a style sheet
@CssImport(value = "profile.css")
@CssImport(value = "components/textfield.css", themeFor = "vaadin-text-field")
@CssImport(value = "components/textfield.css", themeFor = "vaadin-text-field[focus]")
@CssImport(value = "components/textArea.css", themeFor = "vaadin-text-area")
@CssImport(value = "components/textArea.css", themeFor = "vaadin-text-area[focus]")

@Route("view-profile/:userID")
public class ProfileView extends VerticalLayout implements BeforeEnterObserver {
    HorizontalLayout hProfile = new HorizontalLayout(); // all profile
    VerticalLayout vPost = new VerticalLayout();

    String userID;
    User nowUser;
    private List<Thread> threads;

    public ProfileView() {}

    public void creat() {
        vPost.setMaxHeight("500px");
        vPost.getStyle().set("overflow", "auto");
        VerticalLayout vDetailProfile = new VerticalLayout();
        vDetailProfile.getStyle().set("padding-top", "20%");
        VerticalLayout vAvatar = new VerticalLayout();

        Avatar avatarName = new Avatar(nowUser.getNickname());
        avatarName.getStyle().set("background-color", "#ECB365");
        avatarName.setHeight("300px");
        avatarName.setWidth("300px");

        Label nickname = new Label(nowUser.getNickname());
        nickname.setClassName("font");
        Label description = new Label(nowUser.getDescription());
        description.setClassName("font");

        vAvatar.add(avatarName);
        vDetailProfile.add(nickname, description);
        hProfile.add(vAvatar, vDetailProfile);

        // Post
        vPost.setWidth("80%");
        vPost.getElement().getStyle().set("flex-grow", "1");

        add(hProfile, vPost);
        setAlignItems(Alignment.CENTER);
    }

    private void createPost(Thread post) {
        VerticalLayout vPostLayout = new VerticalLayout();
        vPostLayout.getStyle()
                .set("background-color", "#064663")
                .set("border-radius", "10px");

        Label topicPost = new Label(post.getTopic());
        topicPost.getStyle().set("font-size", "25px");

        Label tagPost = new Label('#'+post.getTag());

        Span description = new Span(post.getMessage());
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

        chatBtn.addClickListener(event -> {
            UI.getCurrent().navigate(ChatPage.class,
                    new RouteParameters(
                            new RouteParam("threadID", post.get_id()),
                            new RouteParam("userID", nowUser.get_id())));
        });

        commentBtn.addClickListener(event -> {
            UI.getCurrent().navigate(ViewPost.class,
                    new RouteParameters(
                            new RouteParam("threadID", post.get_id()),
                            new RouteParam("userID", nowUser.get_id())));
        });

        likeBtn.addClickListener(event -> {
            String res = WebClient.create()
                    .get()
                    .uri("http://localhost:9090/likeThread/" + post.get_id())
                    .retrieve()
                    .bodyToMono(String.class)
                    .block();

        });
    }

    public void beforeEnter(BeforeEnterEvent beforeEnterEvent) {
        userID = beforeEnterEvent.getRouteParameters().get("userID").get();

        try {
            User user = WebClient.create()
                    .get()
                    .uri("http://localhost:9090/getUser/byID/" + userID)
                    .retrieve()
                    .bodyToMono(User.class)
                    .block();

            this.nowUser = user;
            creat();

            System.out.println("Fetch Profile data");
            JsonNode out = WebClient.create()
                    .get()
                    .uri("http://localhost:9090/getThreads")
                    .retrieve()
                    .bodyToMono(JsonNode.class)
                    .block();

            ObjectMapper mapper = new ObjectMapper();
            this.threads = mapper.convertValue(
                    out,
                    new TypeReference<List<Thread>>() {}
            );
            Collections.reverse(this.threads);

            List<Thread> filtered = new ArrayList<>();

            for (int i=0; i<threads.size(); i++) {
                if (threads.get(i).getOwnerID().equals(nowUser.get_id())) {
                    filtered.add(threads.get(i));
                }
            }

            System.out.println(filtered);

            for (int i=0; i<filtered.size(); i++) {
                createPost(filtered.get(i));
            }

        } catch (Exception error) {
            Notification noti1 = new Notification("Profile Not Found");
            noti1.addThemeVariants(NotificationVariant.LUMO_ERROR);
            noti1.open();
            noti1.setDuration(3000);
            beforeEnterEvent.rerouteTo(MainView.class, new RouteParameters("userID", nowUser.get_id()));
        }
    }
}
