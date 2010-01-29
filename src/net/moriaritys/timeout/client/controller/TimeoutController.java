package net.moriaritys.timeout.client.controller;

import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Label;
import com.google.inject.Inject;

/**
 *
 */
public class TimeoutController {
    private HasWidgets container;

    @Inject
    TimeoutController() {

    }

    public void go(final HasWidgets container) {
        this.container = container;

        container.clear();
        container.add(new Label("Loaded..."));
    }
}
