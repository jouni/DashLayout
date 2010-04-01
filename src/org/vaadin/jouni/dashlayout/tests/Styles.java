package org.vaadin.jouni.dashlayout.tests;

import org.vaadin.jouni.dashlayout.client.tests.VStyles;

import com.vaadin.ui.ClientWidget;
import com.vaadin.ui.TextField;

@ClientWidget(VStyles.class)
public class Styles extends TextField {

    public Styles() {
        super();
        setRows(5);
    }

}
