package com.example.projectview.view.main;

import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.avatar.Avatar;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.dependency.StyleSheet;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.polymertemplate.Id;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.AfterNavigationEvent;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouterLink;
import com.vaadin.flow.theme.Theme;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

// Import font Prompt
@StyleSheet("https://fonts.googleapis.com/css2?family=Prompt")
// Import a style sheet
@CssImport(value = "mainView.css")
// Import a style sheet into the local scope of the TextField component
@CssImport(value = "textfield.css", themeFor = "vaadin-text-field")
// Import a style sheet into the local scope of the TextField onFocus component
@CssImport(value = "textfield.css", themeFor = "vaadin-text-field[focus]")
@CssImport(value = "selectItems.css", themeFor = "vaadin-tab")
@CssImport(value = "my-dialog.css", themeFor = "vaadin-dialog-overlay")

@Route("main")
//@Theme(themeFolder = "my-theme")
public class MainView extends HorizontalLayout {
    VerticalLayout v1 = new VerticalLayout(); //column-menu
    VerticalLayout v2 = new VerticalLayout(); //column-post
    VerticalLayout v3 = new VerticalLayout(); // column-profile
    Person ownerPer = new Person(null, "Viu", "12374", "Viu", "ไอสัส", "Dec 12");
    Grid<Post> grid = new Grid<>();

    public MainView() {

        VerticalLayout v2_1 = new VerticalLayout(); // post
        VerticalLayout v3_1 = new VerticalLayout(); // add btn
        HorizontalLayout h1 = new HorizontalLayout(); // all btn for post
        HorizontalLayout hUser = new HorizontalLayout();
        Button likeBtn, commentBtn, chatBtn, addPostBtn, editBtn;
        TextField t1 = new TextField("Test");

        Label l1 = new Label("Menu1");
        l1.addClassName("font");
        Label l2 = new Label("Menu2");
        l2.addClassName("font");
        Label l3 = new Label("Menu3");
        l3.addClassName("font");
        Label l4 = new Label("Menu4");
        l4.addClassName("font");
        Label l5 = new Label("Menu5");
        l5.addClassName("font");

        Tabs views = getPrimaryNavigation();

        v1.setWidth("20%");
        v1.setHeight("100%");
        v1.setMargin(true);
        v1.getStyle().set("background-color", "#064663");
        v1.getStyle().set("border-radius", "10px");


        Dialog dialog = new Dialog();
        dialog.getElement().setAttribute("aria-label", "Add post");

        VerticalLayout dialogLayout = createDialogLayout(dialog);
        dialog.add(dialogLayout);
        dialog.setModal(false);
        dialog.setDraggable(true);

        addPostBtn = new Button("Add Post", e -> dialog.open());
        addPostBtn.getStyle().set("background-color", "#ECB365");
        addPostBtn.getStyle().set("color", "black");
        addPostBtn.setWidth("100%");


        v3.getStyle().set("background-color", "#064663");
        v3.getStyle().set("border-radius", "10px");

        v3_1.setWidth("20%");
        v3_1.setHeight("100%");
        v3_1.setMargin(true);

        Span formatSpan1 = new Span("Forum For U");
        formatSpan1.setWidthFull();
        formatSpan1.getStyle()
                .set("text-align", "center")
                .set("font-size", "20px")
                .set("color", "#ECB365");;

        Avatar user = new Avatar("Viu");
        user.setWidth("50px");
        user.setHeight("50px");
        Label nameUser = new Label("Viu");
        nameUser.setWidth("50px");
        nameUser.getStyle().set("text-align", "center")
                .set("margin-top", "5%");
        editBtn = new Button("Edit");
        editBtn.getStyle().set("background-color", "#ECB365");
        editBtn.getStyle().set("color", "black");
        hUser.add(user, nameUser, editBtn);

        v1.add(formatSpan1, views);
        v3.add(hUser);
        v3_1.add(v3, addPostBtn);

        add(v1, v2, v3_1);

    }

    private void createPost(String topic, String message) {

        VerticalLayout v2_1 = new VerticalLayout();
        v2_1.setHeight("200px");
        v2_1.getStyle().set("background-color", "#064663");
        v2_1.getStyle().set("border-radius", "10px");

        Label namePost = new Label(topic);
        namePost.getStyle().set("font-size", "25px");
        Text des = new Text(message);


        Button likeBtn, commentBtn, chatBtn;
        likeBtn = new Button("Like");
        likeBtn.getStyle().set("background-color", "#ECB365");
        likeBtn.getStyle().set("color", "black");
        commentBtn = new Button("Comment");
        commentBtn.getStyle().set("background-color", "#ECB365");
        commentBtn.getStyle().set("color", "black");
        chatBtn = new Button("Chat");
        chatBtn.getStyle().set("background-color", "#ECB365");
        chatBtn.getStyle().set("color", "black");

        HorizontalLayout h1 = new HorizontalLayout();
        VerticalLayout pv1 = new VerticalLayout();
        VerticalLayout fv1 = new VerticalLayout();
        HorizontalLayout vUser = new HorizontalLayout();

        Avatar user = new Avatar(ownerPer.getNickname());
        user.setWidth("50px");
        user.setHeight("50px");
        Label nameUser = new Label(ownerPer.getNickname());
        nameUser.setWidth("80px");
        nameUser.getStyle().set("text-align", "center")
                .set("margin-top", "10%");
        vUser.add(user, nameUser);

        h1.add(likeBtn, commentBtn, chatBtn);
        pv1.add(namePost, des);
        v2_1.add(pv1, vUser);
        fv1.add(v2_1, h1);
        v2.add(fv1);
    }


    private static Person createPerson(String _id, String username, String password, String nickname, String description) {
        Person p = new Person();
        p.set_id(_id);
        p.setUsername(username);
        p.setPassword(password);
        p.setNickname(nickname);
        p.setDescription(description);

        return p;
    }

    private static Post createPost(String _id, String ownerID, String topic, String message, Date timeStamp) {
        Post p = new Post();
        p.set_id(_id);
        p.setOwnerID(ownerID);
        p.setTopic(topic);
        p.setMessage(message);
        p.setTimeStamp(timeStamp);
        return p;
    }

    private VerticalLayout createDialogLayout(Dialog dialog) {
        H2 headline = new H2("Add Post");
        headline.getStyle().set("margin", "0").set("font-size", "1.5em")
                .set("font-weight", "bold").set("color","white");
        HorizontalLayout header = new HorizontalLayout(headline);
        header.getElement().getClassList().add("draggable");
        header.setSpacing(false);
        header.getStyle()
                .set("border-bottom", "2px solid #041C32")
                .set("cursor", "move");
        // Use negative margins to make draggable header stretch over full width,
        // covering the padding of the dialog
        header.getStyle()
                .set("padding", "var(--lumo-space-m) var(--lumo-space-l)")
                .set("margin",
                        "calc(var(--lumo-space-s) * -1) calc(var(--lumo-space-l) * -1) 0");

        TextField titleField = new TextField("Title");
        titleField.setMaxLength(50);
        TextArea descriptionArea = new TextArea("Description");
        descriptionArea.setMaxLength(100);
        VerticalLayout fieldLayout = new VerticalLayout(titleField,
                descriptionArea);
        fieldLayout.setSpacing(false);
        fieldLayout.setPadding(false);
        fieldLayout.setAlignItems(FlexComponent.Alignment.STRETCH);
        fieldLayout.getStyle().set("background-color", "#04293A");

        Button cancelButton = new Button("Cancel", e -> dialog.close());
        cancelButton.getStyle().set("background-color", "#ECB365");
        cancelButton.getStyle().set("color", "black");
        Button saveButton = new Button("Add note", e -> dialog.close());
        saveButton.getStyle().set("background-color", "#ECB365");
        saveButton.getStyle().set("color", "black");
        saveButton.addClickListener(buttonClickEvent -> createPost(titleField.getValue(), descriptionArea.getValue()));
        HorizontalLayout buttonLayout = new HorizontalLayout(cancelButton,
                saveButton);
        buttonLayout
                .setJustifyContentMode(FlexComponent.JustifyContentMode.END);

        VerticalLayout dialogLayout = new VerticalLayout(header, fieldLayout,
                buttonLayout);
        dialogLayout.setPadding(false);
        dialogLayout.setAlignItems(FlexComponent.Alignment.STRETCH);
        dialogLayout.getStyle().set("width", "300px").set("max-width", "100%").set("background-color", "#04293A");

        return dialogLayout;
    }
    private Tabs getPrimaryNavigation() {
        Tabs tabs = new Tabs();
        tabs.setWidth("100%");
        tabs.add(
                createTab(VaadinIcon.DASHBOARD, "แนะนำ"),
                createTab(VaadinIcon.DASHBOARD, "สัตว์"),
                createTab(VaadinIcon.CART, "กีฬา"),
                createTab(VaadinIcon.USER_HEART, "การเรียน"),
                createTab(VaadinIcon.PACKAGE, "ครอบครัว"),
                createTab(VaadinIcon.RECORDS, "การเมือง"),
                createTab(VaadinIcon.LIST, "การเงิน"),
                createTab(VaadinIcon.CHART, "สุขภาพ"),
                createTab(VaadinIcon.DASHBOARD, "อาหาร"),
                createTab(VaadinIcon.CART, "ท่องเที่ยว"),
                createTab(VaadinIcon.USER_HEART, "รถยนต์"),
                createTab(VaadinIcon.PACKAGE, "แฟชั่น"),
                createTab(VaadinIcon.RECORDS, "การ์ตูน")
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
        link.add(icon, new Span(viewName));
        // Demo has no routes
        // link.setRoute(viewClass.java);
        link.setTabIndex(-1);

        return new Tab(link);
    }

}
