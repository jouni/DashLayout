package com.vaadin.incubator.dashlayout.tests;

import com.vaadin.incubator.dashlayout.client.tests.VStyles;
import com.vaadin.ui.ClientWidget;
import com.vaadin.ui.TextField;

@ClientWidget(VStyles.class)
public class Styles extends TextField {

    public Styles() {
        super();
        setRows(5);
    }

}
