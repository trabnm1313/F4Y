package com.example.projectview.view.main;

import com.example.projectview.view.profile.ProfileEdit;
import com.vaadin.flow.component.avatar.Avatar;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.dependency.StyleSheet;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.renderer.ComponentRenderer;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouterLink;

import java.util.Date;
import java.util.EventListener;

// Import font Prompt
@StyleSheet("https://fonts.googleapis.com/css2?family=Prompt")
// Import a style sheet
@CssImport(value = "mainView.css")
@CssImport(value = "components/textfield.css", themeFor = "vaadin-text-field")
@CssImport(value = "components/textfield.css", themeFor = "vaadin-text-field[focus]")
@CssImport(value = "components/textArea.css", themeFor = "vaadin-text-area")
@CssImport(value = "components/textArea.css", themeFor = "vaadin-text-area[focus]")
@CssImport(value = "components/selectItems.css", themeFor = "vaadin-tab")
@CssImport(value = "components/combo-box.css", themeFor = "vaadin-combo-box-item")

@Route("main")
public class MainView extends HorizontalLayout {
    VerticalLayout vMenu = new VerticalLayout(); // column-menu
    VerticalLayout vAllPost = new VerticalLayout(); // column-post
    VerticalLayout vProfileAndNewPost = new VerticalLayout(); // column-profile and add post


    public MainView() {

        // MENU
        Tabs views = getPrimaryNavigation();

        vMenu.setWidth("20%");
        vMenu.setHeight("100%");
        vMenu.setMargin(true);
        vMenu.getStyle()
                .set("background-color", "#064663")
                .set("border-radius", "10px")
                .set("margin-left","3%").set("margin-top", "2%");

        Span titleMenu = new Span("Forum For U");
        titleMenu.setWidthFull();
        titleMenu.getStyle()
                .set("text-align", "center")
                .set("font-size", "20px")
                .set("color", "#ECB365");

        HorizontalLayout headerLayout = new HorizontalLayout();
        headerLayout.setWidthFull();
        headerLayout.getStyle().set("background-color", "#041C32");

        TextField searchTextField = new TextField();
        searchTextField.getStyle()
                .set("overflow", "auto")
                .set("background-color", "#041C32")
                .set("margin-left", "10%");
        searchTextField.setPlaceholder("Search");

        Button searchButton = new Button(new Icon(VaadinIcon.SEARCH));
        searchButton.getStyle()
                .set("overflow", "auto")
                .set("background-color", "#ECB365")
                .set("color", "black")
                .set("margin-right", "3%");;

        headerLayout.add(searchTextField, searchButton);

        vMenu.add(titleMenu, headerLayout,views);

        // POST
        vAllPost.getStyle().set("overflow", "auto");
        vAllPost.setHeight("700px");


        // PROFILE AND NEW POST
        vProfileAndNewPost.setWidth("20%");
        vProfileAndNewPost.setHeight("100%");
        vProfileAndNewPost.setMargin(true);

        VerticalLayout vUser = new VerticalLayout(); // layout profile
        vUser.getStyle()
                .set("background-color", "#064663")
                .set("border-radius", "10px");

        VerticalLayout vAddPost = new VerticalLayout(); // layout for add new post
        vAddPost.getStyle()
                .set("background-color", "#064663")
                .set("border-radius", "10px");

        TextField titleField = new TextField("Title");
        titleField.setMaxLength(50);
        titleField.setClassName("font");

        TextArea descriptionArea = new TextArea("Description");
        descriptionArea.setMaxLength(500);
        descriptionArea.setClassName("font");

        ComboBox<String> listTag = new ComboBox<String>("Tag");
        listTag.setItems("สัตว์","การเรียน","ครอบครัว","การเมือง","การเงิน","สุขภาพ","อาหาร","ท่องเที่ยว","รถยนต์","แฟชั่น","การ์ตูน");
        listTag.setClassName("font");
        listTag.setRenderer(new ComponentRenderer<>(item -> {
            Span text = new Span(item);
                text.setClassName("cb");
            return text;
        }));
        listTag.getElement().setAttribute("theme",
                "custom-item-background");

        Button addPostBtn = new Button("Add Post", e -> createPost(titleField.getValue(), descriptionArea.getValue(), listTag.getValue()));
        addPostBtn.getStyle()
                .set("background-color", "#ECB365")
                .set("color", "black");
        addPostBtn.setWidth("100%");
        addPostBtn.setClassName("font");

        vAddPost.add(titleField, descriptionArea, listTag);

        Avatar user = new Avatar("Viu");
        user.setWidth("50px");
        user.setHeight("50px");

        Label nameUser = new Label("Viu");
        nameUser.setWidth("50px");
        nameUser.getStyle()
                .set("text-align", "center")
                .set("margin-top", "10%");

        Button editBtn = new Button("Edit profile",new Icon(VaadinIcon.EDIT));
        editBtn.getStyle()
                .set("background-color", "#ECB365")
                .set("color", "black");
        editBtn.setWidth("100%");
        editBtn.setClassName("font");

        HorizontalLayout hDetailUser = new HorizontalLayout(); //layout user in profile
        hDetailUser.add(user, nameUser); // add detail profile
        vUser.add(hDetailUser); // add detail profile to layout profile

        vProfileAndNewPost.add(vUser, editBtn, vAddPost, addPostBtn);
        add(vMenu, vAllPost, vProfileAndNewPost);
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
        vAllPost.add(vOnePost);
    }

    private Tabs getPrimaryNavigation() {
        Tabs tabs = new Tabs();
        tabs.setWidth("100%");
        tabs.add(
                createTab(VaadinIcon.ASTERISK, "แนะนำ"),
                createTab(VaadinIcon.TWITTER, "สัตว์"),
                createTab(VaadinIcon.HANDS_UP, "กีฬา"),
                createTab(VaadinIcon.BOOK, "การเรียน"),
                createTab(VaadinIcon.FAMILY, "ครอบครัว"),
                createTab(VaadinIcon.PYRAMID_CHART, "การเมือง"),
                createTab(VaadinIcon.MONEY, "การเงิน"),
                createTab(VaadinIcon.USER_HEART, "สุขภาพ"),
                createTab(VaadinIcon.CROSS_CUTLERY, "อาหาร"),
                createTab(VaadinIcon.AIRPLANE, "ท่องเที่ยว"),
                createTab(VaadinIcon.CAR, "รถยนต์"),
                createTab(VaadinIcon.GLASSES, "แฟชั่น"),
                createTab(VaadinIcon.MONEY, "การ์ตูน")
        );
        tabs.setOrientation(Tabs.Orientation.VERTICAL);
        tabs.setSelectedIndex(0);
        return tabs;
    }

    private Tab createTab(VaadinIcon viewIcon, String viewName) {
        Icon icon = viewIcon.create();
        icon.getStyle()
                .set("box-sizing", "border-box")
                .set("margin-inline-end", "var(--lumo-space-m)")
                .set("padding", "var(--lumo-space-xs)");

        RouterLink link = new RouterLink();
        Span vName = new Span(viewName);
        vName.getStyle().set("font-family", "Prompt");
        link.add(icon, vName);
        // Demo has no routes
        // link.setRoute(viewClass.java);
        link.setTabIndex(-1);

        return new Tab(link);
    }

}
