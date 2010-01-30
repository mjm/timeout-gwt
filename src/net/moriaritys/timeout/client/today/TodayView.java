package net.moriaritys.timeout.client.today;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.*;
import com.google.inject.Inject;
import net.moriaritys.timeout.client.today.TodayPresenter.Display;

/**
 *
 */
public class TodayView extends Composite implements Display {
    static interface Binder extends UiBinder<DockLayoutPanel, TodayView> {}

    private static final Binder binder = GWT.create(Binder.class);

    @UiField
    Label label;

    @Inject
    TodayView() {
        DockLayoutPanel panel = binder.createAndBindUi(this);
        initWidget(panel);
    }

    @Override
    public Widget asWidget() {
        return this;
    }

    @Override
    public HasText getLabel() {
        return label;
    }
}
