package net.moriaritys.timeout.client.timer;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.HasValue;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import net.customware.gwt.dispatch.client.DispatchAsync;
import net.customware.gwt.presenter.client.EventBus;
import net.customware.gwt.presenter.client.widget.WidgetDisplay;
import net.customware.gwt.presenter.client.widget.WidgetPresenter;
import net.moriaritys.timeout.client.callback.GotLogEntry;
import net.moriaritys.timeout.client.convert.DurationConverter;
import net.moriaritys.timeout.client.convert.TimeConverter;
import net.moriaritys.timeout.client.timer.TimerPresenter.Display;
import net.moriaritys.timeout.shared.action.StartTimer;
import net.moriaritys.timeout.shared.data.WorkLog;
import net.moriaritys.timeout.shared.data.WorkLogEntry;

/**
 *
 */
@Singleton
public class TimerPresenter extends WidgetPresenter<Display> {
    public static interface Display extends WidgetDisplay {
        HasText getStartLabel();

        HasValue<String> getHoursNeededField();

        HasText getEstimatedDepartureLabel();

        HasText getTimeElapsedLabel();

        HasText getTimeLeftLabel();

        HasClickHandlers getStartStopButton();
    }

    private class UpdateTimer extends Timer {
        @Override
        public void run() {
            if (log != null && entry != null) {
                updateTimes();
            }
        }
    }

    private class HoursNeededChanged implements ValueChangeHandler<String> {
        @Override
        public void onValueChange(final ValueChangeEvent<String> event) {
            log.setGoal(durationConverter.from(event.getValue()));
            updateDisplay();
        }
    }

    private class StartStopClicked implements ClickHandler {
        @Override
        public void onClick(final ClickEvent clickEvent) {
            dispatch.execute(new StartTimer(log), new GotLogEntry() {
                @Override
                protected void got(final WorkLogEntry entry) {
                    setEntry(entry);
                }
            });
        }
    }

    private WorkLog log;
    private WorkLogEntry entry;

    private final Timer updateTimer = new UpdateTimer();

    private final DispatchAsync dispatch;
    private final DurationConverter durationConverter;
    private final TimeConverter timeConverter;

    @Inject
    TimerPresenter(final Display display, final EventBus eventBus, final DispatchAsync dispatch,
                   final DurationConverter durationConverter,
                   final TimeConverter timeConverter) {
        super(display, eventBus);
        this.dispatch = dispatch;
        this.durationConverter = durationConverter;
        this.timeConverter = timeConverter;

        bind();
    }

    public void setLog(final WorkLog log) {
        this.log = log;
    }

    public void setEntry(final WorkLogEntry entry) {
        this.entry = entry;
    }

    @Override
    protected void onBind() {
        registerHandler(display.getHoursNeededField().addValueChangeHandler(new HoursNeededChanged()));
        registerHandler(display.getStartStopButton().addClickHandler(new StartStopClicked()));

        updateTimer.scheduleRepeating(1000);
    }

    @Override
    protected void onUnbind() {
        updateTimer.cancel();
    }

    @Override
    protected void onRevealDisplay() {
        updateDisplay();
        updateTimes();
    }

    private void updateDisplay() {
        String goal = durationConverter.to(log.getGoal(), false);
        String start = timeConverter.to(entry.getStartTime());
        String end = timeConverter.to(log.getEstimatedEndTime());

        display.getHoursNeededField().setValue(goal);
        display.getStartLabel().setText(start);
        display.getEstimatedDepartureLabel().setText(end);
    }

    private void updateTimes() {
        String elapsed = durationConverter.to(entry.getTimeElapsed());
        String left = durationConverter.to(log.getTimeLeft());

        display.getTimeElapsedLabel().setText(elapsed);
        display.getTimeLeftLabel().setText(left);
    }
}
