package net.moriaritys.timeout.client.root;

import com.google.inject.Inject;
import net.customware.gwt.presenter.client.EventBus;
import net.customware.gwt.presenter.client.widget.WidgetContainerDisplay;
import net.customware.gwt.presenter.client.widget.WidgetContainerPresenter;
import net.moriaritys.timeout.client.root.RootPresenter.Display;
import net.moriaritys.timeout.client.today.TodayPresenter;

/**
 *
 */
public class RootPresenter extends WidgetContainerPresenter<Display> {
    public interface Display extends WidgetContainerDisplay {

    }

    @Inject
    RootPresenter(final Display display, final EventBus eventBus, final TodayPresenter today) {
        super(display, eventBus, today);
    }

    @Override
    protected void onBind() {
        super.onBind();
    }

    @Override
    protected void onUnbind() {
    }

    @Override
    protected void onRevealDisplay() {
    }
}
