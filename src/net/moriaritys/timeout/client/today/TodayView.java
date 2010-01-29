package net.moriaritys.timeout.client.today;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DockLayoutPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import net.moriaritys.timeout.client.today.TodayPresenter.Display;

/**
 *
 */
public class TodayView extends Composite implements Display {
    static interface Binder extends UiBinder<DockLayoutPanel, TodayView> {}

    private static final Binder binder = GWT.create(Binder.class);

    @Inject
    TodayView() {
        DockLayoutPanel panel = binder.createAndBindUi(this);
        initWidget(panel);
    }

    @Override
    public Widget asWidget() {
        return this;
    }
}
