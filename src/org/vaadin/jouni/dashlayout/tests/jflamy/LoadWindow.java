package org.vaadin.jouni.dashlayout.tests.jflamy;

import java.util.Locale;

import org.vaadin.jouni.dashlayout.ui.HorDashLayout;
import org.vaadin.jouni.dashlayout.ui.VerDashLayout;

import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;

public class LoadWindow extends Window {
    private static final long serialVersionUID = 4907861433698426676L;

    private Platform platform;
    private LoadImage imageArea;

    public LoadWindow() {
        super();

        final Locale locale = Locale.getDefault();
        platform = new Platform();

        display(locale);
        position();
    }

    private void display(final Locale locale) {
        removeAllComponents();
        setSizeUndefined();

        VerticalLayout root = new VerDashLayout();
        HorizontalLayout top = new HorDashLayout();
        final Button resizeButton = new Button("+");

        imageArea = new LoadImage(this);
        imageArea.computeImageArea(platform);
        resize();

        top.setSizeFull();
        top.addComponent(imageArea);
        top.setComponentAlignment(imageArea, Alignment.MIDDLE_CENTER);
        top.addComponent(resizeButton);

        top.setExpandRatio(imageArea, 100);
        top.setComponentAlignment(resizeButton, "bottom");
        top.setExpandRatio(resizeButton, 0);
        top.setMargin(true);

        root.addComponent(top);
        setContent(root);
        root.setSizeFull();
        addStyleName("light");
    }

    private void position() {
        center();
    }

    private void resize() {
        setWidth("30em");
        setHeight("42ex");
    }

}
