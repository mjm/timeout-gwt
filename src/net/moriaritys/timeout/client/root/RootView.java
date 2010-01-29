package net.moriaritys.timeout.client.root;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DockLayoutPanel;
import com.google.gwt.user.client.ui.TabLayoutPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import net.moriaritys.timeout.client.root.RootPresenter.Display;
import net.moriaritys.timeout.client.today.TodayView;

/**
 *
 */
public class RootView extends Composite implements Display {
    static interface Binder extends UiBinder<DockLayoutPanel, RootView> {}

    private static final Binder binder = GWT.create(Binder.class);

    @UiField
    TabLayoutPanel tabPanel;

    @Inject
    RootView() {
        DockLayoutPanel panel = binder.createAndBindUi(this);
        initWidget(panel);
    }

    @Override
    public void addWidget(final Widget widget) {
        String tabTitle = "unnamed tab";
        if (widget instanceof TodayView) {
            tabTitle = "Today";
        }
        tabPanel.add(widget, tabTitle);
    }

    @Override
    public void removeWidget(final Widget widget) {
        tabPanel.remove(widget);
    }

    @Override
    public void showWidget(final Widget widget) {
        tabPanel.selectTab(widget);
    }

    @Override
    public Widget asWidget() {
        return this;
    }
}
