package com.mog.momongo.view.form;

import javax.annotation.PostConstruct;

import com.mog.momongo.entity.Book;
import com.mog.momongo.entity.Category;
import com.mog.momongo.repository.BookRepository;
import com.mog.momongo.repository.CategoryRepository;
import com.mog.momongo.service.BookCrudServiceImp;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

import com.vaadin.flow.component.orderedlayout.FlexComponent;

/**
 * BookEditor
 */
// @Scope("prototype")
public class BookEditor extends FormLayout{

    private static final long serialVersionUID = 7380472449539835861L;
    private TextField title;
    private TextField author;
    private TextField category;
    private HorizontalLayout buttonsLayout;
    private Button save, cancel;
    private boolean editorVisible;

    // @Autowired
    private BookCrudServiceImp bookService;

  
    @Autowired
    public BookEditor(BookCrudServiceImp bookService){
        this.bookService = bookService;
    }

    // @Autowired // setter injection to allow simple mocking in tests
    public void setBookService(BookCrudServiceImp bookService) {
        this.bookService = bookService;
    }


    public BookEditor(HorizontalLayout hlayout) {
        super();
        init();
        hlayout.add(this);
        
        
    }

    public BookEditor(VerticalLayout vlayout, BookCrudServiceImp bookService){
        super();
        init();
        vlayout.add(this);
        this.save.addClickListener(e -> Notification.show("save clicked !!"));

    }


    public void init(){
       
        editorVisible = false;
        setVisible(isEditorVisible());
        
        // this.bookService = bookService;

        createTextFields();
        createButtons();

        add(title, author, category, buttonsLayout);
        setResponsiveSteps(
        new ResponsiveStep("0", 1),
        new ResponsiveStep("21em", 2),
        new ResponsiveStep("22em", 3));


    }

    public void toggle(){
        
        if(editorVisible)
            setEditorVisible(false);
        else
            setEditorVisible(true);
        
        setVisible(isEditorVisible());
        
    }

    /**
     * @return the editorVisible
     */
    public boolean isEditorVisible() {
        return editorVisible;
    }

    /**
     * @param editorVisible the editorVisible to set
     */
    public void setEditorVisible(boolean editorVisible) {
        this.editorVisible = editorVisible;
    }

    private void createButtons() {
        
        buttonsLayout = new HorizontalLayout();
        buttonsLayout.setWidth("100%");
        buttonsLayout.setJustifyContentMode(FlexComponent.JustifyContentMode.START);
        buttonsLayout.setPadding(true);

        // save = new Button("save", event -> Notification.show("BAM!!"));
        save = new Button("save");
        this.save.addClickListener(click -> {
        
        Notification.show("Book is "+ title.getValue() + "Author" + author.getValue());
        if(this.bookService == null){
            Notification.show("Book service is null");
            }
        }
        
        );
        

        cancel = new Button("cancel");
        buttonsLayout.add(save, cancel);
    }

    private void createTextFields(){
        
        title = new TextField("Title", "book name");
        author = new TextField("Author", "Author name");
        category = new TextField("Category", "Science, art");

    }

    // private void saveBook(){
    //     bookService.save(title.getValue(), category.getValue(), author.getValue());

    // }

    /**
     * @return the category
     */
    public TextField getCategory() {
        return category;
    }

    /**
     * @param category the category to set
     */
    public void setCategory(TextField category) {
        this.category = category;
    }

    /**
     * @return the author
     */
    public TextField getAuthor() {
        return author;
    }

    /**
     * @param author the author to set
     */
    public void setAuthor(TextField author) {
        this.author = author;
    }

    /**
     * @return the title
     */
    public TextField getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(TextField title) {
        this.title = title;
    }

    
}