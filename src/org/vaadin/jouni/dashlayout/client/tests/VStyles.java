package org.vaadin.jouni.dashlayout.client.tests;

import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.user.client.Event;
import com.vaadin.terminal.gwt.client.ApplicationConnection;
import com.vaadin.terminal.gwt.client.UIDL;
import com.vaadin.terminal.gwt.client.ui.VTextArea;

public class VStyles extends VTextArea {

    public VStyles() {
        sinkEvents(Event.ONCHANGE);
        addChangeHandler(new ChangeHandler() {
            public void onChange(ChangeEvent event) {
                setStyles(getValue(), id);
            }
        });
    }

    @Override
    public void updateFromUIDL(UIDL uidl, ApplicationConnection client) {
        super.updateFromUIDL(uidl, client);
        setStyles(getText(), id);
    }

    private native void setStyles(String value, String id)
    /*-{
        var el;
        var elid = "vstyles-" + id;
        
        if(!(el = $doc.getElementById(elid))) {
            el = $doc.createElement("style");
            el.type = "text/css";
            el.id = elid;
            $doc.getElementsByTagName("head")[0].appendChild(el);
        }
        
        var rules = $doc.createTextNode(value);
        if(el.styleSheet)
            el.styleSheet.cssText = value;
        else {
            if(el.firstChild)
                el.removeChild(el.firstChild);
            el.appendChild(rules);
        }
    }-*/;

}
