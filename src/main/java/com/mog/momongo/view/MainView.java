package com.mog.momongo.view;

import com.mog.momongo.entity.Book;
import com.mog.momongo.repository.BookRepository;
import com.mog.momongo.view.form.BookEditor2;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.Route;

import org.apache.commons.codec.binary.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import elemental.js.util.StringUtil;

/**
 * MainView
 */

@Route("main")
public class MainView extends VerticalLayout{

    private static final long serialVersionUID = 1L;
    private BookEditor2 editor;
    private TextField searchField;
    private Button newBttn, update;
    private HorizontalLayout actionlayout, contents;
    private Grid<Book> grid;
    @Autowired
    private BookRepository repo;

    public MainView(BookEditor2 editor) {
        this.editor = editor;
        this.createButtons();
        createGrid();
        createContentLayout();


        add(actionlayout, contents);
        

        this.editor.setChangeHandler(() -> {
            this.editor.setVisible(false);
            this.updateGrid();
        });
        

    }

    private void createButtons(){
        newBttn = new Button("New Book", VaadinIcon.PLUS.create());
        newBttn.addClickListener(e -> this.editor.setVisible(true));
        
        searchField = new TextField();
        searchField.setPlaceholder("Search By title");
        searchField.setValueChangeMode(ValueChangeMode.EAGER);
        searchField.addValueChangeListener(e -> this.grid.setItems(this.repo.findByTitle(e.getValue())));

        // searchField.addValueChangeListener(e -> updateGrid());
        update = new Button("Update");
        // update.addClickListener(e -> Notification.show("update pushed"));
        update.addClickListener(e -> updateGrid());
        actionlayout = new HorizontalLayout(searchField, newBttn, update);
        
        
    }

    private void createGrid(){
        
        this.grid = new Grid<>();
        // this.grid.setWidth("100%");
        grid.addColumn(Book::getTitle).setHeader("tile");
        grid.addColumn(Book::getAuthors).setHeader("author");
        // grid.addColumn(Book::getCategory).setHeader("Category");


        grid.setHeight("300px");
        addBooksToGrid();
        
    }

    private void addBooksToGrid(){
        this.editor.getBookService().save("Big Toe", "Science", "Tom Campbell");
        this.editor.getBookService().save("Freedom from known", "Philosopy", "Krishnamurti");
        this.grid.setItems(this.editor.findAll());
    }
    
    private void createContentLayout(){
        this.contents = new HorizontalLayout();
        contents.setWidth("100%");
        contents.add(this.grid, this.editor);
        contents.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
    }

    private void updateGrid(){
        this.grid.setItems(this.editor.findAll());
    }

    private void updateGridByTitle(String title){
        if(title.isEmpty())
            this.updateGrid();
        else{
            this.grid.setItems(this.editor.findByTitle(title));
        }
    }
}