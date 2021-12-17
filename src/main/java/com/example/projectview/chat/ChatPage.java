package com.example.projectview.chat;

import com.example.projectview.login.LoginPage;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.vaadin.collaborationengine.CollaborationMessage;
import com.vaadin.collaborationengine.CollaborationMessageList;
import com.vaadin.collaborationengine.CollaborationMessagePersister;
import com.vaadin.collaborationengine.UserInfo;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.dependency.StyleSheet;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.notification.NotificationVariant;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.page.Push;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.router.BeforeEnterObserver;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.shared.Registration;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

@StyleSheet("https://fonts.googleapis.com/css2?family=Prompt")
// Import a style sheet into the global scope
@CssImport(value = "index.css")
// Import a style sheet into the local scope of the TextField component
@CssImport(value = "components/textfield.css", themeFor = "vaadin-text-field")
// Import a style sheet into the local scope of the TextField onFocus component
@CssImport(value = "components/textfield.css", themeFor = "vaadin-text-field[focus]")

@Push
@Route("chat/:userID")
public class ChatPage extends VerticalLayout implements BeforeEnterObserver {

    User nowUser;
    UserInfo userInfo;
    JsonNode msg;

    VerticalLayout v1;

    public ChatPage() {

        setSizeFull();
        setPadding(false);
        setSpacing(false);
        setAlignItems(Alignment.CENTER);

        Label l1 = new Label("Topics");
        l1.addClassName("font");
        l1.addClassName("header-Text");


        TextField msgField = new TextField();
        msgField.setMaxLength(100);
        msgField.setSizeFull();
        msgField.setPlaceholder("ใส่ข้อความที่นี่");
        msgField.addClassName("font");

        HorizontalLayout header = new HorizontalLayout();
        header.addClassName("header");
        header.setWidth("100%");
        header.setPadding(true);

        HorizontalLayout input = new HorizontalLayout();
        input.addClassName("message-input");

        HorizontalLayout msgBox1 = new HorizontalLayout();
        msgBox1.addClassName("message-box");
        msgBox1.setWidth("100%");

        HorizontalLayout msgBox2 = new HorizontalLayout();
        msgBox2.addClassName("message-box");
        msgBox2.setWidth("100%");
        msgBox2.setJustifyContentMode(JustifyContentMode.END);

        VerticalLayout content = new VerticalLayout();
        content.addClassName("content");
        content.setWidth("95%");

        v1 = new VerticalLayout();
        v1.setHeight("100%");
        v1.setJustifyContentMode(JustifyContentMode.END);

        VerticalLayout v2 = new VerticalLayout();

        header.add(l1);

        content.add(v1, v2);

        add(header, content);
        expand(content);
    }

    public void addChat(){
        VerticalLayout vl = new VerticalLayout();
        HorizontalLayout hl = new HorizontalLayout();
        HorizontalLayout hl2 = new HorizontalLayout();

        CollaborationMessageList collaborationMessageList = new CollaborationMessageList(userInfo, "FirstTopic", new CollaborationMessagePersister() {
            @Override
            public Stream<CollaborationMessage> fetchMessages(FetchQuery fetchQuery) {
                msg = WebClient.create().get().uri("http://localhost:9090/getMessage/byTopic/" + fetchQuery.getTopicId() + "/" + fetchQuery.getSince()).retrieve().bodyToMono(JsonNode.class).block();

                ObjectMapper objectMapper = new ObjectMapper();
                objectMapper.registerModule(new JavaTimeModule());
                List<Message> msgList = objectMapper.convertValue(msg, new TypeReference<List<Message>>() {});

                return msgList.stream().map(message -> {
                    JsonNode userObject = WebClient.create().get().uri("http://localhost:9090/getUser/byID/" + message.getUserID()).retrieve().bodyToMono(JsonNode.class).block();
                    User user = objectMapper.convertValue(userObject, new TypeReference<User>() {});
                    UserInfo userInfo = new UserInfo(message.getUserID(), user.getUsername(), null);
                    return new CollaborationMessage(userInfo, message.getText(), message.getTimeStamp());
                });
            }


            @Override
            public void persistMessage(PersistRequest persistRequest) {
                CollaborationMessage message = persistRequest.getMessage();

                Message messageEntity = new Message();
                messageEntity.setTopic(persistRequest.getTopicId());
                messageEntity.setText(message.getText());
                messageEntity.setUserID(message.getUser().getId());
                messageEntity.setTimeStamp(message.getTime());

                WebClient.create().post().uri("http://localhost:9091/createMessage").body(Mono.just(messageEntity), Message.class).retrieve().bodyToMono(Message.class).block();
            }
        });

        TextField field = new TextField();
        Button button = new Button("Submit");
        button.setEnabled(false);

        collaborationMessageList.setSubmitter(activationContext -> {
            button.setEnabled(true);
            Registration registration = button.addClickListener(event -> {
                activationContext.appendMessage(field.getValue());
                field.setValue("");
            });
            return () -> {
                registration.remove();
                button.setEnabled(false);
            };
        });

        hl2.add(field, button);
        hl2.expand(field);
        hl2.setWidthFull();

        collaborationMessageList.addClassNames("font", "message");

        hl.setWidth("100%");
        hl.setHeight("350px");
        hl.expand(collaborationMessageList);

        vl.setWidth("100%");
        vl.setHeight("350px");
        vl.expand(collaborationMessageList);

        hl.add(collaborationMessageList);
        vl.add(hl, hl2);

        v1.add(vl);
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
            this.userInfo = new UserInfo(user.get_id(), user.getNickname(), null);

            addChat();

        } catch (Exception error) {
            Notification noti1 = new Notification("Please Login");
            noti1.addThemeVariants(NotificationVariant.LUMO_ERROR);
            noti1.open();
            noti1.setDuration(3000);
            beforeEnterEvent.rerouteTo(LoginPage.class);
        }
    }
}