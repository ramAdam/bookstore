package com.mog.momongo.view;

import com.mog.momongo.entity.Book;
import com.mog.momongo.repository.BookRepository;
import com.mog.momongo.service.BookCrudServiceImp;
import com.mog.momongo.view.component.Card;
import com.mog.momongo.view.form.BookEditor;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.renderer.TemplateRenderer;
import com.vaadin.flow.router.Route;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * BookView
 */

@Route(value="book")

public class BookView extends VerticalLayout{

    private static final long serialVersionUID = 6807869011015680250L;
    // @Autowired
    private BookRepository repository;
    TextField filter;
    Button addButton;
    private Grid<Book> grid;

    // @Autowired
    private BookEditor editor;
    private boolean editorVisible;

    
    public BookView(BookRepository bookRepository) {

        // this.bookService = bookService;
        this.repository = bookRepository;
        setEditorVisible(true);
        
        this.grid = new Grid<>(Book.class);

        this.filter = new TextField();
        filter.setPlaceholder("Search by author");
       
        this.addButton = new Button("New book", VaadinIcon.PLUS.create());
        
        
        HorizontalLayout hlayout = new HorizontalLayout();
        hlayout.setSizeFull();
        
        hlayout.setJustifyContentMode(FlexComponent.JustifyContentMode.START);
        hlayout.add(filter, addButton);



        HorizontalLayout gridLayout = new HorizontalLayout();
        gridLayout.setWidth("100%");
        gridLayout.getStyle().set("border", "10px solid #9E9E9E");
        gridLayout.setPadding(true);
        gridLayout.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        
        // FormLayout formlayout = createFormLayout();
        
        
        grid.setColumns("title", "authors");
        grid.addColumn("category.category");
        grid.setItems(repository.findAll());
        
        
        gridLayout.add(grid);
        
        
        editor = new BookEditor(gridLayout);

        addButton.addClickListener(e -> editor.toggle());
        // gridLayout.add(formlayout);


        
      
       
        
        Card card = new Card(gridLayout);
        
  

        add(hlayout);
        add(gridLayout);
        // add(card);
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

    /**
     * @return the editor
     */
    public BookEditor getEditor() {
        return editor;
    }

    /**
     * @param editor the editor to set
     */
    public void setEditor(BookEditor editor) {
        this.editor = editor;
    }


    public static TemplateRenderer<Book> getTemplate() {
		return TemplateRenderer.of(
				  "<order-card"
				+ "  header='[[item.header]]'"
				+ "  order-card='[[item.orderCard]]'"
				+ "  on-card-click='cardClick'>"
				+ "</order-card>");
	}


    
}