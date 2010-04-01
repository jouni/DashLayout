package org.vaadin.jouni.dashlayout.tests;

import org.vaadin.jouni.dashlayout.ui.HorDashLayout;

import com.vaadin.Application;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;
import com.vaadin.ui.Button.ClickEvent;

@SuppressWarnings("serial")
public class TestApplication extends Application {

    private Button swithLayout;
    final Window main = new Window("DashLayout test");
    private boolean foobar = true;
    private Styles styles = new Styles();

    @Override
    public void init() {
        setMainWindow(main);
        setTheme("test");

        Window w = new Window();
        main.addWindow(w);

        HorDashLayout top = new HorDashLayout();
        HorDashLayout imageArea = new HorDashLayout();
        Button resizeButton = new Button("+", new Button.ClickListener() {

            public void buttonClick(ClickEvent event) {
                main.showNotification("tst");
            }
        });
        top.addComponent(imageArea);
        top.setComponentAlignment(imageArea, Alignment.MIDDLE_CENTER);
        top.addComponent(resizeButton);
        top.setComponentAlignment(resizeButton, "bottom");
        top.setExpandRatio(resizeButton, 0);
        top.setMargin(true);
        top.setWidth("100%");

        // "Weights"
        Label l = new Label("1");
        l.setSizeUndefined();
        imageArea.addComponent(l);
        l = new Label("2");
        l.setSizeUndefined();
        imageArea.addComponent(l);
        l = new Label("3");
        l.setSizeUndefined();
        imageArea.addComponent(l);

        w.setContent(top);

        // AbstractOrderedLayout d = new VerDashLayout();
        // d.setSpacing(true);
        // d.setMargin(true);
        // // d.setSizeFull();
        // // d.setSizeUndefined();
        // d.setHeight("100%");
        // d.setWidth("50%");
        // d.setStyleName("root");
        //
        // Button btn = new NativeButton("Change size",
        // new Button.ClickListener() {
        // public void buttonClick(ClickEvent event) {
        // event.getButton().setWidth("200px");
        // event.getButton().setHeight("200px");
        //
        // ((Layout) event.getButton().getParent())
        // .addComponent(new Button("New button"));
        // }
        // });
        // d.addComponent(btn);
        //
        // d.addListener(new LayoutClickListener() {
        //
        // public void layoutClick(LayoutClickEvent event) {
        // System.out.println(event.getChildComponent());
        //
        // }
        // });
        //
        // Label b = new Label(
        // "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.");
        // b.setValue("teset");
        // b.setSizeFull();
        // // b.setSizeUndefined();
        // // b.setHeight(null);
        // d.addComponent(b);
        // d.setComponentAlignment(b, "center middle");
        // d.setExpandRatio(b, 1);
        //
        // b = new Label("testing");
        // b.setSizeFull();
        // // b.setSizeUndefined();
        // d.addComponent(b);
        // d.setExpandRatio(b, 1);
        // d.setComponentAlignment(b, "center middle");
        //
        // Panel p = new Panel("Panel");
        // // p.setWidth("100%");
        // p.setSizeUndefined();
        // // p.setSizeFull();
        // p.addComponent(new Label("Another test"));
        // d.addComponent(p);
        // d.setComponentAlignment(p, "center middle");
        //
        // main.setContent(d);

        // swithLayout = new Button("Switch DashLayout/VerticalLayout",
        // new Button.ClickListener() {
        // public void buttonClick(ClickEvent event) {
        // if (foobar) {
        // nestedVLayouts();
        // } else {
        // nestedLayouts();
        // }
        // foobar = !foobar;
        // }
        // });
        // styles.setWidth("100%");
        // // styles
        // //
        // .setValue(".v-flexlayout {\n\tborder: 2px solid #999;\n\tmargin: 2px;\n\tpadding: 2px;}\n");
        // styles.setImmediate(true);
        // styles.addListener(new ValueChangeListener() {
        // public void valueChange(ValueChangeEvent event) {
        // main.getContent().requestRepaintAll();
        // }
        // });
        // nestedLayouts();
    }

    private void nestedLayouts() {
        // DashLayout fl = new DashLayout();
        // fl.setSizeFull();
        // fl.setSizeUndefined();
        // fl.setWidth("400px");
        // fl.setHeight("200px");
        // main.setContent(fl);

        // fl.addComponent(styles);
        // fl.addComponent(swithLayout);
        // fl.setComponentAlignment(swithLayout, "center");
        // fl.setStyleName("root");
        // fl.addStyleName("test");
        // fl.setMargin(true);
        // fl.setSpacing(true);

        // DashLayout last = fl;

        // Label foo = new Label(
        // "Requested resource [VAADIN/themes/flexlayout/favicon.ico] not found from filesystem or through class loader. Add widgetset and/or theme JAR to your classpath or add files to WebContent/VAADIN folder.");
        // last.addComponent(foo);

        for (int i = 0; i < 0; i++) {
            Panel l = new Panel("Panel");
            l.setSizeFull();
            // last.addComponent(l);
            // last.setExpandRatio(l, 2);
            l.setStyleName("first");

            final Button b = new Button("Button", new Button.ClickListener() {
                public void buttonClick(ClickEvent event) {
                    event.getButton().setWidth("400px");
                }
            });
            b.setWidth("50%");
            // last.addComponent(b);
            // last.setComponentAlignment(b, "center");

            // DashLayout l2 = new DashLayout();
            // l2.setSizeFull();
            // l2.setSizeUndefined();
            // last.addComponent(l2);
            // last.setExpandRatio(l2, 10);
            // last = l2;
            // l2.setStyleName("second");
            // l2.setSpacing(true);
            // l2.setMargin(true);
        }
        // Label foo = new Label("Foobar 1");
        // foo.setSizeFull();
        // last.addComponent(foo);
        // last.setComponentAlignment(foo, "right");
        // last.setExpandRatio(foo, 1);

        // foo = new Label("Foobar 2");
        // foo.setSizeFull();
        // foo.setSizeUndefined();
        // last.addComponent(foo);
        // last.setComponentAlignment(foo, "center");
        // last.setExpandRatio(foo, 1);
    }

    private void nestedVLayouts() {
        VerticalLayout vl = new VerticalLayout();
        vl.setSizeFull();
        main.setContent(vl);

        vl.addComponent(swithLayout);

        VerticalLayout last = vl;

        Label foo = new Label(
                "Requested resource [VAADIN/themes/flexlayout/favicon.ico] not found from filesystem or through class loader. Add widgetset and/or theme JAR to your classpath or add files to WebContent/VAADIN folder.");
        last.addComponent(foo);

        for (int i = 0; i < 10; i++) {
            VerticalLayout l = new VerticalLayout();
            l.setSizeFull();
            last.addComponent(l);
            last.setExpandRatio(l, 1);

            VerticalLayout l2 = new VerticalLayout();
            l2.setSizeFull();
            last.addComponent(l2);
            last.setExpandRatio(l2, 10);
            last = l2;
        }
        foo = new Label("Foobar 1");
        foo.setSizeUndefined();
        last.addComponent(foo);
        last.setComponentAlignment(foo, "middle center");

        foo = new Label("Foobar 2");
        foo.setSizeFull();
        last.addComponent(foo);
        last.setExpandRatio(foo, 1);
    }
}
