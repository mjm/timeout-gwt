package net.moriaritys.timeout.client.controller;

import com.google.gwt.user.client.ui.HasWidgets;
import com.google.inject.Inject;
import net.moriaritys.timeout.client.root.RootPresenter;

/**
 *
 */
public class TimeoutController {
    private RootPresenter root;

    @Inject
    TimeoutController(final RootPresenter root) {
        this.root = root;
    }

    public void go(final HasWidgets container) {
        container.clear();
        container.add(root.getDisplay().asWidget());

        root.bind();
    }
}
