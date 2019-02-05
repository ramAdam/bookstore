package com.mog.momongo.view;




import com.mog.momongo.view.component.Card;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.dependency.StyleSheet;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H4;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.BoxSizing;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;



/**
 * BookGridView
 */
@Route("grid")
@StyleSheet("styles.css")
public class BookGridView extends VerticalLayout{

    private static final long serialVersionUID = 1L;

    private HorizontalLayout content;
    private Label label;
    private Card card, c2;
    private Div container;


    public BookGridView() {
        
        this.content = createHorizontalLayout();

        this.container = new Div();
        // container.getStyle().set("border", "5px solid red");
   
        container.getStyle().set("display", "flex");
        container.getStyle().set("flex-direction", "row");
        container.getStyle().set("flex-wrap", "no-wrap");
        // // justify-content: flex-start | flex-end | center | space-between | space-around | space-evenly;
        // container.getStyle().set("justify-content", "space-around");
        // // align-content: flex-start | flex-end | center | space-between | space-around | stretch;
        // container.getStyle().set("align-items", "space-between");
        container.getStyle().set("overflow-x", "auto");
        
        
        
        this.content.add(container);
        

        

        for(int i=0; i < 20; i++){
            container.add(createComponent());
        }
        
        setAlignItems(Alignment.START);
        add(content);


    }

    private Component createComponent(){
        
        Div div = new Div();
        div.setWidth("200px");
        // div.getStyle().set("border", "5px dotted blue");
        div.addClassName("v-app");
        div.addClassName("card");
        div.getStyle().set("margin", "5px");
        div.getStyle().set("box-shadow", "0 5px 10px 0 rgba(0, 0, 0, 0.2)");
        div.getStyle().set("transition", "0.3s");

     

        

        
        // div.getStyle().set("color", "white");
        // div.getStyle().set("text-align", "center");
        
        //  div.getStyle().set("padding", "2px 16px");

        Image employee = new Image("https://www.w3schools.com/howto/img_avatar.png", "Employee");
        employee.setWidth(div.getWidth());
        employee.setHeight(div.getHeight());
        div.add(employee);
        div.add(new H4("Jhon Doe"));
        div.add(new Paragraph("Architect and Engineer"));


        return div;
        
    }

    private HorizontalLayout createHorizontalLayout(){

        HorizontalLayout layout = new HorizontalLayout();
        // layout.getStyle().set("border", "5px solid grey");
        layout.getStyle().set("color", "black");
      
        layout.getStyle().set("display", "flex");
        layout.getStyle().set("flex-flow", "row no-wrap");
        layout.getStyle().set("overflow", "hidden");
      
      
        layout.setSizeFull();
        layout.setPadding(true);
   
       
       
        
        layout.setBoxSizing(BoxSizing.BORDER_BOX);
        layout.addClassName("v-app");

        return layout;

    }

    /**
     * @return the content
     */
    public HorizontalLayout getContent() {
        return content;
    }

    /**
     * @param content the content to set
     */
    public void setContent(HorizontalLayout content) {
        this.content = content;
    }

    
}