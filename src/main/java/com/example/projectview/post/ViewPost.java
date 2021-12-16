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

@Route("Post/id1")
public class ViewPost extends HorizontalLayout {

    public ViewPost() {
        setSizeFull();
        setPadding(false);
        setSpacing(false);
        setAlignItems(Alignment.CENTER);

        Label titleLabel = new Label("Post 01");
        titleLabel.addClassNames("header-Text-with-padding", "font");
        titleLabel.setHeight("20%");
        titleLabel.setWidthFull();

        Label c1 = new Label("อย่างหล่อ");
        c1.addClassNames("message");

        Label c2 = new Label("อย่างหล่อ");
        c2.addClassNames("message");

        TextField commentField = new TextField();
        commentField.setWidthFull();
        commentField.setPlaceholder("แสดงความคิดเห็น...");

        Footer comment = new Footer();
        comment.setSizeFull();

        Label descriptionLabel = new Label("Lorem");
        descriptionLabel.addClassNames("description-with-padding", "font");
        descriptionLabel.setSizeFull();

        Button sendButton = new Button("Send");
        sendButton.addClassName("b1");

        VerticalLayout v1 = new VerticalLayout();
        v1.setHeight("90%");
        v1.setWidth("60%");
        v1.setPadding(true);
        v1.setSpacing(false);

        VerticalLayout v2 = new VerticalLayout();
        v2.addClassName("comment-panel");
        v2.setAlignItems(Alignment.CENTER);
        v2.setHeight("80%");
        v2.setWidth("40%");
        v2.setPadding(true);
        v2.setSpacing(true);

        VerticalLayout v3 = new VerticalLayout();
        v3.setSizeFull();

        HorizontalLayout h1 = new HorizontalLayout();
        h1.setWidth("80%");

        v3.add(c1, c2);
        comment.add(commentField);
        h1.add(comment, sendButton);
        v1.add(titleLabel, descriptionLabel);
        v2.add(v3, h1);

        this.add(v1, v2);
    }
}
