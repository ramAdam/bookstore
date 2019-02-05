package com.mog.momongo.view.form;

import java.util.List;

import javax.swing.plaf.basic.BasicMenuUI.ChangeHandler;

import com.mog.momongo.entity.Book;
import com.mog.momongo.service.BookCrudServiceImp;
import com.vaadin.external.org.slf4j.Logger;
import com.vaadin.flow.component.KeyNotifier;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;
import com.vaadin.flow.component.orderedlayout.FlexComponent;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;



/**
 * BookEditor2
 */
@SpringComponent
@UIScope
public class BookEditor2 extends VerticalLayout implements KeyNotifier{

    private static final long serialVersionUID = 3100159317544501861L;
    private BookCrudServiceImp bookService;

    private TextField title, author, category;
    private Button save, cancel;
    private HorizontalLayout buttonsLayout, fieldsLayout;

    // private Binder<Book> binder;
    private ChangeHandler changeHandler;



    @Autowired
    public BookEditor2(BookCrudServiceImp bookService) {
        this.bookService = bookService;
        this.init();
        add(fieldsLayout, buttonsLayout);

        setSpacing(true);


        save.addClickListener(e -> {
            if(this.bookService == null){
                Notification.show("book service is null");
            }
            else{
                Notification.show("YAY!");
                this.bookService.save(title.getValue(), author.getValue(), category.getValue());

                for(Book bk: this.bookService.findAll()){
                    Notification.show("Book title saved :" + bk.getTitle());
                }
                this.title.clear();
                this.author.clear();
                this.category.clear();
                setVisible(false);
            }
            
      
        
        });
        cancel.addClickListener(e -> setVisible(false));

        setWidth("100%");
        setJustifyContentMode(FlexComponent.JustifyContentMode.START);
        setPadding(true);

        setVisible(false);
        
    
    }

    private void init(){
        // this.binder = new Binder<>(Book.class);


        this.createTextFields();
        this.createButtons();
    }

    private void createTextFields(){
        title = new TextField("Title", "book name");
        author = new TextField("Author", "Author name");
        category = new TextField("Category", "Science, art");

        fieldsLayout = new HorizontalLayout(title, author, category);
        fieldsLayout.setWidth("100%");
        // fieldsLayout.getStyle().set("border", "2px dotted #9E9E9E");

    }

    private void createButtons(){
    
        buttonsLayout = new HorizontalLayout();
        // buttonsLayout.setWidth("50%");
        // buttonsLayout.setJustifyContentMode(FlexComponent.JustifyContentMode.START);
        // buttonsLayout.setPadding(true);

        save = new Button("save");



        cancel = new Button("cancel");

        buttonsLayout.add(save, cancel);

    }

    // public void save(){
    //     if(this.bookService == null){
    //         Notification.show("Book servcie is null");
    //     }
    //     else{
        
    //         this.bookService.save(title.getValue(), author.getValue(), category.getValue());
    //         changeHandler.onChange();
    //     }
    // }

    

    public void setChangeHandler(ChangeHandler h) {
		// ChangeHandler is notified when either save or delete
		// is clicked
		changeHandler = h;
    }
    
    public interface ChangeHandler {
		void onChange();
    }
    
    public List<Book> findAll(){
        return this.bookService.findAll();
    }

    public Book findByTitle(String title){
        return this.bookService.findByTitle(title);
    }

    public BookCrudServiceImp getBookService(){
        return this.bookService;
    }




}

    
