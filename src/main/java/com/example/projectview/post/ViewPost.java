package com.example.projectview.post;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.dependency.StyleSheet;
import com.vaadin.flow.component.html.Footer;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

@StyleSheet("https://fonts.googleapis.com/css2?family=Prompt")
@CssImport(value = "mainView.css")
@Route("post/id1")
public class ViewPost extends HorizontalLayout {
    String tag = "ลากหัวคมๆ";
    public ViewPost() {
        setSizeFull();
        setPadding(false);
        setSpacing(false);
        setAlignItems(Alignment.CENTER);

        VerticalLayout headerLayout = new VerticalLayout();
        headerLayout.addClassNames("header-Text-with-padding", "font");

        Label titleLabel = new Label("Post 01");
        titleLabel.setSizeFull();

        Label tagLabel = new Label("#"+tag);
        tagLabel.addClassNames("font", "header-Text-Post");
        tagLabel.setSizeFull();

        VerticalLayout descriptionLayout = new VerticalLayout();
        descriptionLayout.addClassNames("description-with-padding", "font");
        descriptionLayout.setHeight("75%");

        Label descriptionLabel = new Label("Lorem");
        descriptionLabel.setSizeFull();

        descriptionLayout.add(descriptionLabel);

        Label c1 = new Label("อย่างหล่อ");
        c1.addClassNames("message");

        Label c2 = new Label("อย่างหล่อ");
        c2.addClassNames("message");

        Label c3 = new Label("อย่างหล่อ");
        c3.addClassNames("message");

        Label c4 = new Label("อย่างหล่อ");
        c4.addClassNames("message");

        Label c5 = new Label("อย่างหล่อ");
        c5.addClassNames("message");

        Label c6 = new Label("อย่างหล่อ");
        c6.addClassNames("message");

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

        vTextComment.add(c1, c2, c3, c4, c5, c6);
        comment.add(commentField);
        hSendComment.add(comment, sendButton);
        headerLayout.add(titleLabel, tagLabel);
        vPost.add(headerLayout, descriptionLayout, chatButton);
        vAllComment.add(vTextComment, hSendComment);

        this.add(vPost, vAllComment);
    }



}
