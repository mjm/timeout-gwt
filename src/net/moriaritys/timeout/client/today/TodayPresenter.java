package net.moriaritys.timeout.client.today;

import com.google.inject.Inject;
import net.customware.gwt.presenter.client.EventBus;
import net.customware.gwt.presenter.client.widget.WidgetDisplay;
import net.customware.gwt.presenter.client.widget.WidgetPresenter;
import net.moriaritys.timeout.client.today.TodayPresenter.Display;

/**
 *
 */
public class TodayPresenter extends WidgetPresenter<Display> {
    public static interface Display extends WidgetDisplay {

    }

    @Inject
    TodayPresenter(final Display display, final EventBus eventBus) {
        super(display, eventBus);
    }

    @Override
    protected void onBind() {
    }

    @Override
    protected void onUnbind() {
    }

    @Override
    protected void onRevealDisplay() {
    }
}
