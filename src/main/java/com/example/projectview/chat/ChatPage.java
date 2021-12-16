package com.example.projectview.chat;

import com.vaadin.flow.component.avatar.Avatar;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.dependency.StyleSheet;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.Theme;

@StyleSheet("https://fonts.googleapis.com/css2?family=Prompt")
// Import a style sheet into the global scope
@CssImport(value = "index.css")
// Import a style sheet into the local scope of the TextField component
@CssImport(value = "components/textfield.css", themeFor = "vaadin-text-field")
// Import a style sheet into the local scope of the TextField onFocus component
@CssImport(value = "components/textfield.css", themeFor = "vaadin-text-field[focus]")

@Route("chat/test1")
public class ChatPage extends VerticalLayout {
    public ChatPage() {
        setSizeFull();
        setPadding(false);
        setSpacing(false);
        setAlignItems(Alignment.CENTER);

        Label l1 = new Label("Topics");
        l1.addClassName("font");
        l1.addClassName("header-Text");

        Label msg1 = new Label("สวัสดี พอจะมีเวลาว่างซัก 2 - 3 ชม ต่อวันไหม?");
        msg1.addClassName("font");
        msg1.addClassName("message");

        Label msg2 = new Label("เสือกเลยไอ่สัส ไม่ต้องมายุ่งกะกู");
        msg2.addClassName("font");
        msg2.addClassName("message");

        Avatar a1 = new Avatar();
        a1.addClassName("avatar");

        Avatar a2 = new Avatar();
        a2.addClassName("avatar");

        TextField msgField = new TextField();
        msgField.setMaxLength(100);
        msgField.setSizeFull();
        msgField.setPlaceholder("ใส่ข้อความที่นี่");
        msgField.addClassName("font");

        Button sendButton = new Button("Send");
        sendButton.addClassName("b1");

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

        VerticalLayout v1 = new VerticalLayout();
        v1.setHeight("100%");
        v1.setJustifyContentMode(JustifyContentMode.END);

        VerticalLayout v2 = new VerticalLayout();

        input.setWidth("100%");
        input.setPadding(true);
        input.add(msgField);
        input.add(sendButton);

        msgBox1.add(a1, msg1);
        msgBox2.add(msg2, a2);

        v1.add(msgBox1, msgBox2);
        v2.add(input);

        header.add(l1);

        content.add(v1, v2);

        add(header, content);
        expand(content);
    }
}