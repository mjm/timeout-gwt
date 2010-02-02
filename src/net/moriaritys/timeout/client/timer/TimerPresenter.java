package net.moriaritys.timeout.client.timer;

import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.HasValue;
import com.google.inject.Inject;
import net.customware.gwt.presenter.client.EventBus;
import net.customware.gwt.presenter.client.widget.WidgetDisplay;
import net.customware.gwt.presenter.client.widget.WidgetPresenter;
import net.moriaritys.timeout.client.timer.TimerPresenter.Display;
import net.moriaritys.timeout.shared.data.WorkLog;
import net.moriaritys.timeout.shared.data.WorkLogEntry;

/**
 *
 */
public class TimerPresenter extends WidgetPresenter<Display> {
    public static interface Display extends WidgetDisplay {
        HasText getStartLabel();

        HasValue<String> getHoursNeededField();

        HasText getEstimatedDepartureLabel();

        HasText getTimeElapsedLabel();

        HasText getTimeLeftLabel();

        HasClickHandlers getStartStopButton();
    }

    private WorkLog log;
    private WorkLogEntry entry;

    @Inject
    TimerPresenter(final Display display, final EventBus eventBus) {
        super(display, eventBus);
    }

    public void setLog(final WorkLog log) {
        this.log = log;
    }

    public void setEntry(final WorkLogEntry entry) {
        this.entry = entry;
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
