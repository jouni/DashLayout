package org.vaadin.jouni.dashlayout.tests.jflamy;

import org.vaadin.jouni.dashlayout.ui.HorDashLayout;

import com.vaadin.ui.Alignment;
import com.vaadin.ui.Label;
import com.vaadin.ui.Window;

public class LoadImage extends HorDashLayout {
    private static final long serialVersionUID = 8340222363211435843L;

    private int weight;
    private Window parentWindow;

    public LoadImage() {
        super();
        addStyleName("loadChart");
        setMargin(false);
    }

    public LoadImage(Window parentWindow) {
        this();
        this.parentWindow = parentWindow;
    }

    public void computeImageArea(Platform platform) {
        final Integer barWeight = computeBarWeight(platform);
        weight = 200;
        final String caption = weight + "kg";
        createImageArea(platform, barWeight, caption);
    }

    private void createImageArea(Platform platform, final Integer barWeight,
            final String caption) {
        removeAllComponents();
        setCaption(caption);

        // compute the bar and collar first.
        addPlates(1, "bar", barWeight);
        addPlates(1, "barInner", 0);
        final Integer collarAvailable = platform.getNbC_2_5();
        if (collarAvailable > 0) {
            // we subtract the collar weight but don't display it YET
            // it must always be used in preference to the plates.
            weight -= 5;
        }

        // use large plates first
        addPlates(platform.getNbL_25(), "L_25", 2 * 25);
        addPlates(platform.getNbL_20(), "L_20", 2 * 20);
        addPlates(platform.getNbL_15(), "L_15", 2 * 15);
        addPlates(platform.getNbL_10(), "L_10", 2 * 10);
        addPlates(platform.getNbL_5(), "L_5", 2 * 5);
        addPlates(platform.getNbL_2_5(), "L_2_5", 2 * 2.5);

        // then small plates
        addPlates(platform.getNbS_5(), "S_5", 2 * 5);
        addPlates(platform.getNbS_2_5(), "S_2_5", 2 * 2.5);
        // collar is depicted here
        if (collarAvailable > 0) {
            // we add back the collar weight we took off above
            weight += 5;
            // then we compute whether the collar is needed
            addPlates(collarAvailable, "C_2_5", 2 * 2.5);
        }
        // remainder of small plates
        addPlates(platform.getNbS_2(), "S_2", 2 * 2);
        addPlates(platform.getNbS_1_5(), "S_1_5", 2 * 1.5);
        addPlates(platform.getNbS_1(), "S_1", 2 * 1);
        addPlates(platform.getNbS_0_5(), "S_0_5", 2 * 0.5);
        addPlates(1, "barOuter", 0);
    }

    private int addPlates(Integer availablePlates, String style,
            double plateWeight) {
        int subtractedWeight = 0;
        while (availablePlates > 0 && weight >= plateWeight) {
            Label plate = new Label();
            plate.addStyleName(style);
            if (!style.startsWith("bar")) {
                plate.addStyleName("plate");
            }
            this.addComponent(plate);
            this.setComponentAlignment(plate, Alignment.MIDDLE_CENTER);
            final long delta = Math.round(plateWeight);
            weight -= delta;
            subtractedWeight += delta;
            availablePlates--;
        }
        return subtractedWeight;
    }

    private Integer computeBarWeight(Platform platform) {
        return computeOfficialBarWeight(platform);
    }

    private Integer computeOfficialBarWeight(Platform platform) {
        String gender = "M";
        final int expectedBarWeight = "M".equals(gender) ? 20 : 15;
        return expectedBarWeight;
    }

    @Override
    public void setCaption(String caption) {
        if (parentWindow == null) {
            super.setCaption(caption);
        } else {
            parentWindow.setCaption(caption);
        }
    }

}
