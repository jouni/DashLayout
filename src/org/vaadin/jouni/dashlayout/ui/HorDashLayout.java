package org.vaadin.jouni.dashlayout.ui;

import org.vaadin.jouni.dashlayout.client.ui.VDashLayout;

import com.vaadin.terminal.PaintException;
import com.vaadin.terminal.PaintTarget;
import com.vaadin.ui.ClientWidget;
import com.vaadin.ui.HorizontalLayout;

@SuppressWarnings("serial")
@ClientWidget(VDashLayout.class)
public class HorDashLayout extends HorizontalLayout {
    @Override
    public void paintContent(PaintTarget target) throws PaintException {
        target.addAttribute("horizontal", true);
        super.paintContent(target);
    }

}
