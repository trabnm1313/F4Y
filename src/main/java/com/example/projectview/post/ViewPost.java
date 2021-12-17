package com.example.projectview.post;

import com.example.projectview.pojo.Comment;
import com.example.projectview.pojo.Thread;
import com.example.projectview.login.LoginPage;
import com.example.projectview.pojo.User;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.dependency.StyleSheet;
import com.vaadin.flow.component.html.Footer;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.notification.NotificationVariant;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.router.BeforeEnterObserver;
import com.vaadin.flow.router.Route;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@StyleSheet("https://fonts.googleapis.com/css2?family=Prompt")
@CssImport(value = "mainView.css")
@Route("post/:threadID/:userID")
public class ViewPost extends HorizontalLayout implements BeforeEnterObserver {
    String tag = "ลากหัวคมๆ";
    Thread threadNow;
    User userNow;

    public ViewPost() {
    }

    public void addPost(){
        setSizeFull();
        setPadding(false);
        setSpacing(false);
        setAlignItems(Alignment.CENTER);

        VerticalLayout headerLayout = new VerticalLayout();
        headerLayout.addClassNames("header-Text-with-padding", "font");

        Label titleLabel = new Label();
        titleLabel.setText(threadNow.getTopic());
        titleLabel.setSizeFull();

        Label tagLabel = new Label();
        tagLabel.setText("#" + threadNow.getTag());
        tagLabel.addClassNames("font", "header-Text-Post");
        tagLabel.setSizeFull();

        VerticalLayout descriptionLayout = new VerticalLayout();
        descriptionLayout.addClassNames("description-with-padding", "font");
        descriptionLayout.setHeight("75%");

        Label descriptionLabel = new Label();
        descriptionLabel.setText(threadNow.getMessage());
        descriptionLabel.setSizeFull();

        descriptionLayout.add(descriptionLabel);

        List comments = WebClient.create()
                .get()
                .uri("http://localhost:9090/getComment/byThreadID/" + threadNow.get_id())
                .retrieve()
                .bodyToMono(List.class)
                .block();

        ObjectMapper objectMapper = new ObjectMapper();
        List<Comment> commentList = objectMapper.convertValue(comments, new TypeReference<List<Comment>>() {});

        TextField commentField = new TextField();
        commentField.setWidthFull();
        commentField.setPlaceholder("แสดงความคิดเห็น...");
        commentField.setClassName("font");

        Footer comment = new Footer();
        comment.setSizeFull();

        Button sendButton = new Button("Send");
        sendButton.addClassName("b1");
        sendButton.addClassName("font");

        VerticalLayout vPost = new VerticalLayout();
        vPost.setHeight("90%");
        vPost.setWidth("60%");
        vPost.setPadding(true);
        vPost.setSpacing(false);
        vPost.getStyle().set("margin-left", "5%");

        VerticalLayout vAllComment = new VerticalLayout();
        vAllComment.addClassName("comment-panel");
        vAllComment.setAlignItems(Alignment.CENTER);
        vAllComment.setHeight("80%");
        vAllComment.setWidth("40%");
        vAllComment.setPadding(true);
        vAllComment.setSpacing(true);

        VerticalLayout vTextComment = new VerticalLayout();
        vTextComment.getStyle().set("overflow", "auto");
        vTextComment.setHeight("600px");

        HorizontalLayout hSendComment = new HorizontalLayout();
        hSendComment.setWidth("80%");

        Button chatButton = new Button("Chat");
        chatButton.addClassName("b1");
        chatButton.addClassName("font");

        //Add comment
        for(Comment commentEntity : commentList){
            VerticalLayout chatBox = new VerticalLayout();

            //User
            Label userLabel = new Label(userNow.getNickname());
            userLabel.addClassName("font");

            //Message
            Label messageLabel = new Label(commentEntity.getMessage());
            messageLabel.addClassName("message");

            chatBox.add(userLabel, messageLabel);
            vTextComment.add(chatBox);
        }

        comment.add(commentField);
        hSendComment.add(comment, sendButton);
        headerLayout.add(titleLabel, tagLabel);
        vPost.add(headerLayout, descriptionLayout, chatButton);
        vAllComment.add(vTextComment, hSendComment);

        sendButton.addClickListener(E -> {
            Comment newComment = new Comment(null, threadNow.get_id(), userNow.get_id(), commentField.getValue(), false, new Date());
            if(commentField.getValue() != ""){
                WebClient.create().post().uri("http://localhost:9091/createComment").body(Mono.just(newComment), Comment.class).retrieve().bodyToMono(Comment.class).block();
                VerticalLayout chatBox = new VerticalLayout();

                //User
                Label userLabel = new Label(userNow.getNickname());
                userLabel.addClassName("font");

                //Message
                Label messageLabel = new Label(newComment.getMessage());
                messageLabel.addClassName("message");

                chatBox.add(userLabel, messageLabel);
                vTextComment.add(chatBox);
            }
            commentField.setValue("");
        });
        commentField.addKeyDownListener(E -> {
            if(E.getKey().getKeys().equals(Key.ENTER.getKeys())){
                Comment newComment = new Comment(null, threadNow.get_id(), userNow.get_id(), commentField.getValue(), false, new Date());
                if(commentField.getValue() != ""){
                    WebClient.create().post().uri("http://localhost:9091/createComment").body(Mono.just(newComment), Comment.class).retrieve().bodyToMono(Comment.class).block();
                    VerticalLayout chatBox = new VerticalLayout();

                    //User
                    Label userLabel = new Label(userNow.getNickname());
                    userLabel.addClassName("font");

                    //Message
                    Label messageLabel = new Label(newComment.getMessage());
                    messageLabel.addClassName("message");

                    chatBox.add(userLabel, messageLabel);
                    vTextComment.add(chatBox);
                }
                commentField.setValue("");
            }
        });

        this.add(vPost, vAllComment);
    }


    @Override
    public void beforeEnter(BeforeEnterEvent beforeEnterEvent) {
        String threadID = beforeEnterEvent.getRouteParameters().get("threadID").get();
        String userID = beforeEnterEvent.getRouteParameters().get("userID").get();

        try {
            Thread thread = WebClient.create()
                    .get()
                    .uri("http://localhost:9090/getThread/byID/" + threadID)
                    .retrieve()
                    .bodyToMono(Thread.class)
                    .block();

            User user = WebClient.create()
                    .get()
                    .uri("http://localhost:9090/getUser/byID/" + userID)
                    .retrieve()
                    .bodyToMono(User.class)
                    .block();

            this.threadNow = thread;
            this.userNow = user;

            addPost();

        } catch (Exception error) {
            Notification noti1 = new Notification("Please Login");
            noti1.addThemeVariants(NotificationVariant.LUMO_ERROR);
            noti1.open();
            noti1.setDuration(3000);
            error.printStackTrace();
            beforeEnterEvent.rerouteTo(LoginPage.class);
        }
    }
}
