package org.vaadin.jouni.dashlayout.tests;

import org.vaadin.jouni.dashlayout.ui.HorDashLayout;
import org.vaadin.jouni.dashlayout.ui.VerDashLayout;

import com.vaadin.Application;
import com.vaadin.ui.AbstractOrderedLayout;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Layout;
import com.vaadin.ui.TabSheet;
import com.vaadin.ui.Window;

@SuppressWarnings("serial")
public class TestApplication extends Application {

    final Window main = new Window("DashLayout test");

    TabSheet tests = new TabSheet();

    private boolean vert = false;

    @Override
    public void init() {
        setMainWindow(main);
        setTheme("test");

        main.getContent().setSizeFull();
        tests.setSizeFull();
        main.addComponent(tests);

        HorDashLayout top = new HorDashLayout();
        HorDashLayout imageArea = new HorDashLayout();
        Button resizeButton = new Button("+");
        top.addComponent(imageArea);
        top.setComponentAlignment(imageArea, Alignment.MIDDLE_CENTER);
        top.addComponent(resizeButton);
        top.setComponentAlignment(resizeButton, "bottom");
        top.setExpandRatio(resizeButton, 0);
        top.setMargin(true);
        top.setWidth("100%");

        tests.addComponent(alignBottomUndefinedHeight());
        tests.addComponent(alignMiddleCenterSingleComponent());
        tests.addComponent(alignMiddleCenterMultipleComponents());

    }

    /*
     * Button should be aligned to the bottom, even when the parent layout has
     * undefined height. The other component in the layout should specify the
     * height.
     */
    Layout alignBottomUndefinedHeight() {
        AbstractOrderedLayout test = getTestLayout();
        test.setCaption("Align bottom, undefined height");
        HorDashLayout imageArea = new HorDashLayout();
        Button resizeButton = new Button("+");

        imageArea.setWidth("200px");
        imageArea.setHeight("200px");
        test.addComponent(imageArea);
        test.setComponentAlignment(imageArea, Alignment.MIDDLE_CENTER);
        test.setExpandRatio(imageArea, 1);

        // test.addComponent(resizeButton);
        // test.setComponentAlignment(resizeButton, Alignment.BOTTOM_LEFT);

        test.setWidth("100%");

        return test;
    }

    /*
     * Button should be centered in the view, vertically and horizontally
     */
    Layout alignMiddleCenterSingleComponent() {
        AbstractOrderedLayout test = getTestLayout();
        test.setCaption("Align center, single component");
        test.setSizeFull();

        Button button = new Button("I'm centered");
        test.addComponent(button);
        test.setComponentAlignment(button, Alignment.MIDDLE_CENTER);

        return test;
    }

    /*
     * Buttons should be centered in the their slots, vertically and
     * horizontally, equal expand ratios
     */
    Layout alignMiddleCenterMultipleComponents() {
        AbstractOrderedLayout test = getTestLayout();
        test.setCaption("Align center, multiple components");
        test.setSizeFull();

        Button button = new Button("I'm centered");
        test.addComponent(button);
        test.setComponentAlignment(button, Alignment.MIDDLE_CENTER);

        button = new Button("I'm centered");
        test.addComponent(button);
        test.setComponentAlignment(button, Alignment.MIDDLE_CENTER);

        button = new Button("I'm centered");
        test.addComponent(button);
        test.setComponentAlignment(button, Alignment.MIDDLE_CENTER);

        return test;
    }

    AbstractOrderedLayout getTestLayout() {
        if (vert) {
            return new VerDashLayout();
        } else {
            return new HorDashLayout();
        }
    }

}
