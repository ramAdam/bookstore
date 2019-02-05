package com.mog.momongo.view.component;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.HasComponents;
import com.vaadin.flow.component.HasStyle;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.dom.Element;
import com.vaadin.flow.dom.ElementFactory;

/**
 * Card
 */
@Tag("div")
public class Card extends Component implements HasStyle, HasComponents{

    
    private static final long serialVersionUID = -1423493186755462103L;
    private Element h2;

    // Paragraph p = new Paragraph();
    private Element p;
    
    

    public Card(HorizontalLayout hLayout) {
        super();

        p = ElementFactory.createParagraph("This is a paragraph");
        h2 = ElementFactory.createHeading2("This is a heading");

        
        getStyle().set("border", "10px solid black");
        getStyle().set("background-color", "red");
        getStyle().set("color", "white");
        getStyle().set("padding", "20px");
        
        h2.getStyle().set("color", "white");
        
        getElement().appendChild(h2);
       
        getElement().appendChild(p);
        
        // setHeight(hLayout.getHeight());
        // setWidth(hLayout.getWidth());
      
        
        hLayout.add(this);
        
        
    }
    
}